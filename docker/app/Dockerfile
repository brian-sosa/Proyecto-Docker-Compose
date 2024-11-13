FROM openjdk:17


COPY ClientApp.java /app/ClientApp.java
WORKDIR /app
RUN javac ClientApp.java

CMD ["java", "ClientApp"]
