# Użyj oficjalnego obrazu Javy
FROM openjdk:17-jdk-slim

# Zainstaluj Maven
RUN apt-get update && apt-get install -y maven

# Ustaw katalog roboczy
WORKDIR /app

# Skopiuj pliki pom.xml i aplikację do kontenera
COPY ./pom.xml /app/pom.xml
COPY ./src /app/src

# Buduj aplikację (Maven)
RUN mvn clean install -DskipTests

# Otwórz port 8080
EXPOSE 8080

# Uruchom aplikację
CMD ["java", "-jar", "/app/target/SEBDM_pro-0.0.1-SNAPSHOT.jar"]
