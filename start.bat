@echo off
echo Avvio del container Docker...

:: Naviga nella directory del progetto (modifica se necessario)
cd /d %~dp0

:: Esegui Docker Compose
docker-compose up --build

pause