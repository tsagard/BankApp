FROM adoptopenjdk/openjdk11:alpine-jre
EXPOSE 8085
COPY C:/Users/admin/Documents/workspace-spring-tool-suite-4-4.23.1.RELEASE/BankProject/target/BankProject.jar BankProject.jar
ENTRYPOINT ["java", "-jar", "/BankProject.jar"]
