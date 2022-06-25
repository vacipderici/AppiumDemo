import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidTouchAction;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class Send_SMS_Test {

    public AndroidDriver driver;
    public AndroidTouchAction actions;

    private static By backupBtn = By.id("auto_backup_switch");
    private static By touchOutsideBtn = By.id("touch_outside");
    private static By keepOffBtn = By.xpath("//*[@text='KEEP OFF']");
    private static By photo = By.xpath("//android.view.ViewGroup[contains(@content-desc,'Photo taken')]");

    File classPath, imageDir, img;

    @BeforeTest
    public void setUp() throws MalformedURLException {
        DesiredCapabilities caps =new DesiredCapabilities();
        caps.setCapability("platformName","Android");
        caps.setCapability("automationName","UiAutomator2");
        caps.setCapability("deviceName","HUAWEI P40 Lite");
        caps.setCapability("appPackage","com.android.gallery3d");
        caps.setCapability("appActivity","com.huawei.gallery.app.WelcomePage");




        driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"),caps);

    }

    @Test
    public void send_Photo() throws IOException {
        classPath = new File(System.getProperty("user.dir"));
        imageDir = new File(classPath, "/resources/images");
        img = new File(imageDir.getCanonicalFile(), "TAU-logo.png");

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(backupBtn)).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(touchOutsideBtn)).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(keepOffBtn)).click();

        String Android_Photo_Path = "mnt/sdcard/Pictures";
        driver.pushFile(Android_Photo_Path + "/" + img.getName(), img);
        wait.until(ExpectedConditions.numberOfElementsToBe(photo, 1));
    }

    @AfterTest
    public void TearDown(){
        if (null != driver){
            driver.quit();
        }
    }

}
