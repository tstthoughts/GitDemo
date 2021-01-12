package stepDefinitions;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;


import Cucumber.Automation.Base;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class hooks extends Base {
	 OutputStream fos = null;
	 static String projectPath = System.getProperty("user.dir");
	 File file = new File(projectPath+"\\src\\test\\java\\Cucumber\\Automation\\global.properties");
	@Before("@MobileTest")
	public void beforeValidation() {
		System.out.println("***Mobile before Hook***");
	}

	@After("@MobileTest")
	public void afterValidation() {
		System.out.println("***Mobile after Hook***");
	}

	@After()  //"@Search"
	public void afterSeleniumTest() throws IOException {
		driver.close();
		System.out.println("browser closed");
		
		//just for knowledge
		/*
		 * prop.setProperty("Result", "Passed"); fos = new FileOutputStream(file);
		 * prop.store(fos, null);
		 */
		driver.quit();
	}
	

	@Before() //"@WebTest"
	public void beforeWValidation() throws IOException {
		driver = Base.getDriver();
		//System.out.println("***Web before Hook***");
	}

	@After("@WebTest")
	public void afterWValidation() {
		System.out.println("***Web after Hook***");
	}
}
