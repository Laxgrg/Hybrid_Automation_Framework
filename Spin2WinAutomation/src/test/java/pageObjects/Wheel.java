package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Wheel {

    WebDriver driver;

    // Constructor to initialize the driver and PageFactory
    public Wheel(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);  // Initialize PageFactory
        
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    // Locators using @FindBy annotation
    @FindBy(xpath = "//div[@class='v-list-item__title'][normalize-space()='Wheels']")    //div[@class='v-list-item__title'][normalize-space()='Wheels'] //div[@class='v-list-item__title'][normalize-space()='Wheels']
    private WebElement wheelsTab;

    @FindBy(xpath = "//div[contains(text(),'List of Wheels')]")   //div[contains(text(),'List of Wheels')]
   private  WebElement listOfWheels;

    @FindBy(xpath = "//input[@id='input-386']")   //input[@id='input-386']  //input[@id='input-386']
    private WebElement searchField;

    @FindBy(xpath = "//td[normalize-space()='Staff']")  //td[normalize-space()='Staff']
    private WebElement staff;

//    @FindBy(xpath = "//a[contains(text(),'Wheel Information')]")
//    WebElement wheelInformation;

    @FindBy(xpath = "//div[contains(text(),'Click to copy URL')]")   //div[contains(text(),'Click to copy URL')]
    private WebElement copyURLButton;

    // Methods to interact with the elements
  // Getters to access these elements from outside of the class
    public WebElement getOnWheelsTab() {
        return wheelsTab;
    }

    public WebElement getListOfWheels() {
        return listOfWheels;
    }

    public WebElement getSearchField() {
        return searchField;
    }

    public WebElement getStaff() {
        return staff;
    }

//    public void clickOnWheelInformation() {
//        wheelInformation.click();
//    }

    public WebElement getCopyURLButton() {
        return copyURLButton;
    }

    public void openCopiedURL() {
        driver.get("https://app.staging.bm3group.com/spin/staff");
    }
}