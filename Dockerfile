FROM eclipse-temurin:21-jdk AS runtime

WORKDIR /app

COPY accenture-challenge-0.0.1.jar app.jar

EXPOSE 8000

ENTRYPOINT ["java", "-jar", "app.jar"]
