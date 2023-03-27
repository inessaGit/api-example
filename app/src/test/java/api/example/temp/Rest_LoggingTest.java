package api.example.temp;

import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
/*
https://github.com/rest-assured/rest-assured/wiki/Usage#request-logging
REST Assured, provide support to a different type of logging as shown below:-
Request Logging
Response Logging
Logging to console
Conditional logging
Logging to a txt file on your machine
 */

public class Rest_LoggingTest {
    private  String baseUri = "https://restful-booker.herokuapp.com/booking";
    private PrintStream rest_log ;
    private static Logger LOG = LoggerFactory.getLogger(Rest_LoggingTest.class);

    @BeforeClass
    public void setup() throws FileNotFoundException {
        LOG.info("creating rest_assured_log.txt");
        rest_log = new PrintStream(new FileOutputStream("logs/rest_assured_log.txt"));
    }

    @Test(description = "log request into .txt")
    public void logResponseToTxt() {
        RestAssured
                .given()
                .filter(RequestLoggingFilter.logRequestTo(rest_log))
                .filter(ResponseLoggingFilter.logResponseTo(rest_log))
                .get(baseUri+"/1");
    }

    @Test(description = "log RESPONSE from rest assured GET request  ")
    public void logResponseRestAssured() {
        //get("/x").then().log().body()..
        RestAssured.get(baseUri+"/1").then().log().body();
    }
    @Test(description = "log REQUEST from rest assured GET request")
    public void logRequestRestAssured(){
        //log all request specification details including parameters, headers, and body of the request,
        // log().all() needs to be added to post given() section.
        RestAssured.given().log().all().get(baseUri);
        RestAssured.given().log().params();
        RestAssured.given().log().headers();
        RestAssured.given().log().body(); //request body
        RestAssured.given().log().cookies();
        RestAssured.given().log().method();
    }

   @Test(description = "log conditionals from rest assured GET request")
    public void logConditionalRestAssured() {
       RestAssured.get(baseUri).then().log().ifError();
       RestAssured.get(baseUri).then().log().ifStatusCodeIsEqualTo(302);
       RestAssured.get(baseUri).then().log().ifValidationFails();
    }

    }
