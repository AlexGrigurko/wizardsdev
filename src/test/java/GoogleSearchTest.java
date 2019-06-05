import cucumber.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.junit.Assert.assertTrue;

public class GoogleSearchTest extends TestBase {

    @BeforeMethod
    public void before() {
        webDriver.get("https://google.com/");
    }

    @Test
    public void testGoogleSearch() throws InterruptedException {
        webApp.googleMainPage().googleSimpleSearch("java");
        assertTrue(webApp.googleResultPage().searchResultItem().getText().contains("java"));
    }
    @Test
    public void test2GoogleSearch() throws InterruptedException {
        webApp.googleMainPage().searchField().sendKeys("java");
        Thread.sleep(500);
        webApp.googleMainPage().buttonFind().click();
        assertTrue(webApp.googleResultPage().searchResultItem().getText().contains("java"));
    }

    @Test
    public void testLuckySerch() throws InterruptedException {
        webApp.googleMainPage().googleLuckySearch("java");
        assertTrue(webDriver.getCurrentUrl().contains("https://www.java.com"));
    }
}
