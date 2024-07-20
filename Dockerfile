FROM adoptopenjdk/openjdk11:alpine-jre
EXPOSE 8085
COPY target/BankProject.jar.jar BankProject.jar.jar
ENTRYPOINT ["java", "-jar", "/BankProject.jar"]
