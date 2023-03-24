package api.example;

import io.qameta.allure.Step;
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

public class BaseTest {
    private static final Logger LOG = LoggerFactory.getLogger(BaseTest.class);
    private static RequestSpecification requestSpec;
    private static ResponseSpecification responseSpec;
    @BeforeSuite
    public void setBaseURI(){

    }

    @Step("{0}")
    public static void logToAllureReport(String message) {
        Reporter.log(message); //or System.out.println(message);
    }
    @BeforeMethod
    public void setUp(Method method) {

    }

    @AfterMethod
    public void closeDriver(ITestResult result) {

    }

}
