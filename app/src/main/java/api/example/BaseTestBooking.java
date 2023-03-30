package api.example;

import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.lang.reflect.Method;

public abstract class BaseTestBooking {
    private static final Logger LOG = LoggerFactory.getLogger(BaseTestBooking.class);
    protected static  RequestSpecification requestSpec;
    protected static ResponseSpecification responseSpec;

    private String baseUriBooking ="https://restful-booker.herokuapp.com";
    @BeforeSuite
    public void setBaseURI(){ //https://github.com/rest-assured/rest-assured/wiki/Usage#response-logging
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
        requestSpec = new RequestSpecBuilder().
                setBaseUri(baseUriBooking).
                build();
    }

    @Step("{0}")
    public static void logToAllureReport(String message) {
        Reporter.log(message);
    }
    @BeforeMethod
    public void setUp(Method method) {

    }

    @AfterMethod
    public void closeDriver(ITestResult result) {

    }

}
