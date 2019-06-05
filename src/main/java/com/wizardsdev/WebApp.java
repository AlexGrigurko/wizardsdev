package com.wizardsdev;

import com.wizardsdev.page.GoogleMainPage;
import com.wizardsdev.page.GoogleResultPage;
import org.openqa.selenium.WebDriver;

public class WebApp {

    private WebDriver webdriver;

    public WebApp(WebDriver webdriver) {
        this.webdriver = webdriver;
    }

    public GoogleMainPage googleMainPage() {
        return new GoogleMainPage(webdriver);
    }

    public GoogleResultPage googleResultPage() {
        return new  GoogleResultPage(webdriver);
    }
}
