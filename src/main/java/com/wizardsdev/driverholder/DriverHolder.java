package com.wizardsdev.driverholder;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverHolder {

    private static WebDriver webDriverChrome;
    private static WebDriver webDriverFireFox;

    public synchronized static WebDriver getWebDriver(String driverName) throws Exception {

        if (driverName.equalsIgnoreCase("chrome")) {
            if (webDriverChrome == null) {
                WebDriverManager.chromedriver().version("73").setup();
                webDriverChrome = new ChromeDriver();
            }
            return webDriverChrome;
        } else if (driverName.equalsIgnoreCase("firefox")) {
            if (webDriverFireFox == null) {
                WebDriverManager.firefoxdriver().setup();
                webDriverFireFox = new FirefoxDriver();
            }
            return webDriverFireFox;
        }
        throw new Exception("ups");
    }

    public static void resetSession(String driverName) {
        if (driverName.equalsIgnoreCase("chrome")) {
            if (webDriverChrome != null) webDriverChrome.quit();
        } else if (driverName.equalsIgnoreCase("firefox")) webDriverFireFox.quit();
    }
}
