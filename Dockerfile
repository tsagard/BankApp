FROM openjdk:17-alpine
EXPOSE 8085
COPY target/springbootdockerbank.jar springbootdockerbank.jar
ENTRYPOINT ["java", "-jar", "/springbootdockerbank.jar"]
