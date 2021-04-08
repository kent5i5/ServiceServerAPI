# FROM openjdk:15-jdk-alpine
# VOLUME /tmp
# ARG JAR_FILE=target/*.jar
# COPY ${JAR_FILE} app.jar
# ENTRYPOINT ["java", "-Dspring.data.mongodb.uri=mongodb://springboot-mongo:27017/mongo","-jar","/app.jar"]

# war 

FROM openjdk:15-jdk-alpine
VOLUME /tmp
ARG WAR_FILE=target/*.war
COPY ${WAR_FILE} app.war
ENTRYPOINT ["java", "-Dspring.data.mongodb.uri=mongodb://mongo:27017/test","-jar","/app.war"]