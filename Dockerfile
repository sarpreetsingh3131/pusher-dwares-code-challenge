FROM openjdk:8
ADD target/pusher-dwarves-code-challenge-1.0-SNAPSHOT.jar //
ENTRYPOINT ["java", "-jar", "/pusher-dwarves-code-challenge-1.0-SNAPSHOT.jar"]
