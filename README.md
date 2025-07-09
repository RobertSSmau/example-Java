# Meteo - Spring Boot + Docker Compose

Webapp che mostra meteo orario e pioggia da [open-meteo.com](https://open-meteo.com).  
Tecnologie usate: Spring Boot 3, Java 21, Thymeleaf, Docker multi-stage con distroless.

---

## Requisiti

- Docker
- Docker Compose

---

## Primo step

Tramite Git Bash eseguire questo comando:

```bash
git clone https://github.com/RobertSSmau/example-Java
```

##  Avvio classico

Build e avvio container:

```bash
docker compose up --build
```

Poi visita tramite browser: localhost:8080

Assicurati che la porta sia libera.

---

## 😴 Per i pigrozzi (zzz)

> Script già pronti se non vuoi scrivere manco `docker` nella console.

### 🪟 Windows

Usa direttamente il file batch incluso: start.bat

Poi visita tramite browser: localhost:8080

Assicurati che la porta sia libera.

Contenuto dei file:

```bat
:: start.bat
@echo off
docker compose up --build
pause
```

```bat
:: stop.bat
@echo off
docker compose down
pause
```

---

### 🐧 Linux / macOS

Usa direttamente i file ssh incluso: start.ssh

Poi visita tramite browser: localhost:8080

Assicurati che la porta sia libera.

Contenuto dei file:

```bash
# start.sh
#!/bin/bash
docker compose up --build
```

```bash
# stop.sh
#!/bin/bash
docker compose down
```


## 🧱 Dockerfile

> Usa multi-stage: build con Maven + immagine distroless super leggera e sicura (no shell, no root).

```dockerfile
# Step 1 maven
FROM maven:3.9.6-eclipse-temurin-21 AS builder
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Step 2 distroless
FROM gcr.io/distroless/java21-debian12:nonroot
WORKDIR /app
COPY --from=builder /app/target/Meteo-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]
```

---

## 📉 Dimensione finale

- Immagine finale: ~230MB (Spring Boot, distroless, ottimizzata)
- JAR: ~60MB

---

Fatto apposta per chi non vuole pesare troppo 🍔🍔🍔.