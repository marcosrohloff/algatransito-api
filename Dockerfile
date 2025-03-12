FROM alpine:3.21
RUN apk add --no-cache openjdk21-jre
WORKDIR /alga
ENV JAR_NAME=algatransito-api.jar
COPY target/$JAR_NAME $JAR_NAME
CMD java -jar $JAR_NAME