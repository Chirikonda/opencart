package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage  extends BasePage{
	WebDriver driver;
	public HomePage(WebDriver driver) {
		super(driver);
		
	}
	@FindBy(xpath="//span[normalize-space()='My Account']")
	WebElement linkaccount;
	
	@FindBy(xpath="//a[normalize-space()='Register']")
	WebElement linkregister;
	@FindBy(xpath="//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Login']")
	WebElement login;
	
	public void account() {
		linkaccount.click();
	}
	public void register() {
		linkregister.click();
	}
	public void logi() {
		login.click();
		
	}

}
