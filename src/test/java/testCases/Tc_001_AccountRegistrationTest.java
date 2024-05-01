package testCases ;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountregistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class Tc_001_AccountRegistrationTest extends BaseClass {
	// WebDriver driver;
	@Test(groups= {"regression","master"})
	public void testmethod() throws InterruptedException, Exception{
		logger.info("*********Starting Tc_001_AccountRegistrationTest************");
		logger.debug("application logs..........");
		try {
		HomePage hp=new HomePage(driver);
		hp.account();
		logger.info("****Clicked on Myaccount link*********");
		hp.register();
		logger.info("**********Clicked on registration link******");
		
		
      
		
		 AccountregistrationPage ap=new  AccountregistrationPage(driver);
		 logger.info("**********Entering customer information******");
		 ap.setFtistName(randomstring().toUpperCase());
		 ap.setLasttName(randomstring().toUpperCase());
		 ap.setEmail(randomstring()+"@gmail.com");
		 ap.settele(randomnumber());
		 String passwrd=randomstringalphanum();
		 ap.setPassword(passwrd);
		 ap.conpass(passwrd);
		 
		  ap.clickagree();
		  logger.info("****Clicked on agree*****");
		
		 ap.clicksubmitt();
		 logger.info("******Clicked on continue*********");
		 
		String text= ap.massage();
		logger.info("********Validating Massage*********");
		
		if(text.equals("Your Account Has Been Created!")) {
			logger.info("Test passed");
			Assert.assertTrue(true);
		}
		else {
			logger.error("Test failed");
			Assert.fail();
		}
	
		}
		catch(Exception e) {
			logger.error("Test fail");
			Assert.fail();
		}
		logger.info("******Finished Test case************");
		
	}
	

	}
