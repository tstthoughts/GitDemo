package stepDefinitions;

import Cucumber.Automation.Base;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class hooks extends Base{

	@Before("@MobileTest")
	public void  beforeValidation()
	{
		System.out.println("***Mobile before Hook***");
	}
	
	@After("@MobileTest")
	public void  afterValidation()
	{
		System.out.println("***Mobile after Hook***");
	}
	
	@After("@Search")
	public void  afterSeleniumTest()
	{
		driver.close();
	}
	

	@Before("@WebTest")
	public void  beforeWValidation()
	{
		System.out.println("***Web before Hook***");
	}
	
	@After("@WebTest")
	public void  afterWValidation()
	{
		System.out.println("***Web after Hook***");
	}
}
