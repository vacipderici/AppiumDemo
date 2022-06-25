import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidTouchAction;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Send_SMS_Test {

    public AndroidDriver driver;
    public AndroidTouchAction actions;

    @BeforeTest
    public void setUp() throws MalformedURLException {
        DesiredCapabilities caps =new DesiredCapabilities();
        caps.setCapability("platformName","Android");
        caps.setCapability("automationName","UiAutomator2");
        caps.setCapability("deviceName","HUAWEI P40 Lite");
        caps.setCapability("appPackage","com.android.mms");
        caps.setCapability("appActivity","com.android.mms.ui.ConversationList");


        driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"),caps);

    }

    @Test
    public void send_SMS(){
        driver.sendSMS("553-611-14-83","trying");
    }

    @AfterTest
    public void TearDown(){
        if (null != driver){
            driver.quit();
        }
    }

}
