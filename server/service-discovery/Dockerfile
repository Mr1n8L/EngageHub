FROM openjdk:21-jdk-alpine
VOLUME /tmp
COPY build/libs/service-discovery-0.0.1-SNAPSHOT.jar service-discovery.jar
ENTRYPOINT ["java","-jar","/service-discovery.jar"]
