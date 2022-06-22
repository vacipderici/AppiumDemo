import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Logger;

public class Android_Built_In_App_Demo {

    AppiumDriver driver;


    @BeforeTest
    public void setUp() throws MalformedURLException {
        DesiredCapabilities caps =new DesiredCapabilities();
        caps.setCapability("platformName","Android");
        caps.setCapability("automationName","UiAutomator2");
        caps.setCapability("deviceName","HUAWEI P40 Lite");
        caps.setCapability("appPackage","io.appium.android.apis");
        caps.setCapability("appActivity","io.appium.android.apis.ApiDemos");

        driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"),caps);

    }
    @Test
    public  void click_Test(){

        driver.findElementByXPath("//android.widget.TextView[@content-desc=\"Animation\"]").click();
        Assert.assertEquals(driver.findElementByXPath("//android.widget.TextView[@content-desc=\"Bouncing Balls\"]").getText(),"Bouncing Balls");

    }

    @AfterTest
    public void TearDown(){
        if (null != driver){
            driver.quit();
        }
    }
}
