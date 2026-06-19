const http = require('http');
const url  = require('url');

const AUTH_API = 'https://gestion-ets-auth-api-production.up.railway.app';
const PORT     =  8083;

// ---------- HTML helpers ----------
function page(title, body, opts = {}) {
  const { showLogo = true } = opts;
  return `<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>${title} — ETS ESCOM</title>
  <style>
    *{box-sizing:border-box;margin:0;padding:0}

    body{
      font-family:-apple-system,BlinkMacSystemFont,'Segoe UI',Roboto,sans-serif;
      background:#F5F7FF;
      min-height:100vh;
      display:flex;
      align-items:center;
      justify-content:center;
      padding:24px;
      color:#1A1A2E;
    }

    .card{
      background:#fff;
      border-radius:24px;
      max-width:420px;
      width:100%;
      overflow:hidden;
      box-shadow:0 12px 40px rgba(26,35,126,.16);
      text-align:center;
    }

    /* ---- Header: degradado azul con esquinas curvas tipo app ---- */
    .header{
      background:linear-gradient(135deg,#1A237E 0%,#3949AB 60%,#1565C0 100%);
      padding:34px 28px 56px;
      position:relative;
      color:#fff;
    }
    .header::after{
      content:'';
      position:absolute;
      left:0; right:0; bottom:-1px;
      height:32px;
      background:#fff;
      border-radius:32px 32px 0 0;
    }
    .logo-tag{
      font-size:12px;
      font-weight:700;
      letter-spacing:1.5px;
      opacity:.85;
      text-transform:uppercase;
      margin-bottom:14px;
    }
    .icon-circle{
      width:64px;
      height:64px;
      margin:0 auto 6px;
      border-radius:50%;
      background:rgba(255,255,255,.16);
      display:flex;
      align-items:center;
      justify-content:center;
      font-size:32px;
    }
    .header h1{
      font-size:21px;
      font-weight:700;
      margin-top:10px;
    }

    /* ---- Body content ---- */
    .content{
      padding:8px 28px 32px;
      margin-top:-24px;
    }
    .content p{
      font-size:14px;
      color:#6B6B6B;
      line-height:1.55;
      margin-bottom:22px;
    }

    .btn{
      display:block;
      width:100%;
      padding:15px;
      border:none;
      border-radius:14px;
      font-size:16px;
      font-weight:700;
      cursor:pointer;
      text-decoration:none;
      background:linear-gradient(135deg,#1A237E 0%,#1565C0 100%);
      color:#fff;
      box-shadow:0 6px 18px rgba(26,35,126,.28);
      transition:opacity .15s ease, transform .15s ease;
    }
    .btn:hover{opacity:.92;transform:translateY(-1px)}
    .btn.secondary{
      background:#F5F7FF;
      color:#1A237E;
      border:1.5px solid #E3E7FB;
      box-shadow:none;
      margin-top:10px;
    }

    input{
      width:100%;
      padding:14px 16px;
      border:1.5px solid #E3E7FB;
      background:#F5F7FF;
      border-radius:14px;
      font-size:15px;
      margin-bottom:12px;
      outline:none;
      color:#1A1A2E;
      transition:border-color .15s ease;
    }
    input::placeholder{color:#9AA0C3}
    input:focus{border-color:#1A237E;background:#fff}

    .error{
      background:#FFEBEE;
      color:#C62828;
      border-radius:12px;
      padding:12px 16px;
      font-size:13px;
      margin-bottom:16px;
      text-align:left;
      font-weight:500;
    }

    .pill{
      display:inline-flex;
      align-items:center;
      gap:6px;
      border-radius:999px;
      padding:7px 16px;
      font-size:13px;
      font-weight:700;
    }
    .pill.success{background:#E8F5E9;color:#2E7D32}
    .pill.info{background:#E3F2FD;color:#1565C0}

    .footer-note{
      margin-top:18px;
      font-size:12px;
      color:#9AA0C3;
    }
  </style>
</head>
<body><div class="card">${body}</div></body>
</html>`;
}

function headerBlock(icon, eyebrow, heading) {
  return `
    <div class="header">
      ${eyebrow ? `<div class="logo-tag">${eyebrow}</div>` : ''}
      <div class="icon-circle">${icon}</div>
      <h1>${heading}</h1>
    </div>`;
}

// ---------- Fetch helper (node 22 has native fetch) ----------
async function apiFetch(path, method = 'GET', body = null) {
  const opts = { method, headers: { 'Content-Type': 'application/json' } };
  if (body) opts.body = JSON.stringify(body);
  const res = await fetch(AUTH_API + path, opts);
  const text = await res.text();
  let json;
  try { json = JSON.parse(text); } catch { json = text; }
  return { status: res.status, ok: res.ok, data: json };
}

