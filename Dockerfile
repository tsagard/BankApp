FROM adoptopenjdk/openjdk11:alpine-jre
WORKDIR /app
EXPOSE 8080
COPY target/BankProject-0.0.1-SNAPSHOT.jar BankProject-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "/BankProject-0.0.1-SNAPSHOT.jar"]
