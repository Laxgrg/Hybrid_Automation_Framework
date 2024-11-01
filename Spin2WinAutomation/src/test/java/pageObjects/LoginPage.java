package pageObjects;

import java.time.Duration;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {
	
	private WebDriverWait wait;
	
	
	public LoginPage(WebDriver driver) {
		super(driver);
		
	//Initialize the WebDriverWait with a timeout of 10 seconds
	      wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	@FindBy(xpath= "//input[@id='input-31']")        
	WebElement txtEmailAddress;
	
	@FindBy(xpath= "//input[@id='input-34']")
	WebElement txtPassword;
	
	@FindBy(xpath="//span[normalize-space()='Sign In']")  
	WebElement btnSignin;	


     public void setEmail(String email) {
    	// Wait until the email field is visible and then interact with it
         wait.until(ExpectedConditions.visibilityOf(txtEmailAddress));
         
    	 txtEmailAddress.sendKeys(email);

}
     public void setPassword(String pwd) {
    	// Wait until the password field is visible and then interact with it
         wait.until(ExpectedConditions.visibilityOf(txtPassword));
    	 txtPassword.sendKeys(pwd);
     }
     
     public void clickSingin() {
    	// Wait until the Sign In button is clickable and then interact with it
         wait.until(ExpectedConditions.elementToBeClickable(btnSignin));
    	 btnSignin.click();
     }
     
     public void clearFields() {
    	    wait.until(ExpectedConditions.visibilityOf(txtEmailAddress));
    	    txtEmailAddress.click();  // Bring the element into focus
    	    txtEmailAddress.clear();

    	    wait.until(ExpectedConditions.visibilityOf(txtPassword));
    	    txtPassword.click();  // Bring the element into focus
    	    txtPassword.clear();
    	}
}
    	 
    
     
     
  

    	

    	

   

    
     

     

