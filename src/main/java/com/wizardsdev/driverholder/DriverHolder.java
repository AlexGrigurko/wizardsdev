package com.wizardsdev.driverholder;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverHolder {

    private static WebDriver webDriverChrome;
    private static WebDriver webDriverFireFox;

    public synchronized static WebDriver getWebDriver(String driverName) {

        WebDriver driver = null;

        if (driverName.equalsIgnoreCase("chrome")) {
            if (webDriverChrome == null) {
                WebDriverManager.chromedriver().version("74").setup();
                webDriverChrome = new ChromeDriver();
            }
            driver = webDriverChrome;
        } else if (driverName.equalsIgnoreCase("firefox")) {
            if (webDriverFireFox == null) {
                WebDriverManager.firefoxdriver().setup();
                webDriverFireFox = new FirefoxDriver();
            }
            driver = webDriverFireFox;
        }
        return driver;
    }

    public static void resetSession(WebDriver driver) {

        if (driver != null) {
            driver.quit();
            webDriverChrome = null;
        }
    }
}
