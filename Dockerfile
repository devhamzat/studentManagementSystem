# syntax=docker/dockerfile:1

FROM openjdk-17

WORKDIR /Users/USER/Documents/student_management_system

COPY .mvn/ .mvn
COPY mvnw pom.xml ./
#COPY settings.xml /root/.m
RUN ./mvnw dependency:resolve

COPY src ./src

CMD ["./mvnw", "spring-boot:run"]