FROM openjdk:11
COPY target/Relog-0.0.1-SNAPSHOT.jar /app.jar
COPY src/main/resources/static /static
EXPOSE 8282
ENTRYPOINT ["java", "-jar", "/app.jar"]

