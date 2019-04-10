package com.wizardsdev.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleMainPage {

    private WebDriver webDriver;
    private WebDriverWait wait;

    public GoogleMainPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        wait = new WebDriverWait(webDriver, 30);
        PageFactory.initElements(webDriver, this);
    }

    public WebElement searchField() { return webDriver.findElement(By.name("q")); }

    public WebElement buttonFind() { return webDriver.findElement(By.name("btnK")); }

    public WebElement buttonLukySerch() { return webDriver.findElement(By.name("btnI")); }

    public void googleSimpleSearch(String query) throws InterruptedException {
        searchField().sendKeys(query);

        Thread.sleep(500);

        buttonFind().click();
    }

    public void googleLuckySearch(String query) throws InterruptedException {
        searchField().sendKeys(query);

        Thread.sleep(500);

        buttonLukySerch().click();
    }
}
