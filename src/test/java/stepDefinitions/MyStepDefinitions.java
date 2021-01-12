package stepDefinitions;

import java.io.File;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.util.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Cucumber.Automation.Base;
import Cucumber.Automation.Log4JDemo;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.HomePage;


public class MyStepDefinitions extends Base {
	//public static Scenario scenario;
	// WebDriver driver;
	HomePage hp;
	private static Logger logger = LogManager.getLogger(MyStepDefinitions.class);
	
	@Given("^User is on Greencart Landing page$")
	public void user_is_on_greencart_landing_page() throws Throwable {
		// driver = Base.getDriver();
		System.out.println("browser launched");
		logger.info("step def logger info");
	}

	@When("^User searched for \"([^\"]*)\" vegetable$")
	public void user_searched_for_something_vegetable(String strArg1) throws Throwable {
		hp = new HomePage(driver);
		hp.getSearch().sendKeys(strArg1);
		Thread.sleep(5000);
	}

	@When("^User searched for (.+) type vegetable$")
	public void user_searched_for_vegetable(String name) throws Throwable {
		hp = new HomePage(driver);
		hp.getSearch().sendKeys(name);
		Thread.sleep(5000);
	}

	@Then("^\"([^\"]*)\" results are displayed$")
	public void something_results_are_displayed(String strArg1) throws Throwable {
		Thread.sleep(3000);
		Assert.assertTrue(driver.findElement(By.cssSelector("h4.product-name")).getText().contains(strArg1));
	}

	@Then("^verify selected (.+) items are displayed in check out$")
	public void verify_selected_items_are_displayed_in_check_out(String name) throws Throwable {
		Assert.assertTrue(driver.findElement(By.cssSelector("p.product-name")).getText().contains(name));
		Assert.fail("explicit fail");
	}

	@And("^Added items to cart$")
	public void added_something_items_to_cart() throws Throwable {

		driver.findElement(By.xpath("//p[@class='product-price']")).click();
		driver.findElement(By.cssSelector("a.increment")).click();
		driver.findElement(By.xpath("//button[contains(text(),'ADD TO CART')]")).click();
	}

	@And("^User proceeded to checkout page for purchase$")
	public void user_proceeded_to_checkout_page_for_purchase() throws Throwable {
		driver.findElement(By.xpath("//img[@alt='Cart']")).click();
		driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();

	}

	public String scenarioNameLength(Scenario scenario) {
		int sceNameLen = scenario.getName().length();
		String star = "";
		for(int i=0; i<= sceNameLen; i++) {
			star = star + "*";
		}
		return star;
	}
	@Before
	public void before(Scenario scenario) {
		logger.info("*****************"+scenarioNameLength(scenario)+"***");
		logger.info("   Scenario Name:"+  scenario.getName());
		logger.info("*****************"+scenarioNameLength(scenario)+"***");
		}
	
	// just for reff
	@After
	public void tearDown(Scenario scenario) {
		logger.info("#########End of the Scenario:"+  scenario.getName()+"  #########");
		logger.info("\n");
		if (scenario.isFailed()) {
			// Take a screenshot...
			/*
			 * File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			 * String dest = "C:\\Users\\sathy\\eclipse-workspace\\GitDemo"; File target =
			 * new File(dest); FileUtils.copyFile(src, target);
			 */
			final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", "screenshot1");

		}
	}

}
