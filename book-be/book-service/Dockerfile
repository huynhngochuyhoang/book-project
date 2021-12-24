FROM openjdk:18-jdk-alpine3.15
WORKDIR /app
COPY target/book-service-0.0.1-SNAPSHOT.jar /app/
ENTRYPOINT ["java","-jar","book-service-0.0.1-SNAPSHOT.jar"]