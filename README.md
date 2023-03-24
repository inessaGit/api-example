## :question: What is this Repository about?
This project is the outcome of my self-learning about the using  REST Assured for testing API. 

## :briefcase: What does this repo contain?
This is repository of basic REST API testing framework. 

The public API used for this example is - [ReqresIn](https://reqres.in/api) and [Restful-Booker](https://restful-booker.herokuapp.com)


This framework is developed using [Rest-Assured library](https://rest-assured.io/)


Test Reporting is by Allure and TestNG
Build tool - [Gradle](https://gradle.org/)

JSONPath is a query language that helps us in parsing the JSON data, which can be used for validation or assertions in a test.
Hamcrest is a library of useful matchers for writing match rules

## Building and running tests: 
1. CLI using gradle ```./gradlew clean test``` | will run all tests
2. CLI using gradle ```./gradlew clean test --tests "api.example.GET_User"``` | will run specific test
3. Intelij using TestNG runner - click on the test class - select run as 
4. Intelij using TestNG suite.xml - select run as 

Viewing test report: 
1. CLI using gradle ```./gradlew allureServe```
2. Intelij using TestNG report - test-output folder 
