# syntax=docker/dockerfile:1
#FROM openjdk:17
#COPY ./target/student_management_system-0.0.1-SNAPSHOT.jar app.jar
#CMD ["java","-jar","app.jar"]
FROM openjdk:17-jdk-alpine

WORKDIR /app

COPY .mvn/ .mvn
COPY mvnw pom.xml ./
RUN ./mvnw dependency:resolve

COPY src ./src

CMD ["./mvnw", "spring-boot:"]