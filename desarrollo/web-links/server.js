const http = require('http');
const url  = require('url');

const AUTH_API = 'https://gestion-ets-auth-api-production.up.railway.app';
const PORT     =  8083;

// ---------- HTML helpers ----------
function page(title, body) {
  return `<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>${title} — ETS ESCOM</title>
  <style>
    *{box-sizing:border-box;margin:0;padding:0}
    body{font-family:-apple-system,BlinkMacSystemFont,'Segoe UI',sans-serif;
         background:#F5F7FF;min-height:100vh;display:flex;
         align-items:center;justify-content:center;padding:24px}
    .card{background:#fff;border-radius:20px;padding:36px 28px;max-width:420px;
          width:100%;box-shadow:0 4px 24px rgba(0,0,0,.08);text-align:center}
    .logo{font-size:13px;color:#6B6B6B;letter-spacing:1px;margin-bottom:20px}
    .icon{font-size:56px;margin-bottom:16px}
    h1{font-size:22px;font-weight:700;color:#1A237E;margin-bottom:8px}
    p{font-size:14px;color:#6B6B6B;line-height:1.5;margin-bottom:20px}
    .btn{display:block;width:100%;padding:14px;border:none;border-radius:12px;
         font-size:16px;font-weight:600;cursor:pointer;text-decoration:none;
         background:#1A237E;color:#fff;margin-top:8px}
    .btn:hover{opacity:.9}
    .btn.secondary{background:#f5f5f5;color:#1A237E;border:1px solid #e0e0e0;margin-top:10px}
    input{width:100%;padding:13px 16px;border:1.5px solid #e0e0e0;border-radius:12px;
          font-size:15px;margin-bottom:12px;outline:none}
    input:focus{border-color:#1A237E}
    .error{background:#FFEBEE;color:#C62828;border-radius:8px;padding:10px 14px;
           font-size:13px;margin-bottom:12px;text-align:left}
    .success-pill{background:#E8F5E9;color:#2E7D32;border-radius:8px;padding:8px 14px;
                  font-size:13px;font-weight:600}
  </style>
</head>
<body><div class="card">${body}</div></body>
</html>`;
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
    res.end(page('Error', `<div class="icon">❌</div><h1>Token inválido</h1><p>No se proporcionó un token de verificación.</p>`));
    return;
  }
  const r = await apiFetch(`/auth?token=${encodeURIComponent(token)}`, 'POST');
  if (r.ok && r.data === true) {
    res.writeHead(200, { 'Content-Type': 'text/html; charset=utf-8' });
    res.end(page('Cuenta confirmada', `
      <div class="logo">ETS ESCOM</div>
      <div class="icon">✅</div>
      <h1>¡Cuenta verificada!</h1>
      <p>Tu cuenta ha sido confirmada exitosamente.<br>Ya puedes iniciar sesión en la app.</p>
      <span class="success-pill">HTTP ${r.status} · Verificación completada</span>
    `));
  } else {
    const msg = r.data?.details?.[0]?.message || r.data?.message || 'Error desconocido';
    res.writeHead(r.status, { 'Content-Type': 'text/html; charset=utf-8' });
    res.end(page('Error de verificación', `
      <div class="logo">ETS ESCOM</div>
      <div class="icon">⚠️</div>
      <h1>No se pudo verificar</h1>
      <div class="error"><b>HTTP ${r.status}</b> · ${msg}</div>
      <p>El enlace puede haber expirado o ya fue utilizado.</p>
    `));
  }
}

function serveResetForm(token, errorMsg, res) {
  const err = errorMsg ? `<div class="error">${errorMsg}</div>` : '';
  res.writeHead(200, { 'Content-Type': 'text/html; charset=utf-8' });
  res.end(page('Recuperar contraseña', `
    <div class="logo">ETS ESCOM</div>
    <div class="icon">🔑</div>
    <h1>Nueva contraseña</h1>
    <p>Ingresa y confirma tu nueva contraseña.</p>
    ${err}
    <form method="POST" action="/nueva-password">
      <input type="hidden" name="token" value="${token}">
      <input type="password" name="password" placeholder="Nueva contraseña" required minlength="8">
      <input type="password" name="confirm"  placeholder="Confirmar contraseña" required minlength="8">
      <button type="submit" class="btn">Guardar contraseña</button>
    </form>
  `));
}

async function handleOlvidarContrasenia(token, res) {
  if (!token) {
    res.writeHead(400, { 'Content-Type': 'text/html; charset=utf-8' });
    res.end(page('Error', `<div class="icon">❌</div><h1>Token inválido</h1><p>No se proporcionó un token.</p>`));
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
      <div class="logo">ETS ESCOM</div>
      <div class="icon">✅</div>
      <h1>¡Contraseña actualizada!</h1>
      <p>Tu contraseña ha sido cambiada exitosamente.<br>Ya puedes iniciar sesión en la app.</p>
      <span class="success-pill">HTTP ${r.status} · Contraseña guardada</span>
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
    res.end(page('Error interno', `<div class="icon">💥</div><h1>Error interno</h1><p>${e.message}</p>`));
  }
});

server.listen(PORT, () => console.log(`Web-links server corriendo en http://localhost:${PORT}`));
