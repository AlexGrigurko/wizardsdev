package cucumber;

import com.wizardsdev.WebApp;
import com.wizardsdev.driverholder.DriverHolder;
import cucumber.api.testng.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.sql.DriverManager;

public class RunCucumberTests extends AbstractTestNGCucumberTests {

    private TestNGCucumberRunner testNGCucumberRunner;

    protected WebDriver webDriver;
    protected WebDriverWait wait;
    protected WebApp webApp;

    @BeforeClass(alwaysRun = true)
    public void setUpClass() {
        System.out.println("TestNG Before Test Class");

        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
    }

    @BeforeMethod
    @Parameters({"browserName"})
    public void setUp(@Optional("Chrome") String browserName) throws Exception{
        System.out.println("TestNG Before Method");

        //init new Driver with DriverManager - depends on browserName

        if (browserName.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            webDriver = new ChromeDriver();
        }

        DriverHolder.setWebDriver(webDriver);
        //create new PageManager and init with DriverHolder.getDriver()
        webApp = new WebApp(DriverHolder.getWebDriver());
        /*
         *init DriverHolder with just created Driver
         *init PageManagerHolder with just created PageManager
         */
    }

    @Test
    public void scenario(PickleEventWrapper pickleEvent, CucumberFeatureWrapper cucumberFeature) throws Throwable {
        System.out.println("TestNG Test");
        testNGCucumberRunner.runScenario(pickleEvent.getPickleEvent());
    }

    @DataProvider
    public Object[][] tests() {
        System.out.println("Test NGData Provider");
        return testNGCucumberRunner.provideScenarios();
    }

    @AfterMethod
    public synchronized void teardown() {

        DriverHolder.resetSession(webDriver);
        System.out.println("TestNG Tear Down AfterMethod");
    }


    @AfterClass(alwaysRun = true)
    public void tearDownClass() {
        System.out.println("TestNG TearDown After Class");
        testNGCucumberRunner.finish();
    }
}
