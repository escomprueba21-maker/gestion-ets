const http = require('http');
const url  = require('url');

const AUTH_API = 'https://gestion-ets-auth-api-production.up.railway.app';
const PORT     = 8083;

// ---------- SVG icons ----------
const ICONS = {
  check: `<svg viewBox="0 0 24 24" width="32" height="32" fill="none" stroke="#fff" stroke-width="1.8" stroke-linecap="round" stroke-linejoin="round"><polyline points="20 6 9 17 4 12"/></svg>`,
  lock:  `<svg viewBox="0 0 24 24" width="32" height="32" fill="none" stroke="#fff" stroke-width="1.8" stroke-linecap="round" stroke-linejoin="round"><rect x="3" y="11" width="18" height="11" rx="2"/><path d="M7 11V7a5 5 0 0 1 10 0v4"/></svg>`,
  warn:  `<svg viewBox="0 0 24 24" width="32" height="32" fill="none" stroke="#fff" stroke-width="1.8" stroke-linecap="round" stroke-linejoin="round"><path d="M10.29 3.86L1.82 18a2 2 0 0 0 1.71 3h16.94a2 2 0 0 0 1.71-3L13.71 3.86a2 2 0 0 0-3.42 0z"/><line x1="12" y1="9" x2="12" y2="13"/><line x1="12" y1="17" x2="12.01" y2="17"/></svg>`,
  error: `<svg viewBox="0 0 24 24" width="32" height="32" fill="none" stroke="#fff" stroke-width="1.8" stroke-linecap="round" stroke-linejoin="round"><circle cx="12" cy="12" r="10"/><line x1="15" y1="9" x2="9" y2="15"/><line x1="9" y1="9" x2="15" y2="15"/></svg>`,
};

// ---------- HTML helpers ----------
function page(title, body) {
  return `<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>${title} — ETS ESCOM</title>
  <style>
    *, *::before, *::after { box-sizing: border-box; margin: 0; padding: 0; }

    body {
      font-family: -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, sans-serif;
      background: #F5F7FF;
      min-height: 100vh;
      display: flex;
      align-items: center;
      justify-content: center;
      padding: 24px;
      color: #1A1A2E;
    }

    .card {
      background: #fff;
      border-radius: 24px;
      max-width: 420px;
      width: 100%;
      overflow: hidden;
      box-shadow: 0 12px 40px rgba(26, 35, 126, .16);
      text-align: center;
    }

    .header {
      background: #1A237E;
      padding: 34px 28px 44px;
      position: relative;
      color: #fff;
    }
    .header--danger { background: #7F1D1D; }
    .header::after {
      content: '';
      position: absolute;
      left: 0; right: 0; bottom: -1px;
      height: 32px;
      background: #fff;
      border-radius: 32px 32px 0 0;
    }

    .header__label {
      font-size: 12px;
      font-weight: 600;
      letter-spacing: 1.5px;
      opacity: .8;
      text-transform: uppercase;
      margin-bottom: 14px;
    }
    .header__icon {
      width: 64px;
      height: 64px;
      margin: 0 auto 6px;
      border-radius: 50%;
      background: rgba(255, 255, 255, .15);
      display: flex;
      align-items: center;
      justify-content: center;
    }
    .header h1 { font-size: 21px; font-weight: 700; margin-top: 10px; }

    .content {
      padding: 24px 28px 32px;
    }
    .content p {
      font-size: 14px;
      color: #6B6B6B;
      line-height: 1.6;
      margin-bottom: 22px;
    }

    .btn {
      display: block;
      width: 100%;
      padding: 15px;
      border: none;
      border-radius: 14px;
      font-size: 16px;
      font-weight: 700;
      cursor: pointer;
      text-decoration: none;
      background: #1A237E;
      color: #fff;
      transition: opacity .15s, transform .15s;
    }
    .btn:hover { opacity: .9; transform: translateY(-1px); }

    input {
      width: 100%;
      padding: 14px 16px;
      border: 1.5px solid #E3E7FB;
      background: #F5F7FF;
      border-radius: 14px;
      font-size: 15px;
      margin-bottom: 12px;
      outline: none;
      color: #1A1A2E;
      transition: border-color .15s;
    }
    input::placeholder { color: #9AA0C3; }
    input:focus { border-color: #1A237E; background: #fff; }

    .alert {
      border-radius: 12px;
      padding: 12px 16px;
      font-size: 13px;
      margin-bottom: 16px;
      text-align: left;
      font-weight: 500;
    }
    .alert--error { background: #FFEBEE; color: #C62828; }

    .badge {
      display: inline-flex;
      align-items: center;
      gap: 6px;
      border-radius: 999px;
      padding: 7px 16px;
      font-size: 13px;
      font-weight: 600;
    }
    .badge--success { background: #E8F5E9; color: #2E7D32; }
  </style>
</head>
<body><div class="card">${body}</div></body>
</html>`;
}

function headerBlock(icon, eyebrow, heading, modifier = '') {
  return `
    <div class="header${modifier ? ` header--${modifier}` : ''}">
      ${eyebrow ? `<div class="header__label">${eyebrow}</div>` : ''}
      <div class="header__icon">${icon}</div>
      <h1>${heading}</h1>
    </div>`;
}

