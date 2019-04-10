import com.wizardsdev.WebApp;
import com.wizardsdev.driverholder.DriverHolder;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertTrue;

public class GoogleSearchTest {

    private WebDriver webDriver;
    private WebApp webApp;

    @Before
    public void before() throws Exception {
        System.out.println("Try to open web browser");
        webDriver = DriverHolder.getWebDriver("chrome");
        webDriver.get("https://google.com/");
        webApp = new WebApp(webDriver);
    }

    @Test
    public void testGoogleSearch() throws InterruptedException {
        webApp.googleMainPage().googleSimpleSearch("java");
        assertTrue(webApp.googleResultPage().searchResultItem().getText().contains("java"));
    }

    @Test
    public void testLuckySerch() throws InterruptedException {
        webApp.googleMainPage().googleLuckySearch("java");
        assertTrue(webDriver.getCurrentUrl().contains("https://www.java.com"));
    }
}
