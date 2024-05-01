package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MYaccountPage;
import testBase.BaseClass;

public class Tc_002_LoginTest  extends BaseClass{
	
	@Test(groups= {"sanity","master"})
	public  void verfiylogin() {
		logger.info("****Starting Tc_002_LoginTest****");
		logger.debug("capturing application debuglogs....");
		try {
		
		 HomePage hp=new  HomePage(driver);
		 hp.account();
		 logger.info("we clicked on my account link");
		 hp.logi();
		 logger.info("we clicked on loginlink...");
		 
		 LoginPage lp=new LoginPage(driver);
		 logger.info("entering valid details");
		 lp.setmail(p.getProperty("email"));
		 lp.setpass(p.getProperty("password"));
		 lp.btnlog();
		 logger.info("clicked on login button...");
		 
		 MYaccountPage mcp=new MYaccountPage(driver);
		boolean tarpage= mcp.myaccountexists();
		if(tarpage == true) {
			logger.info("login test passed");
			Assert.assertTrue(true);
		}
		else {
			logger.error("login test failed");
			Assert.fail();
		}
		}
		catch(Exception e) {
			Assert.fail();
		}
		
		logger.info("****Ending  Tc_002_LoginTest****"); 
		
	}

}