// ---------- Fetch helper ----------
async function apiFetch(path, method = 'GET', body = null) {
  const opts = { method, headers: { 'Content-Type': 'application/json' } };
  if (body) opts.body = JSON.stringify(body);
  const res  = await fetch(AUTH_API + path, opts);
  const text = await res.text();
  let json;
  try { json = JSON.parse(text); } catch { json = text; }
  return { status: res.status, ok: res.ok, data: json };
}

// ---------- Routes ----------
async function handleConfirmarCuenta(token, res) {
  if (!token) {
    res.writeHead(400, { 'Content-Type': 'text/html; charset=utf-8' });
    res.end(page('Token inválido', `
      ${headerBlock(ICONS.error, 'ETS ESCOM', 'Enlace inválido', 'danger')}
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
      ${headerBlock(ICONS.check, 'ETS ESCOM', 'Cuenta verificada')}
      <div class="content">
        <p>Tu cuenta ha sido confirmada exitosamente.<br>Ya puedes iniciar sesión en la app.</p>
        <span class="badge badge--success">Verificación completada</span>
      </div>
    `));
  } else {
    const msg = r.data?.details?.[0]?.message || r.data?.message || 'El enlace puede haber expirado o ya fue utilizado.';
    res.writeHead(400, { 'Content-Type': 'text/html; charset=utf-8' });
    res.end(page('Error de verificación', `
      ${headerBlock(ICONS.warn, 'ETS ESCOM', 'No se pudo verificar', 'danger')}
      <div class="content">
        <div class="alert alert--error">${msg}</div>
        <p>Solicita un nuevo enlace desde la aplicación.</p>
      </div>
    `));
  }
}

function serveResetForm(token, errorMsg, res) {
  const err = errorMsg ? `<div class="alert alert--error">${errorMsg}</div>` : '';
  res.writeHead(200, { 'Content-Type': 'text/html; charset=utf-8' });
  res.end(page('Nueva contraseña', `
    ${headerBlock(ICONS.lock, 'ETS ESCOM', 'Nueva contraseña')}
    <div class="content">
      <p>Ingresa y confirma tu nueva contraseña.</p>
      ${err}
      <form method="POST" action="/nueva-contrasena">
        <input type="hidden" name="token" value="${token}">
        <input type="password" name="password" placeholder="Nueva contraseña" required minlength="8" autocomplete="new-password">
        <input type="password" name="confirm"  placeholder="Confirmar contraseña" required minlength="8" autocomplete="new-password">
        <button type="submit" class="btn">Guardar contraseña</button>
      </form>
    </div>
  `));
}

async function handleContrasenaOlvidada(token, res) {
  if (!token) {
    res.writeHead(400, { 'Content-Type': 'text/html; charset=utf-8' });
    res.end(page('Token inválido', `
      ${headerBlock(ICONS.error, 'ETS ESCOM', 'Enlace inválido', 'danger')}
      <div class="content">
        <p>No se proporcionó un token de recuperación.</p>
      </div>
    `));
    return;
  }
  serveResetForm(token, null, res);
}

async function handleNuevaContrasena(bodyStr, res) {
  const params   = new URLSearchParams(bodyStr);
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
      ${headerBlock(ICONS.check, 'ETS ESCOM', 'Contraseña actualizada')}
      <div class="content">
        <p>Tu contraseña ha sido cambiada exitosamente.<br>Ya puedes iniciar sesión en la app.</p>
        <span class="badge badge--success">Contraseña guardada</span>
      </div>
    `));
  } else {
    const msg = r.data?.details?.[0]?.message || r.data?.message || 'No se pudo actualizar la contraseña.';
    serveResetForm(token, msg, res);
  }
}

// ---------- Server ----------
const PATHS_CONTRASENA_OLVIDADA = new Set([
  '/contrasena-olvidada',
  '/contrase%C3%B1a-olvidada',
  '/contrase%EF%BF%BD%EF%BF%BDa-olvidada',
]);

const server = http.createServer(async (req, res) => {
  const parsed   = url.parse(req.url, true);
  const pathname = parsed.pathname;
  const token    = parsed.query.token || '';

  try {
    if (req.method === 'GET' && pathname === '/confirmar-cuenta') {
      await handleConfirmarCuenta(token, res);

    } else if (req.method === 'GET' && PATHS_CONTRASENA_OLVIDADA.has(pathname)) {
      await handleContrasenaOlvidada(token, res);

    } else if (req.method === 'POST' && pathname === '/nueva-contrasena') {
      let body = '';
      req.on('data', chunk => (body += chunk));
      req.on('end', () => handleNuevaContrasena(body, res));

    } else {
      res.writeHead(404, { 'Content-Type': 'text/plain' });
      res.end('Not found');
    }
  } catch (err) {
    console.error('[web-links] error interno:', err);
    res.writeHead(500, { 'Content-Type': 'text/html; charset=utf-8' });
    res.end(page('Error interno', `
      ${headerBlock(ICONS.error, 'ETS ESCOM', 'Error interno', 'danger')}
      <div class="content">
        <p>Ocurrió un error inesperado. Inténtalo más tarde.</p>
      </div>
    `));
  }
});

server.listen(PORT, () => {
  console.log(`[web-links] servidor corriendo en http://localhost:${PORT}`);
});