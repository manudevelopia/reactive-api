FROM amazoncorretto:20-alpine-jdk

COPY "app/build/libs/*-all.jar" app.jar

EXPOSE 5050

ENTRYPOINT ["java","-jar","/app.jar"]
