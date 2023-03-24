package api.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.lang.reflect.Method;

public class BaseTest {
    protected static final Logger LOG = LoggerFactory.getLogger(BaseTest.class);


    @BeforeMethod
    public void setUp(Method method) {

    }

    @AfterMethod
    public void closeDriver(ITestResult result) {

    }

}
