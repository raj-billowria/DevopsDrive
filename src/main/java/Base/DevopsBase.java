package Base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Collections;
import java.util.HashMap;
import java.util.Properties;

public class DevopsBase {
    public static WebDriver driver;
    public static WebDriverWait wait;
    public static Properties prop;

    @BeforeClass
    public void setup(){

        try {
            prop = new Properties();
            FileInputStream cp = new FileInputStream(System.getProperty("user.dir")+"//src//test//resources//config.properties");
            prop.load(cp);

        } catch (IOException e) {
            e.printStackTrace();
        }

        WebDriverManager.chromedriver().setup();
        HashMap<String, Object> prefs = new HashMap<>();
        prefs.put("download.prompt_for_download", false);
        prefs.put("download.default_directory","/Users/nowfloats/Documents/Projects/Zadinga/Downloads");
        prefs.put("plugins.always_open_pdf_externally", true);
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
        options.setExperimentalOption("prefs", prefs);
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(ChromeOptions.CAPABILITY, options);
        options.merge(caps);
        driver = new ChromeDriver(options);

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(50));
    }

    @AfterClass
    public void teardown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
}
