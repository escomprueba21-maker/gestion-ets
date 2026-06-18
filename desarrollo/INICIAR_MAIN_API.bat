@echo off
title MAIN API — Puerto 8082
cd /d "%~dp0gestion-ets-api"

echo ============================================
echo  MAIN API  ^|  Puerto 8082
echo ============================================
echo.

REM Verificar PostgreSQL
"D:\Program Files\PostgreSQL\18\bin\pg_isready.exe" -U postgres -q
if %ERRORLEVEL% neq 0 (
    echo [ERROR] PostgreSQL NO esta corriendo en localhost:5432
    echo Arranca PostgreSQL primero y vuelve a ejecutar este script.
    pause
    exit /b 1
)
echo [OK] PostgreSQL detectado.

REM Verificar si el puerto 8082 ya esta ocupado
netstat -ano | findstr ":8082 " >nul 2>&1
if %ERRORLEVEL% equ 0 (
    echo [AVISO] El puerto 8082 ya esta en uso. El Main API puede ya estar corriendo.
    echo Abre http://localhost:8082/q/swagger-ui para verificarlo.
    pause
    exit /b 0
)

REM Cargar variables de entorno desde .env
for /f "usebackq tokens=1,* delims==" %%A in (".env") do (
    if not "%%A"=="" if not "%%A:~0,1%"=="#" set "%%A=%%B"
)

echo [OK] Variables .env cargadas.
echo.
echo Iniciando Main API...
echo Espera el mensaje: Listening on: http://localhost:8082
echo Para detener: presiona Ctrl+C
echo.
mvnw.cmd quarkus:dev -Dquarkus.http.port=8082
pause
