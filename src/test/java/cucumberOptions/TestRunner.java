package cucumberOptions;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/java/features",
		glue = "stepDefinitions",
		tags = "@Search",
		monochrome = true,
		plugin = {"pretty","html:target/cucumber.html","json:target/cucumber.json", "json:target/cukes.xml"},
		publish=true
		)
public class TestRunner {

}
