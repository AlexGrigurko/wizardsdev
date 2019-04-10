package com.wizardsdev.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GoogleResultPage {

    private WebDriver webDriver;

    public GoogleResultPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public WebElement searchResultItem() { return webDriver.findElement(By.className("g")); }
}
