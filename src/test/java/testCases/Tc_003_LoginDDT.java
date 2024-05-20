package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MYaccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class Tc_003_LoginDDT  extends BaseClass{
	
	@Test(dataProvider="LoginData",dataProviderClass=DataProviders.class)
	public void verify_loginDDT(String email,String password,String exp) {
		logger.info("***Starting Tc_003_LoginDDT ***");
        try {
   		 HomePage hp=new  HomePage(driver);
		 hp.account();
		 hp.logi();
		 
		 LoginPage lp=new LoginPage(driver);
		 lp.setmail(email);
		 lp.setpass(password);
		 lp.btnlog();
		 
		 
		MYaccountPage mcp=new MYaccountPage(driver);
		boolean tarpage= mcp.myaccountexists();
		
		//validation
		if(exp.equalsIgnoreCase("valid")) {
			if(tarpage==true) {
				mcp.lgout();
				Assert.assertTrue(true);
			}
			else {
				Assert.assertTrue(false);
			}
		}
		if(exp.equalsIgnoreCase("invalid")) {
			if(tarpage==true) {
				mcp.lgout();
				Assert.assertTrue(false);
			}
			else{
				Assert.assertTrue(true);
				
			}
		}
        }
        catch(Exception e) {
        	Assert.fail("An exception occured :"+e.getMessage());
        }
        logger.info("***Finshed Datadriven Test***");
		
		
	}

}
