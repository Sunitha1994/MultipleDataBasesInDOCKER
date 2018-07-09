FROM openjdk:8
ADD target/customers-app-image.jar customers-app-image.jar
EXPOSE 8086
ENTRYPOINT ["java", "-jar", "customers-app-image.jar"]