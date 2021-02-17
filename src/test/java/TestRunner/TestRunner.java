package TestRunner;
import DriverManagement.DriverManagement;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
@RunWith (Cucumber.class)

@CucumberOptions(
        features = "src/test/java/features",
        glue = {"StepDefinition"}
//        tags = {"@Smoke"}
)

public class TestRunner {
    @BeforeClass
    public static void setup(){
        DriverManagement.initializeDriver();
    }
    @AfterClass
    public static void teardown(){
        DriverManagement.stopDriver();
    }
}
