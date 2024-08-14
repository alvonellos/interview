FROM eclipse-temurin:17-jdk-alpine
VOLUME /tmp
COPY  target/interview-0.0.1.jar app.jar
EXPOSE 0.0.0.0:8009:8009
ENTRYPOINT ["java","-jar","/app.jar"]