package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.DashboardPage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC001_LoginTest extends BaseClass {
	
	
	@Test(groups= {"Sanity", "Regression", "Master"})
	public void verify_login()
	{
		logger.info("******* Starting TC001_LoginTest *********");
		
	try
	
	{
		//Login
		LoginPage lp=new LoginPage(driver);
		lp.setEmail(p.getProperty("email"));
		lp.setPassword(p.getProperty("password"));
		lp.clickSingin();
		
		//Dashboard
		 DashboardPage dp = new DashboardPage(driver);
		 boolean targetPage=dp.isDashboardPageExists();
		 
		 
		 // Assert.assertEquals(targetPage, true, "Login failed"); or 
		 Assert.assertTrue(targetPage);
	}
	catch(Exception e)
	{
		Assert.fail();
	}

		logger.info("******* Finished TC001_LoginTest ******");
		
		
	}
	
	
	
	
	
	}
	

	
	
