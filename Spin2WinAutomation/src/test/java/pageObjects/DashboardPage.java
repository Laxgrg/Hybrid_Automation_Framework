
package pageObjects;

import java.time.Duration;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashboardPage extends BasePage {

    private WebDriverWait wait;

    public DashboardPage(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

	@FindBy(xpath = "//div[contains(text(),'Dashboard')]")
		WebElement msgHeading;    

//	@FindBy(xpath = "//span[@class='v-btn__content']//i[@class='v-icon notranslate mdi mdi-chevron-down theme--light']")
//		WebElement adminLink;
//		
//		@FindBy(xpath="//div[contains(text(),'Logout')]")
//		WebElement logoutLink;

		
		public boolean isDashboardPageExists() 
		
		{
			try 
			{
			return (msgHeading.isDisplayed());
		}
			catch(Exception e) 
		{
				return false;
			}
	}
}


	








	


