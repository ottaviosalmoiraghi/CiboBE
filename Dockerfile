# Usa un JDK leggero (Java 17 LTS)
FROM eclipse-temurin:17-jdk-alpine

# Imposta la cartella di lavoro
WORKDIR /app

# Copia il jar buildato nella cartella di lavoro
ARG JAR_FILE=target/*.jar
COPY target/Cibo-0.0.1-SNAPSHOT.jar app.jar

# Espone la porta (Render usa $PORT)
EXPOSE 8080

# Comando per avviare l'app
ENTRYPOINT ["java","-jar","/app.jar"]
