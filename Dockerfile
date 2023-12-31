FROM openjdk:21-slim
WORKDIR /app
COPY target/ /app
CMD ["java", "-jar", "server-1.0.0.jar"]