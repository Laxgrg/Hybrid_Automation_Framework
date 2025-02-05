

package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;


public class BaseClass {
	
	public static WebDriver driver;
	public Logger logger;  //Log4j
	public Properties p;
	
	
	@BeforeMethod(groups = {"Sanity", "Regression", "Master"})  // can include DataDriven test as well 
	@Parameters({"os", "browser"})
	
	
	public void setup(String os, String br) throws IOException 
	
	{
		//Loading config.poroperties file
		
		FileReader file =new FileReader("./src/test/resources/config.properties");
		p=new Properties();
		p.load(file);
		
		
		logger = LogManager.getLogger(this.getClass());
		
		switch(br.toLowerCase()) 
		{
		case "chrome" : driver=new ChromeDriver(); break;
		case "edge" : driver=new EdgeDriver(); break;
		case "firefox" : driver= new FirefoxDriver(); break;
		default: System.out.println("Invalid browser name.."); return; 
		}
		
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
		driver.get(p.getProperty ("appURL2"));  // reading url from properties file
		driver.manage().window().maximize();
	
	}

	@AfterMethod (groups = {"Sanity", "Regression", "Master", "DataDriven"})
	
	public void tearDown() {
				
		driver.quit();
		
	}
	
	
	public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
				
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		
		String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" + timeStamp + ".png";
		File targetFile=new File(targetFilePath);
		
		sourceFile.renameTo(targetFile);
			
		return targetFilePath;

	}
	
	
	}
	


