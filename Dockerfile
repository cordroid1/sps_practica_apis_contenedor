FROM openjdk:11.0.8
EXPOSE 8080
ARG JAR_FILE=target/practica-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]