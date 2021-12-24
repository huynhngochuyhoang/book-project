FROM openjdk:18-jdk-alpine3.15
WORKDIR /app
COPY target/api-gateway-0.0.1-SNAPSHOT.jar /app/
ENTRYPOINT ["java","-jar","api-gateway-0.0.1-SNAPSHOT.jar"]