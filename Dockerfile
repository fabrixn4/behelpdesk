FROM java:8
ADD target/behelpdesk-0.0.1-SNAPSHOT.jar /app.jar
CMD ["java", "-jar", "/app.jar"]