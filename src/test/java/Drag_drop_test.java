import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class Drag_drop_test{
    public AndroidDriver driver;
    public AndroidTouchAction actions;

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
    public void drag_drop(){
        AndroidElement views = (AndroidElement) driver.findElementByAccessibilityId("Views");

        actions = new AndroidTouchAction(driver);
        actions.tap(ElementOption.element(views)).perform();  //click views

        AndroidElement drag_drop =
                (AndroidElement) driver.findElementByAccessibilityId("Drag and Drop");
        actions.tap(ElementOption.element(drag_drop)).perform(); // Click Drag Drop

        AndroidElement drag =(AndroidElement) driver.findElement(By.id("drag_dot_1"));
        AndroidElement drop =(AndroidElement) driver.findElement(By.id("drag_dot_2"));

        actions.longPress(ElementOption.element((drag)))
                .waitAction().moveTo(ElementOption.element(drop))
                .release()
                .perform();
    }


    @AfterTest
    public void TearDown(){
        if (null != driver){
            driver.quit();
        }
    }

}
