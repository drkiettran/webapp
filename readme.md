# Introduction
This project demonstrate the use of Spring Boot to build 
simple web application, in particular, REST API application.

## To run as maven project.
Most of the code was generated using this website `https://start.spring.io/`.
See `HELP.md` from this folder for more information

To run the code as a server from the command line:

```bash
mvn clean test spring-boot:run
```

## Build

``` bash
mvn clean package.
```

The generated (fat / all dependencies are include) is stored in the `target` folder.

## To run it with the jar (all inclusive - no):

``` bash
java -jar target/webapp-0.0.1-SNAPSHOT.jar
```

You can move/copy the `webapp-0.0.1-SNAPSHOT.jar` to any location and run it there using
the same command:

``` bash
cp target/webapp-0.0.1-SNAPSHOT.jar some-dir
cd some-dir
java -jar ./webapp-0.0.1-SNAPSHOT.jar
```

Interesting URLS:

```
http://localhost:8080/v2/api-docs
http://localhost:8080/swagger-ui.html
http://localhost:8080/mappings
```

## Use Postman

Make sure to specify authentication with user1/secret1 Basic.

