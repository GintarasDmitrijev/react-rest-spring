# Getting Started

### How to build and run this application

This project has everything that is needed to run the application. Just issue the following command
from the project root:

```shell script
mvnw clean install
```
The project is configured so that it will install ```npm``` in the project root and dowlnoad all needed 
```node``` modules. Then it will build all frontend modules using ```webpack``` with help of
configured ```frontend-maven-plugin```. 

After project is built, issue the following command:
```shell script
mvnw spring-boot:run
```

After application is started, enter this path into address bar of the browser:
```shell script
http://localhost:8080/
```