FROM openjdk:9
ADD target/Quizzed-0.0.1-SNAPSHOT.jar Quizzed-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "Quizzed-0.0.1-SNAPSHOT.jar"]