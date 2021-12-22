# build stage
FROM maven:3-openjdk-15-slim AS build
WORKDIR /app/src
COPY /src .
COPY pom.xml /app
RUN mvn -f /app/pom.xml clean package

# package stage
FROM openjdk:15-ea-jdk-slim-buster
COPY --from=build /app/target/Daily_Active_Users-1.0-SNAPSHOT.jar /usr/local/lib/Daily_Active_Users.jar

# current directory
WORKDIR /app/resources

ENTRYPOINT ["java","-jar","/usr/local/lib/Daily_Active_Users.jar"] 
