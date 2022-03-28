package com.test;

import com.test.utilities.ConfigurationReader;
import com.test.utilities.Driver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    @BeforeMethod
    public void setUp(){
        Driver.get().manage().window().maximize();
        Driver.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        Driver.get().get(ConfigurationReader.get("url"));
    }

    @AfterMethod
    public void tearDown(ITestResult result){
        if (result.getStatus()==ITestResult.FAILURE){
            final byte[] screenShot = ((TakesScreenshot)Driver.get()).getScreenshotAs(OutputType.BYTES);

        }

        Driver.closeDriver();
    }
}
