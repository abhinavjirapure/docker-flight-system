FROM openjdk:latest
EXPOSE 8085
ADD target/docker-flight.jar api.jar
ENTRYPOINT ["sh","-c","java -jar /api.jar"]
