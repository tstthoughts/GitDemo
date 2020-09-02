package Cucumber.Automation;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {
	public static WebDriver driver ;
	public static Properties prop;
	public static WebDriver getDriver() throws IOException
	{
		 prop = new Properties();
		 FileInputStream fis = new FileInputStream("C:\\Users\\sathy\\eclipse-workspace\\Automation\\src\\test\\java\\Cucumber\\Automation\\global.properties");
		 prop.load(fis); //Instream is fileinputstream type - what all properties defined in this file will read 
		 System.setProperty("webdriver.chrome.driver", "C:\\Users\\sathy\\eclipse-workspace\\chromedriver.exe");
	     driver = new ChromeDriver();
	     driver.manage().window().maximize();
	     driver.get(prop.getProperty("url"));
	     return driver;
	}
}
