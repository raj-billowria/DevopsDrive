package Test;

import org.testng.annotations.Test;

public class TestHello {

    @Test(priority = 1)
    public void Test_Hello(){
        System.out.println("Hello World");
    }

    @Test(priority = 2)
    public void Test_Devops(){
        System.out.println("Hello Devops");
    }

    @Test(priority = 3)
    public void Test_Raj(){
        System.out.println("Hello Raj");
    }
}
