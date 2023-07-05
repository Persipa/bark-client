FROM openjdk:11-jre-slim-bullseye
WORKDIR /
ADD target/bark-client-core-*.jar app.jar
ENV JAVA_OPTS=""
EXPOSE 5148
ENTRYPOINT exec java $JAVA_OPTS -jar /app.jar
