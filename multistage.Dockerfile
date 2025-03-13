# Build stage
FROM maven:3.9.9-eclipse-temurin-21-alpine AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Run stage
FROM openjdk:21-slim
WORKDIR /app
ENV JAR_NAME=algatransito-api.jar
COPY --from=build /app/target/$JAR_NAME $JAR_NAME
EXPOSE 8080
CMD java -jar $JAR_NAME