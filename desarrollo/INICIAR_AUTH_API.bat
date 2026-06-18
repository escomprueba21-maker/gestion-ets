@echo off
title AUTH API — Puerto 8081
cd /d "%~dp0gestion-ets-auth-api"

echo ============================================
echo  AUTH API  ^|  Puerto 8081
echo ============================================
echo.

REM Verificar que PostgreSQL responde
"D:\Program Files\PostgreSQL\18\bin\pg_isready.exe" -U postgres -q
if %ERRORLEVEL% neq 0 (
    echo [ERROR] PostgreSQL NO esta corriendo en localhost:5432
    echo Arranca PostgreSQL primero y vuelve a ejecutar este script.
    pause
    exit /b 1
)
echo [OK] PostgreSQL detectado.

REM Verificar si el puerto 8081 ya esta ocupado
netstat -ano | findstr ":8081 " >nul 2>&1
if %ERRORLEVEL% equ 0 (
    echo [AVISO] El puerto 8081 ya esta en uso. Es posible que el Auth API ya este corriendo.
    echo Abre http://localhost:8081/q/swagger-ui para verificarlo.
    pause
    exit /b 0
)

REM Cargar variables de entorno desde .env
for /f "usebackq tokens=1,* delims==" %%A in (".env") do (
    if not "%%A"=="" if not "%%A:~0,1%"=="#" set "%%A=%%B"
)

echo [OK] Variables .env cargadas.
echo.
echo Iniciando Auth API...
echo Espera el mensaje: Listening on: http://localhost:8081
echo Para detener: presiona Ctrl+C
echo.
mvnw.cmd quarkus:dev -Dquarkus.http.port=8081
pause
