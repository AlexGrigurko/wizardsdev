package com.wizardsdev.driverholder;

import org.openqa.selenium.WebDriver;

public class DriverHolder {
    private static WebDriver storedDriver;
    private static ThreadLocal<WebDriver> storedDriverThreadLocal;

    public static void setWebDriver(WebDriver driver) {
        storedDriver = driver;
    }

    public synchronized static WebDriver getWebDriver() throws Exception{
        if (storedDriver == null) {
            throw new Exception("Driver not set!!!!");
        }
        return storedDriver;
    }

    public static void resetSession(WebDriver driver) {
        if (driver != null) {
            storedDriver.quit();
            storedDriver = null;
        }
    }
}
