@echo off
echo ============================================================
echo  ABRIR PUERTOS EN FIREWALL — Ejecutar como ADMINISTRADOR
echo ============================================================
echo.

net session >nul 2>&1
if %ERRORLEVEL% neq 0 (
    echo ERROR: Ejecuta este archivo como ADMINISTRADOR.
    echo Click derecho sobre el archivo ^> "Ejecutar como administrador"
    pause
    exit /b 1
)

echo Abriendo puertos 8081, 8082 y 8083 para acceso WiFi...

netsh advfirewall firewall delete rule name="ETS Auth API 8081" >nul 2>&1
netsh advfirewall firewall delete rule name="ETS Main API 8082" >nul 2>&1
netsh advfirewall firewall delete rule name="ETS Web-Links 8083" >nul 2>&1

netsh advfirewall firewall add rule name="ETS Auth API 8081" dir=in action=allow protocol=TCP localport=8081
netsh advfirewall firewall add rule name="ETS Main API 8082" dir=in action=allow protocol=TCP localport=8082
netsh advfirewall firewall add rule name="ETS Web-Links 8083" dir=in action=allow protocol=TCP localport=8083

echo.
echo [OK] Puertos 8081, 8082 y 8083 abiertos.
echo El telefono (en la misma red WiFi) ya puede conectarse a:
echo   http://192.168.1.104:8081  (Auth API)
echo   http://192.168.1.104:8082  (Main API)
echo   http://192.168.1.104:8083  (Web-links)
echo.
pause
