package com.sample.test.demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.testng.Assert.fail;

public class DriverHelper {
    private Configuration config = new Configuration();
    protected WebDriver driver;
    private ChromeOptions options = new ChromeOptions();


    public WebDriver getDriver() {
        switch(config.getBrowser().toLowerCase()){
            case "chrome":
                if (config.getPlatform().equalsIgnoreCase("mac"))
                    {
                    System.setProperty("webdriver.chrome.driver",
                            "src/test/resources/chromedriver/mac/chromedriver");
                    }
                else
                    {
                    System.setProperty("webdriver.chrome.driver",
                            "src/test/resources/chromedriver/windows/chromedriver.exe");
                    }
                chromeSetting();
                driver = new ChromeDriver(options);
                break;
            case "firefox":
                break;
            case "edge":
                break;
            default:
                fail("Unsupported browser " + config.getBrowser());
        }
        return driver;
    }

    private void chromeSetting(){
        options.addArguments("disable-infobars");
        options.addArguments("--incognito");
        options.addArguments("--disable-gpu");
        options.addArguments("--no-sandbox");
        options.addArguments("--allow-insecure-localhost");
        //options.addArguments("--headless");
        options.setAcceptInsecureCerts(true);
        options.addArguments("--start-maximized");
    }
}
