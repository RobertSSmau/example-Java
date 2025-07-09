@echo off
echo Avvio container Meteo...
docker compose up --build

:: Una volta avviato, apri il browser
start http://localhost:8080

pause