package api.example.temp;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
/*
@BeforeClass
@Test(priority =-1)
@Test(priority =0)
@Test(priority =1)
@Test(priority again =1)
 */
public class TestNGPriority {

    @BeforeClass
    public void setup(){
        System.out.println("@BeforeClass");
    }

    @Test(priority =1)
    public void test1(){
        System.out.println("@Test(priority =1)");
    }

    @Test(priority = 0)
    public void test2(){
        System.out.println("@Test(priority =0)");

    }
    @Test(priority = -1)
    public void test3(){
        System.out.println("@Test(priority =-1)");

    }

    @Test(priority = 1)
    public void testAgainPriority1(){
        System.out.println("@Test(priority again =1)");

    }
}
