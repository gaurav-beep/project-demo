FROM openjdk:8-jre-alpine
WORKDIR /app
COPY /target/project-demo.jar /app/project-demo.jar
EXPOSE 8085
CMD ["java","-jar","project-demo.jar"]