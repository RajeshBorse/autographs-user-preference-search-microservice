FROM --platform=linux/amd64 openjdk:15
COPY  target/autographs-user-preference-search-microservice.jar autographs-user-preference-search-microservice.jar
ENTRYPOINT [ "java", "-jar",  "autographs-user-preference-search-microservice.jar"]
EXPOSE 8006