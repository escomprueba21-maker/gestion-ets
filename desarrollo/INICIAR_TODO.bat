@echo off
title ARRANCAR TODOS LOS BACKENDS — ETS ESCOM
echo ============================================================
echo  ARRANCAR TODO — Auth API + Main API + Web-Links
echo  IP WiFi de esta PC: 192.168.1.104
echo  (El telefono debe estar en la misma red WiFi)
echo ============================================================
echo.

REM 1. Verificar PostgreSQL
echo [1/4] Verificando PostgreSQL...
"D:\Program Files\PostgreSQL\18\bin\pg_isready.exe" -U postgres -q
if %ERRORLEVEL% neq 0 (
    echo [ERROR] PostgreSQL NO esta corriendo!
    echo Abre Servicios de Windows ^(services.msc^) y arranca
    echo el servicio "postgresql-x64-18" primero.
    pause
    exit /b 1
)
echo       PostgreSQL OK

REM 2. Auth API
echo [2/4] Arrancando Auth API ^(0.0.0.0:8081^)...
netstat -ano | findstr ":8081 " >nul 2>&1
if %ERRORLEVEL% equ 0 (
    echo       Puerto 8081 ya en uso ^(Auth API probablemente ya corre^).
) else (
    start "AUTH API :8081" cmd.exe /c "cd /d D:\ESCOM\10mo\moviles\proyecto\gestion-ets\desarrollo\gestion-ets-auth-api && for /f ""usebackq tokens=1,* delims=="" %%A in ("".env"") do if not ""%%A""=="" set ""%%A=%%B"" && mvnw.cmd quarkus:dev -Dquarkus.http.port=8081 -Dquarkus.http.host=0.0.0.0"
    echo       Ventana abierta. Espera ~30s.
)

REM 3. Main API
echo [3/4] Arrancando Main API ^(0.0.0.0:8082^)...
netstat -ano | findstr ":8082 " >nul 2>&1
if %ERRORLEVEL% equ 0 (
    echo       Puerto 8082 ya en uso ^(Main API probablemente ya corre^).
) else (
    start "MAIN API :8082" cmd.exe /c "cd /d D:\ESCOM\10mo\moviles\proyecto\gestion-ets\desarrollo\gestion-ets-api && for /f ""usebackq tokens=1,* delims=="" %%A in ("".env"") do if not ""%%A""=="" set ""%%A=%%B"" && mvnw.cmd quarkus:dev -Dquarkus.http.port=8082 -Dquarkus.http.host=0.0.0.0"
    echo       Ventana abierta. Espera ~30s.
)

REM 4. Web-links
echo [4/4] Arrancando Web-Links ^(8083^)...
netstat -ano | findstr ":8083 " >nul 2>&1
if %ERRORLEVEL% equ 0 (
    echo       Puerto 8083 ya en uso.
) else (
    start "WEB-LINKS :8083" cmd.exe /c "cd /d D:\ESCOM\10mo\moviles\proyecto\gestion-ets\desarrollo\web-links && node server.js"
    echo       Web-links arrancado.
)

echo.
echo ============================================================
echo  BACKENDS CORRIENDO. Verifica en el navegador:
echo    http://192.168.1.104:8081/q/swagger-ui
echo    http://192.168.1.104:8082/q/swagger-ui
echo.
echo  App Flutter (sin USB, solo WiFi):
echo    La app usa http://192.168.1.104:8081 / :8082
echo    El telefono y la PC deben estar en la MISMA red WiFi.
echo.
echo  NOTA: Si el Firewall bloquea, ejecuta una sola vez:
echo    ABRIR_FIREWALL_ADMIN.bat  (como Administrador)
echo ============================================================
pause
