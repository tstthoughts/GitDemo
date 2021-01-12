package Cucumber.Automation;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
public class Base {
	public static WebDriver driver ;
	public static Properties prop;
	static String projectPath = System.getProperty("user.dir");
	public static WebDriver getDriver() throws IOException
	{
		 prop = new Properties();
		 
		 //this will get current user directory path
		 
		 System.out.println("projectPath:" + projectPath);
		 //path of the properties file
		 File file = new File(projectPath+"\\src\\test\\java\\Cucumber\\Automation\\global.properties");
		 
		//Instream is fileinputstream type - what all properties defined in this file will read 
		 InputStream fis = null;
		 
		 
		 try {
			 fis = new FileInputStream(file);
			 
			 //load properties file
			 prop.load(fis);
		 } 
		 catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		 catch (IOException e) {
			 e.printStackTrace();
		 }
		 
		 switch(prop.getProperty("browser")) {
		 	  case "chrome":
			    // code block
		 		 System.setProperty("webdriver.chrome.driver", "C:\\Users\\sathy\\eclipse-workspace\\chromedriver.exe");
			     driver = new ChromeDriver();
			     
			    break;
			  case "edge":
				  System.setProperty("webdriver.edge.driver", "C:\\Users\\sathy\\eclipse-workspace\\msedgedriver.exe");
				     driver = new EdgeDriver();
			    break;
			  
		 }
		 
	     driver.manage().window().maximize();
	     System.out.println(prop.getProperty("url_UAT"));
	     //System.out.println(prop.getProperty("exp"));
	     driver.get(prop.getProperty("url_QA"));
	     
	     return driver;
	}
}
