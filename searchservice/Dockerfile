FROM maven:3.9.9-sapmachine-23 as build
WORKDIR /app
COPY . /app/
RUN mvn clean package -DskipTests
FROM openjdk:23-jdk
COPY --from=build /app/target/searchservice-0.0.1-SNAPSHOT.jar /app/searchservice.jar
CMD ["java", "-jar", "/app/searchservice.jar","-Dspring-boot.run.arguments=--spring.config.location=classpath:/application-docker.properties"]