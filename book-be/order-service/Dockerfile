FROM openjdk:18-jdk-alpine3.15
WORKDIR /app
COPY target/order-service-0.0.1-SNAPSHOT.jar /app/
ENTRYPOINT ["java","-jar","order-service-0.0.1-SNAPSHOT.jar"]