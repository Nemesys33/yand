FROM openjdk:17.0.1-jdk-slim AS BUILD_IMAGE
ENV APP_HOME=/opt/app/dev
RUN mkdir -p $APP_HOME/src/main/java
WORKDIR $APP_HOME

COPY ./build.gradle ./gradlew ./gradlew.bat $APP_HOME
COPY gradle $APP_HOME/gradle
COPY ./src $APP_HOME/src/

RUN ./gradlew clean build -x test

FROM openjdk:17.0.1-jdk-slim

WORKDIR /opt/app

#ENV POSTGRES_SERVER = yandex-lavka-db
ENV POSTGRES_SERVER host.docker.internal
ENV POSTGRES_PORT 5432
ENV POSTGRES_DB postgres
ENV POSTGRES_USER postgres
ENV POSTGRES_PASSWORD password

COPY --from=BUILD_IMAGE '/opt/app/dev/build/libs/*SNAPSHOT.jar' 'yandex-lavka.jar'

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "yandex-lavka.jar"]
