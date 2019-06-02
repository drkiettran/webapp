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

## Build the application

``` bash
mvn clean package.
```

The generated (fat / all dependencies are include) is stored in the `target` folder.

## Run the application

``` bash
java -jar target/webapp-0.0.1-SNAPSHOT.jar
```

## Testing with Postman software
Test it with Postman with the following information:

- method is `PUT`
- url is: http://localhost:8080/api/v1/greetings/sayHello
- headers are: context-type: application/json, accept: application/json.
- authorization is basic authentication with username/password as user1/secret1
- body of the data should have these

```
{
	"name": "Testing WebApp",
	"message": "Greetings from Bolivia"
}
```

## Testing with CURL
Use this command to test your application:

```
curl -X PUT --user user1:secret1 http://localhost:8080/api/v1/greetings/sayHello -d '{"name": "my-name goes here", "message": "message goes here!"}' -H "Content-type: application/json" -H "Accept: application/json"
```

Interesting URLS:

```
http://localhost:8080/v2/api-docs
http://localhost:8080/swagger-ui.html
http://localhost:8080/mappings
```

## Use Postman

Make sure to specify authentication with user1/secret1 Basic Authentication.


## Build with docker
You would need to sign up for a free account with docker hub website to complete this assignment
https://hub.docker.com. The sign up process is similar to that of the github.

When you sign up for a docker hub account, you need to come up with your unique username.
My username is drtran. Replace all drtran username with your own username.

``` bash
./mvnw -Ddocker.image.prefix=drtran clean install dockerfile:build

docker login

./mvnw -Ddocker.image.prefix=drtran clean install dockerfile:push
```


## Run as a docker container.

``` bash
docker run -p 8080:8080 drtran/webapp:latest
```


## Deploy docker image onto openshift.

### Start OpenShift

``` bash
cd oc-server-311
./start-oc.sh
```

### Import Docker image

We'll use the default project 'myproject'. Use username/password as developer/developer

```
oc login 

oc import-image drtran/webapp --from drtran/webapp --insecure --confirm=true --all=true --loglevel=10

```

### Create new application on OpenShift

```
oc new-app --name=greetings-webapp drtran/webapp

oc expose svc greetings-webapp
```

### Find your hostname

```
oc describe route greetings-webapp | grep "Requested Host"
```

In this case my requested host is: greetings-webapp-myproject.127.0.0.1.nip.io.
Your application URL should be: http://greetings-webapp-myproject.127.0.0.1.nip.io/api/v1/greetings/sayHello


