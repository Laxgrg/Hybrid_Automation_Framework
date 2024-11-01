

package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.DashboardPage;
import pageObjects.LoginPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC002_LoginDDT extends BaseClass {

    @Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class, groups="Datadriven")
    public void verify_logoutDDT(String email, String pwd, String exp) {

        logger.info("****** Starting TC002_LoginDDT ******");
        
        LoginPage lp = null; // Declare the lp variable outside the try block 

        try {
            // Login process
            lp = new LoginPage(driver);   // Instantiate lp inside the try block
            logger.info("Email used for login: " + email);
            logger.info("Password used for login: " + pwd);
            lp.setEmail(email);
            lp.setPassword(pwd);
            lp.clickSingin();
  
        			
        		//Dashboard verification
            
        		 DashboardPage dp = new DashboardPage(driver);
        		 //boolean targetPage=dp.isDashboardPageExists();
        		 boolean isDashboardDisplayed = dp.isDashboardPageExists();
        		 
        		 logger.info("Dashboard display status: " + isDashboardDisplayed);

                 if (exp.equalsIgnoreCase("valid")) {
                     if (isDashboardDisplayed) {
                         logger.info("Login succeeded with valid credentials as expected.");
                         Assert.assertTrue(true, "Valid login test passed.");
                     } else {
                         logger.error("Login failed with valid credentials.");
                         Assert.fail("Expected dashboard to be displayed for valid credentials.");
                     }
                 } else if (exp.equalsIgnoreCase("invalid")) {
                     if (!isDashboardDisplayed) {
                         logger.info("Login failed with invalid credentials as expected.");
                         Assert.assertTrue(true, "Invalid login test passed.");
                     } else {
                         logger.error("Login succeeded with invalid credentials.");
                         Assert.fail("Unexpected dashboard display for invalid credentials.");
                     }
                 }
             } catch (Exception e) {
                 logger.error("Test case failed due to an exception: " + e.getMessage());
                 Assert.fail("Exception during test execution: " + e.getMessage());
             } finally {
                 if (lp != null) {
                     logger.info("Clearing fields after the test execution");
                     lp.clearFields();
                 }
             }
             logger.info("******* Finished TC002_LoginDDT ******");
         }
     }
        		 
        		 
        		 
        		 
        		 
        		 
        		 