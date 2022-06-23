import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class FirstAndroidTest {

    AppiumDriver driver;


  @BeforeTest
  public void setUp() throws MalformedURLException {
      DesiredCapabilities caps =new DesiredCapabilities();
      caps.setCapability("platformName","Android");
      caps.setCapability("automationName","UiAutomator2");
      caps.setCapability("deviceName","HUAWEI P40 Lite");
      caps.setCapability("app",System.getProperty("user.dir")+"/apps/ApiDemos-debug.apk");

      driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"),caps);

  }


    @AfterTest
    public void TearDown(){
      if (null != driver){
          driver.quit();
      }
    }


 }
