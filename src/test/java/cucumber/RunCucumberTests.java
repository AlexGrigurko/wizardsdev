package cucumber;

import cucumber.api.testng.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

public class RunCucumberTests extends AbstractTestNGCucumberTests {

    private TestNGCucumberRunner testNGCucumberRunner;

    protected WebDriverWait wait;

    @BeforeClass(alwaysRun = true)
    public void setUpClass() {
        System.out.println("TestNG Before Test Class");

        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
    }

    @BeforeMethod
    @Parameters({""})
    public void setUp() {
        System.out.println("TestNG Before Method");

        DesiredCapabilities capabilities = new DesiredCapabilities();
        /*
        *
        *
        *
        *
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
    public synchronized void teardown(){
        System.out.println("TestNG Tear Down AfterMethod");
    }


    @AfterClass(alwaysRun = true)
    public void tearDownClass() throws Exception {
        System.out.println("TestNG TearDown After Class");
        testNGCucumberRunner.finish();
    }
}
