This is repository of basic REST API testing framework
The public API used for this example is -https://reqres.in/api
This framework is developed using Rest-Assured library for Rest API testing
For JSON Parsing - JSONPath
Test Reporting is by Allure and TestNG

JSONPath is a query language that helps us in parsing the JSON data, which can be used for validation or assertions in a test.
Hamcrest is a framework that comes with a library of useful matchers for writing match rules using matcher objects.

Building and running tests: 
1. CLI using gradle ./gradlew clean test  | will run all tests
2. CLI using gradle ./gradlew clean test --tests "api.example.GET_User" | will run specific test
3. Intelij using TestNG runner - click on the test class - select run as 
4. Intelij using TestNG suite.xml - select run as 

Viewing test report: 
1. CLI using gradle ./gradlew allureServe
2. Intelij using TestNG report - test-output folder 

Curl notes:
- By default,curl requests the URL using the GET method. 
- To request the specific URL using the POST,DELETE or PUT methods, we have to use the-X right after the curl command
curl -X POST 
- Using -X switch will show only message body (the HTML content).
- Using -iX switch will show us a response header and message body
- Using -i switch will just show us only the response header