// ---------- Routes ----------
async function handleConfirmar(token, res) {
  if (!token) {
    res.writeHead(400, { 'Content-Type': 'text/html; charset=utf-8' });
    res.end(page('Error', `
      ${headerBlock('❌', 'ETS ESCOM', 'Token inválido')}
      <div class="content">
        <p>No se proporcionó un token de verificación.</p>
      </div>
    `));
    return;
  }

  const r = await apiFetch(`/auth?token=${encodeURIComponent(token)}`, 'POST');

  if (r.ok && r.data === true) {
    res.writeHead(200, { 'Content-Type': 'text/html; charset=utf-8' });
    res.end(page('Cuenta confirmada', `
      ${headerBlock('✅', 'ETS ESCOM', '¡Cuenta verificada!')}
      <div class="content">
        <p>Tu cuenta ha sido confirmada exitosamente.<br>Ya puedes iniciar sesión en la app.</p>
        <span class="pill success">HTTP ${r.status} · Verificación completada</span>
      </div>
    `));
  } else {
    const msg = r.data?.details?.[0]?.message || r.data?.message || 'Error desconocido';
    res.writeHead(r.status, { 'Content-Type': 'text/html; charset=utf-8' });
    res.end(page('Error de verificación', `
      ${headerBlock('⚠️', 'ETS ESCOM', 'No se pudo verificar')}
      <div class="content">
        <div class="error"><b>HTTP ${r.status}</b> · ${msg}</div>
        <p>El enlace puede haber expirado o ya fue utilizado.</p>
      </div>
    `));
  }
}

function serveResetForm(token, errorMsg, res) {
  const err = errorMsg ? `<div class="error">${errorMsg}</div>` : '';
  res.writeHead(200, { 'Content-Type': 'text/html; charset=utf-8' });
  res.end(page('Recuperar contraseña', `
    ${headerBlock('🔒', 'ETS ESCOM', 'Nueva contraseña')}
    <div class="content">
      <p>Ingresa y confirma tu nueva contraseña.</p>
      ${err}
      <form method="POST" action="/nueva-password">
        <input type="hidden" name="token" value="${token}">
        <input type="password" name="password" placeholder="Nueva contraseña" required minlength="8">
        <input type="password" name="confirm"  placeholder="Confirmar contraseña" required minlength="8">
        <button type="submit" class="btn">Guardar contraseña</button>
      </form>
    </div>
  `));
}

async function handleOlvidarContrasenia(token, res) {
  if (!token) {
    res.writeHead(400, { 'Content-Type': 'text/html; charset=utf-8' });
    res.end(page('Error', `
      ${headerBlock('❌', 'ETS ESCOM', 'Token inválido')}
      <div class="content">
        <p>No se proporcionó un token.</p>
      </div>
    `));
    return;
  }
  serveResetForm(token, null, res);
}

async function handleNuevaPassword(bodyStr, res) {
  const params = new URLSearchParams(bodyStr);
  const token    = params.get('token')    || '';
  const password = params.get('password') || '';
  const confirm  = params.get('confirm')  || '';

  if (password !== confirm) {
    serveResetForm(token, 'Las contraseñas no coinciden.', res);
    return;
  }
  if (password.length < 8) {
    serveResetForm(token, 'La contraseña debe tener al menos 8 caracteres.', res);
    return;
  }

  const r = await apiFetch('/auth/update-password', 'POST', { token, password });
  if (r.ok && r.data === true) {
    res.writeHead(200, { 'Content-Type': 'text/html; charset=utf-8' });
    res.end(page('Contraseña actualizada', `
      ${headerBlock('✅', 'ETS ESCOM', '¡Contraseña actualizada!')}
      <div class="content">
        <p>Tu contraseña ha sido cambiada exitosamente.<br>Ya puedes iniciar sesión en la app.</p>
        <span class="pill success">HTTP ${r.status} · Contraseña guardada</span>
      </div>
    `));
  } else {
    const msg = r.data?.details?.[0]?.message || r.data?.message || 'Error desconocido';
    serveResetForm(token, `<b>HTTP ${r.status}</b> · ${msg}`, res);
  }
}

// ---------- Server ----------
const server = http.createServer(async (req, res) => {
  const parsed = url.parse(req.url, true);
  const path   = parsed.pathname;
  const token  = parsed.query.token || '';

  try {
    if (req.method === 'GET' && path === '/confirmar-cuenta') {
      await handleConfirmar(token, res);
    } else if (req.method === 'GET' && ( path === '/contrasena-olvidada')) {
      await handleOlvidarContrasenia(token, res);
    } else if (req.method === 'POST' && path === '/nueva-password') {
      let body = '';
      req.on('data', chunk => body += chunk);
      req.on('end', () => handleNuevaPassword(body, res));
    } else {
      res.writeHead(404, { 'Content-Type': 'text/plain' });
      res.end('Not found');
    }
  } catch (e) {
    res.writeHead(500, { 'Content-Type': 'text/html; charset=utf-8' });
    res.end(page('Error interno', `
      ${headerBlock('💥', 'ETS ESCOM', 'Error interno')}
      <div class="content"><p>${e.message}</p></div>
    `));
  }
});

server.listen(PORT, () => console.log(`Web-links server corriendo en http://localhost:${PORT}`));