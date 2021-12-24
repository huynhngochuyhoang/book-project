FROM openjdk:18-jdk-alpine3.15
WORKDIR /app
COPY target/user-service-0.0.1-SNAPSHOT.jar /app/
ENTRYPOINT ["java","-jar","user-service-0.0.1-SNAPSHOT.jar"]