# Meteo App – Spring Boot + Docker

**Meteo App** è un'applicazione web sviluppata con Spring Boot che consente di visualizzare le previsioni meteo (temperature e piogge orarie) per diverse città, utilizzando i dati forniti dall'API di [Open-Meteo](https://open-meteo.com/).

## Funzionalità

- Selezione della città tramite interfaccia web
- Grafico interattivo delle temperature e precipitazioni orarie
- Integrazione con Chart.js per la visualizzazione dei dati
- Backend in Spring Boot
- Esecuzione semplificata tramite Docker e Docker Compose

## Requisiti

- Docker installato
- Docker Compose installato

## Windows

Usa direttamente il file batch incluso: start.bat

## Avvio tramite terminale
Clona il repository ed esegui il seguente comando dalla root del progetto:

```bash
docker-compose up --build
```

Poi visita tramite browser: localhost:8080

Assicurati che la porta sia libera.
