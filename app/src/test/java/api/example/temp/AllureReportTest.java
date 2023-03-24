package api.example.temp;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class AllureReportTest {
private static Logger LOG = LoggerFactory.getLogger(AllureReportTest.class);
    @Test
    public void logToAllure(){
           logToReport("logging to allure using TestNg Reporter.log");
    }
    @Step("{0}")
    public void logToReport(String message) {
        Reporter.log(message); //or System.out.println(message);
    }
}
