FROM openjdk:15
ADD target/autographs-user-preference-search-microservice.jar autographs-user-preference-search-microservice.jar
ENTRYPOINT [ "java", "-jar",  "autographs-user-preference-search-microservice.jar"]
EXPOSE 8006