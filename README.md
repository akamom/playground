# Spring-Playground
## Prerequisits
- Java 17
- Maven

## Install
```bash
git clone https://github.com/akamom/playground.git \
cd spring-playground
```
## Run local
```bash
mvn spring-boot:run
```
The app is listening on port 8080.

## Manual STOMP testing
- Run the application and go to `http://localhost:8080`.
- There is a simple interface to connect to the broker, send, and receive messages.
