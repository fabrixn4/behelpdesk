<<<<<<< HEAD
FROM java:8
ADD target/behelpdesk-0.0.1-SNAPSHOT.jar /app.jar
=======
FROM openjdk
ADD target/behelpdesk-0.0.1-SNAPSHOT.jar /app.jar
>>>>>>> 17fa96140813047acd7178711a14e0603caeaf96
CMD ["java", "-jar", "/app.jar"]