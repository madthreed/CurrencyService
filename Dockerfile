FROM openjdk:17
ENV APP_HOME=/usr/app/
WORKDIR $APP_HOME
EXPOSE 8080
ADD build.gradle /usr/app/build.gradle
COPY ./build/libs/CurrencyService-0.0.1-SNAPSHOT.jar ./app.jar
COPY ./src/main/resources/application.properties ./application.properties
ENTRYPOINT ["java", "-jar", "app.jar"]