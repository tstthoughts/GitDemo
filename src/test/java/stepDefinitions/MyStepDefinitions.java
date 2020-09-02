package stepDefinitions;

import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Cucumber.Automation.Base;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.HomePage;

public class MyStepDefinitions extends Base {
	//WebDriver driver;
	HomePage hp ;
    @Given("^User is on Greencart Landing page$")
    public void user_is_on_greencart_landing_page() throws Throwable {
    	driver = Base.getDriver();
    }

    @When("^User searched for \"([^\"]*)\" vegetable$")
    public void user_searched_for_something_vegetable(String strArg1) throws Throwable {
    	hp= new HomePage(driver) ;
    	hp.getSearch().sendKeys(strArg1);
     Thread.sleep(5000);
    }

    
    @When("^User searched for (.+) type vegetable$")
    public void user_searched_for_vegetable(String name) throws Throwable {
    	hp= new HomePage(driver) ;
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


}
