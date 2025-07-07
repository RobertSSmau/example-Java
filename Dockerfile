FROM eclipse-temurin:21-jdk-alpine

# Crea la cartella di lavoro
WORKDIR /app

# Copia tutto il progetto dentro il container
COPY . .

# Costruisce il progetto con Maven Wrapper
RUN ./mvnw clean package -DskipTests

# Espone la porta 8080
EXPOSE 8080

# Avvia l'app Spring Boot (modifica con il tuo nome .jar reale)
ENTRYPOINT ["java", "-jar", "target/Meteo-0.0.1-SNAPSHOT.jar"]