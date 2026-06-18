@echo off
title WEB-LINKS — Puerto 8083
cd /d "%~dp0web-links"

echo ============================================
echo  WEB-LINKS SERVER  ^|  Puerto 8083
echo ============================================
echo.

REM Verificar si el puerto 8083 ya esta ocupado
netstat -ano | findstr ":8083 " >nul 2>&1
if %ERRORLEVEL% equ 0 (
    echo [AVISO] El puerto 8083 ya esta en uso. Web-links puede ya estar corriendo.
    pause
    exit /b 0
)

echo Iniciando servidor web-links en http://localhost:8083
echo Para detener: presiona Ctrl+C
echo.
node server.js
pause
