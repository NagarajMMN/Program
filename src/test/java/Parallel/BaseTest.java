package Parallel;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class BaseTest {
   // public AppiumDriver driver;
    public ThreadLocal<AppiumDriver> driver =new ThreadLocal<>();
    public void setDriver(AppiumDriver driver){
        this.driver.set(driver);
    }
    public AppiumDriver getDriver(){
        return this.driver.get();
    }
    @BeforeMethod
    @Parameters({"deviceName","platformVersion","portNumber","udid"})
    public void initiateDriver(String deviceName, String platformVersion, String portNumber, String udid) throws MalformedURLException, InterruptedException {
       //startAppiumService(portNumber);


        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("deviceName",deviceName);
        cap.setCapability("udid",udid);
        cap.setCapability("platformVersion",platformVersion);
        cap.setCapability("platformName","Android");
        cap.setCapability("AutomatorName","UiAutomator2");
        cap.setCapability("appPackage","io.appium.android.apis");
        cap.setCapability("appActivity","io.appium.android.apis.ApiDemos");

        setDriver(new AndroidDriver(new URL("http://127.0.0.1:"+portNumber+"/wd/hub"),cap));
       // driver.wait().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod
    public void closeDriver(){
        getDriver().quit();
    }

//    public void startAppiumService(String portNumber){
//        AppiumDriverLocalService service;
//        AppiumServiceBuilder builder =new AppiumServiceBuilder();
//        builder.withIPAddress("127.0.0.1");
//        builder.usingPort(Integer.parseInt(portNumber));
//        service = AppiumDriverLocalService.buildService(builder);
//        service.start();
//        System.out.println("Service started with port number"+portNumber);
//    }
}
