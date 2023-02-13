package Test;

import Base.DevopsBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Test_01_GoogleTitle extends DevopsBase {

    @Test
    public void testGoogleTitle(){

        driver.get(prop.getProperty("url"));
        String title = driver.getTitle();

        Assert.assertEquals(title,"Google");
        System.out.println("Title is : "+title);
    }
}
