FROM openjdk:8-jdk-alpine
COPY ./target/projectmgt-crud-1.0.0-SNAPSHOT.jar /usr/src/projectmgt/
WORKDIR /usr/src/projectmgt
EXPOSE 8080
CMD ["java", "-jar", "projectmgt-crud-1.0.0-SNAPSHOT.jar"]