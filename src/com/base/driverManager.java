package com.base;

import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.time.Duration;


public class driverManager {
    public WebDriver driver;
    public ChromeDriver chromeDriver;
    public Boolean serverStarted  = false;
    public String dummyText;
    private String LOCAL_DIRECTORY_SOURCE = System.getProperty("user.dir") + File.separator + "browserDrivers" + File.separator;
    testConfiguration configuration;

    public driverManager(testConfiguration testConfiguration) {
        configuration= testConfiguration;
    }


    public WebDriver createDriver() throws Exception {
        String browser = configuration.getBrowser();
        switch (browser.toLowerCase()) {
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "chrome":
                System.setProperty("webdriver.chrome.driver","browserDrivers/chromedriver.exe");
                ChromeOptions options1 = new ChromeOptions();
                options1.addArguments("--disable-extensions");
                options1.addArguments("disable-infobars");
                options1.addArguments("start-maximized");
                options1.addArguments("--disable-gpu");
                options1.setCapability("app", "D:\\UI_AutomationPractice\\browserDrivers\\chromedriver.exe");
                options1.addArguments();
                 chromeDriver= new ChromeDriver(options1);
                System.out.println(chromeDriver.getCapabilities().getCapability("goog:chromeOptions"));
                String debuggerport=chromeDriver.getCapabilities().getCapability("goog:chromeOptions").toString().split("=")[1].replace("}","");
                System.out.println(debuggerport);
                driver=(WebDriver)chromeDriver;
                driver.manage().deleteAllCookies();
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
                driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
                break;
        }
        return driver;
    }

    public void quitDriver() {
        driver.quit();
    }

    public void closeDriver() {
        driver.close();
    }

    public void getScreenshot(Scenario scenario, String udid) throws Exception {
        if (scenario.isFailed()) {
            try {
                    byte[] exception = (byte[]) ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                    scenario.attach(exception, "image/jpeg",udid);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

}