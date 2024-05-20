package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MYaccountPage extends BasePage{
	
	
	public MYaccountPage(WebDriver driver){
		 super(driver);
	 }
	 @FindBy(xpath="//h2[text()='My Account']")
		WebElement account;
	 
	 @FindBy(xpath="//div[@class='list-group']//a[text()='Logout']")
		WebElement logout;
	 
	 public boolean myaccountexists() {
		 try {
		return (account.isDisplayed());
		 }
		 catch(Exception e) {
			 return(false);
		 }
		 
			
		}
	 public void lgout() {
		 logout.click();
		}


}
