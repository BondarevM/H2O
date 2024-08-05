FROM openjdk:17

WORKDIR /app

COPY target/computer-store-0.0.1-SNAPSHOT.jar /app/computer-store-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java", "-jar", "/app/computer-store-0.0.1-SNAPSHOT.jar"]