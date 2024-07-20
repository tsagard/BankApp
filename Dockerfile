FROM adoptopenjdk/openjdk11:alpine-jre
WORKDIR /app
EXPOSE 8080
COPY target/springbootdockerbank.jar springbootdockerbank.jar
ENTRYPOINT ["java", "-jar", "/springbootdockerbank.jar"]
