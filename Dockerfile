##syntax=docker/dockerfile:1
#FROM openjdk:17
#
#WORKDIR /app
#
#COPY .mvn/ .mvn
#COPY mvnw pom.xml ./
#RUN ./mvnw dependency:resolve
#
#COPY src ./src
#
##CMD ["./mvnw","spring-boot:run"]
#
##FROM openjdk:17-jdk-alpine
##
###WORKDIR /app
##ARG JAR_FILE=target/*.jar
###COPY .mvn/ .mvn
###COPY mvnw pom.xml ./
##COPY target/student_management_system-0.0.1-SNAPSHOT.jar app.jar
###RUN ./mvnw dependency:resolve
##
###COPY src ./src
##
##ENTRYPOINT ["java", "-jar", "/app.jar "]
##
##
