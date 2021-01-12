package cucumberOptions;

import java.io.File;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.vimalselvam.cucumber.listener.Reporter;

import Cucumber.Automation.FileReaderManager;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/java/features",
		glue = "stepDefinitions",
		tags = "@Search",
		monochrome = true,
		dryRun = false,
		plugin = {"pretty", "html:target/cucumber.html", "json:target/cucumberReport.json", "json:target/cukesReport.xml" }, publish = true)
//"com.vimalselvam.cucumber.ExtentCucumberFormatter:target/cucumber-reports/report.html"
// for debugging :: F5 for moving into a function // F6 for next step in the execution  //F8 to resume to run
public class TestRunner {
	/*
	 * @AfterClass public static void writeExtentReport() {
	 * Reporter.loadXMLConfig(new
	 * File(FileReaderManager.getInstance().getConfigReader().getReportConfigPath())
	 * ); //another way above step delcaration :: Reporter.loadXMLConfig(new
	 * File("config/extent-config.xml"));
	 * 
	 * }
	 */
}
