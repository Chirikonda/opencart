package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	@DataProvider(name="LoginData")
	public String[][] getdata() throws IOException {
		
		//System.out.println("file path"+ System.getProperty("user.dir")+"\\testdata\\opencartdata.xls");
		//String path="C:\\Users\\achir\\Desktop\\Gow\\Opencart\\testdata\\opencartdata.xls";
		String path="C:\\Users\\achir\\Desktop\\Gow\\Opencart\\testdata\\Data.xls";
		System.out.println("file path : "+ path);
		System.out.println("Before file Open : ");
		Utility ex=new Utility(path);
		System.out.println("After file Open : ");
		
	int totalrows=ex.getrowcount("Sheet1");
	int totalcols=ex.getcellcount("Sheet1",1);
	
	String logindata[][]=new String[totalrows][totalcols];
	for(int i=1;i<=totalrows;i++) {
		for(int j=0;j<totalcols;j++) {
			logindata[i-1][j]=ex.getcelldata("Sheet1", i, j);
		}
	}
	return logindata;
		}
	
		
	}



		
		

	
		
	


	

	
	
	
	
		
		
	
		



	
	
	
		
	



		


		
	
		


