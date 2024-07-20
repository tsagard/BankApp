FROM adoptopenjdk/openjdk11:alpine-jre
EXPOSE 8085
COPY target/BankProject.jar BankProject.jar
ENTRYPOINT ["java", "-jar", "/BankProject.jar"]
