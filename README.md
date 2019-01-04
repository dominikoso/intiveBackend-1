# Intive Patronage 2019 - Back-end Java 1

This is a readme for a first task [I](#Author) created for a Patronage 2019

## Getting Started

These instructions will get you the project up and running on your local machine for development and testing purposes. See deployment notes for [*how to deploy the app*](#Deployment-and-Using).

### Prerequisites

Things you will need to build, run and test this application

```
Gradle, Java, cURL
```

## Deployment and Using

### Building and Running
Step by step series of examples that tell you how to get a development env running

First navigate to directory of downloaded repository.
Next run gradle tasks

**For Windows**
```bash
gradlew.bat clean bootJar
```
**For Linux**
```bash
gradlew clean bootJar
```

After that navigate to *build/libs/* and run

```
java -jar intiveBackend-0.9_21.jar
```

## Run without building jar

Using Gradlew you can also run application without building jar

**For Windows**
```bash
gradlew.bat clean bootRun
```
**For Linux**
```bash
gradlew clean bootRun
```

## Example usage of using cURL

All application functionality can be tested using cURL. In this example I will show you how to add conference room to database.

**Windows - Invoke-RestMethod**
```bash
Invoke-RestMethod -Uri http://localhost:8080/croom/create -Method POST -Body '{"roomName":"Black Room", "roomId":"103", "floor":"10", "seats":"15", "standingPlaces":"50", "hammocks":"15"}' -ContentType "application/json"
```

**Linux - cURL method**
```bash
curl -d '{"roomName":"Black Room", "roomId":"103", "floor":"10", "seats":"15", "standingPlaces":"50", "hammocks":"15"}' -H "Content-Type: application/json" -X POST http://localhost:8080/croom/create
```

Both commands will return us the same, but with different formatting:

**Invoke-RestMethod**
```text
id             : 1
roomName       : Black Room
roomId         : 103
floor          : 10
available      : True
seats          : 15
standingPlaces : 50
hammocks       : 15
```

**cURL**
```json
{"id":1,"roomName":"Black Room","roomId":"103","floor":10,"available":true,"seats":15,"standingPlaces":50,"hammocks":15}
```

*Note:* If room name already taken, it will return an error

## Author

* **Dominik Kostecki** - *Creator of Project* - [dominikoso](https://github.com/dominikoso)


