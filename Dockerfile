FROM openjdk:17-alpine
COPY target/project-0.0.1-SNAPSHOT.jar project-0.0.1-SNAPSHOT.jar
CMD ["java", "-jar", "project-0.0.1-SNAPSHOT.jar"]