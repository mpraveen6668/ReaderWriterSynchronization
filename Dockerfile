FROM eclipse-temurin:21-jdk

WORKDIR /app

COPY src /app/src

RUN javac -d /app/out /app/src/readerwriter/*.java

CMD ["java", "-cp", "/app/out", "readerwriter.Main"]