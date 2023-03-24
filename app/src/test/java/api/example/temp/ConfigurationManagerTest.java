package api.example.temp;

import api.example.utils.ConfigurationManager;
import org.testng.annotations.Test;

public class ConfigurationManagerTest {
    @Test
    public void test(){
          String env = ConfigurationManager.getInstance().getProperty("env");
          String bookerURI=ConfigurationManager.getInstance().getProperty("booker_base_uri");
          String reqresURI=ConfigurationManager.getInstance().getProperty("reqres_base_uri");

         System.out.println(env+"====== "+bookerURI+"====== "+ reqresURI);
    }
}
