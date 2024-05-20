package testBase;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;



public class BaseClass {
	static public WebDriver driver;
	public Logger logger;
	public Properties p;
	
	
	@BeforeClass(groups= {"sanity","regression","master"})
	@Parameters({"os","browser"})
	public void setup(String os,String br) throws IOException {
		
		//loading log4j file
		logger=LogManager.getLogger(this.getClass());
		
		//loading properetiesfile
		FileReader file=new FileReader(".//src//test//resources//config.properties");
		p=new Properties();
		p.load(file);
		
		if(p.getProperty("execution_env").equalsIgnoreCase("remote")) {
			
			//DesiredCapabilities cp=new DesiredCapabilities();
			DesiredCapabilities cp=new DesiredCapabilities();
			//os
			if(os.equalsIgnoreCase("windows")) {
				cp.setPlatform(Platform.WINDOWS);
			}
			else if(os.equalsIgnoreCase("mac")) {
				cp.setPlatform(Platform.MAC);
			}
			else {
				System.out.println("No matching browser");
				return;
			}
			
			//browser
			switch(br.toLowerCase()) {
			case "chrome" :cp.setBrowserName("chrome");break;
			case "edge" :cp.setBrowserName("MicrosoftEdge");break;
			default :System.out.println("No matching browser");return;
			
			}
			
			
			 driver=new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),cp);
			
			
			
		}
		else if(p.getProperty("execution_env").equalsIgnoreCase("local"))
		
		{
		
		//lanuching browser based on condition locally
		switch(br.toLowerCase()) 
		{
		case "chrome":driver = new ChromeDriver();break;
		case "edge":driver = new EdgeDriver();break;
		default:System.out.println("No matching browser..");
		return;
		}
		
		
		
		
		}
		
		//browser
		switch(br.toLowerCase()) {
		case "chrome":driver = new ChromeDriver();break;
		case "edge":driver = new EdgeDriver();break;
		default:System.out.println("No matching browser..");
		return;
		
		
		}
	
		
		
		
		
		
		
		
		
		
		
		
		//driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//driver.get("http://localhost/opencart/upload/");
		driver.get(p.getProperty("appURL"));
		driver.manage().window().maximize();
		
	}
	@AfterClass(groups= {"sanity","regression","master"})
	public void teardown() {
		driver.close();
	}
		
	
	
	public String randomstring() {
		String generatestring =RandomStringUtils.randomAlphabetic(5);
		return generatestring;
	}
	
	public String randomnumber() {
		String generatenum =RandomStringUtils.randomNumeric(10);
		return generatenum;
	}
	
	public String randomstringalphanum() {
		String str =RandomStringUtils.randomAlphabetic(3);
		String num =RandomStringUtils.randomNumeric(3);
		return (str+"@"+num);
	}
	public String captureScreen(String tname) {
		String timeStamp=new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot takescreenshot=(TakesScreenshot)driver;
		File sourcefile=takescreenshot.getScreenshotAs(OutputType.FILE);
		
		String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\"+tname+"_"+timeStamp+".png";
		File targetFile=new File(targetFilePath);
		sourcefile.renameTo(targetFile);
		return targetFilePath;
	}
	


}
