package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Cucumber.Automation.Base;

public class HomePage extends Base {
	public WebDriver driver;
	
	//constructor
	public HomePage (WebDriver driver) {
		this.driver = driver;
	}
	By Search = By.xpath("//input[@type='search']");
	
	//Develop update
	//second develop commit
	//third develop commit
	//git plugin add
	public WebElement getSearch() {
		return driver.findElement(Search);
	}
}
