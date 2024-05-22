# # Base image được sử dụng để build image
# FROM openjdk:17-jdk-alpine
# #Copy jar from local into dokcer image
# COPY target/Book-0.0.1-SNAPSHOT.jar Book-0.0.1-SNAPSHOT.jar
# #Command để chạy ứng dụng
# ENTRYPOINT ["java","-jar","/Book-0.0.1-SNAPSHOT.jar"]
# Stage 1: Build the application
# FROM maven:3-openjdk-17 AS build
# WORKDIR /app
# COPY . /app
# RUN mvn clean install

# # Stage 2: Create the final image
# FROM openjdk:17-jdk-alpine
# WORKDIR /app
# COPY --from=build /app/target/Book-0.0.1-SNAPSHOT.jar /app/Book-0.0.1-SNAPSHOT.jar
# ENTRYPOINT ["java", "-jar", "/app/Book-0.0.1-SNAPSHOT.jar"]

#Build
FROM maven:3-openjdk-17 as build
ENV HOME=/app
WORKDIR $HOME
COPY ./ $HOME
RUN --mount=type=cache,target=/root/.m2 mvn -f $HOME/pom.xml -DskipTests clean package

#Docker build
FROM openjdk:17-alpine
COPY --from=build /app/target/*.jar Book-0.0.1-SNAPSHOT.jar
ENV PORT=8080
EXPOSE $PORT
ENTRYPOINT ["java", "-jar","Book-0.0.1-SNAPSHOT.jar"]
