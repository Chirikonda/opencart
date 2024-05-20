package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
	
	public LoginPage(WebDriver driver) {
		super(driver);
		
	}
	@FindBy(xpath="//input[@id='input-email']")
	WebElement ema;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement pss;
	
	@FindBy(xpath="//input[@value='Login']")
	WebElement lgn;
	
	public void setmail(String em) {
		ema.sendKeys(em);
	}
		
		public void setpass(String pa) {
			pss.sendKeys(pa);
		}
			
			public void btnlog() {
				lgn.click();
		
		
	}

}
