FROM openjdk:17

WORKDIR /app

# Use Maven's output folder
COPY ./target/work-service-0.0.1-SNAPSHOT.jar .

EXPOSE 8081

CMD ["java", "-jar", "work-service-0.0.1-SNAPSHOT.jar"]
