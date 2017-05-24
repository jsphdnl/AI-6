FROM openjdk:8

COPY ../../build/libs/AI-VI-standalone.jar  AI-VI-standalone.jar
COPY ../../application.properties application.properties

CMD java -jar AI-VI-standalone.jar server application.properties
