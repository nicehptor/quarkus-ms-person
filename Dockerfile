FROM eclipse-temurin:21-jdk-alpine
WORKDIR /app
# Asegurate de que el proyecto se ha compilado primero
COPY target/*.jar app.jar
EXPOSE 9011
ENTRYPOINT ["java", "-jar", "app.jar"]



