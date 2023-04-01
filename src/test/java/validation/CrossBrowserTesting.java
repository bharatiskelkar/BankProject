package validation;

import static org.testng.Assert.fail;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Utility.Screenshot;
import all_pages.Cust_Login;
import all_pages.Cust_logout;
import all_pages.Home;
import all_pages.loginmanagertwo;
import all_pages.managerlogin_page;
import all_pages.newcustpage;

public class CrossBrowserTesting {
	
	WebDriver driver;
	Cust_Login login;
	Cust_logout log;
	Home hm;
	managerlogin_page managerpage;
	newcustpage newc;
	loginmanagertwo two;
	int TestID;
	@Parameters("Browser")
	
	@BeforeTest
	public void openBrowser(String browsername) {
		System.out.println(browsername);
		
		if (browsername.equals("Chrome")) {
		
		//System.setProperty("webdriver.chrome.driver","C:\\Users\\yadav\\Downloads\\chromedriver_win32 (3)\\chromedriver.exe");
       
        ChromeOptions options=new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver=new ChromeDriver(options);
		}

		if (browsername.equals("FireFox")) {
			
			//System.setProperty("webdriver.chrome.driver","C:\\Users\\yadav\\Downloads\\chromedriver_win32 (3)\\chromedriver.exe");
	         driver = new FirefoxDriver(); // upcasting
			}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
		driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
	}
	
	@BeforeClass
	public void beforeclass()
	{
		login=new Cust_Login(driver);
		log=new Cust_logout(driver);
		hm=new Home(driver);
		managerpage=new managerlogin_page(driver);
		newc=new newcustpage(driver);
		two=new loginmanagertwo(driver);
	}
	
	@BeforeMethod
	public void banklogin() 
	{
		//login=new Cust_Login(driver);
		//login.loginscreen();
	}
	
	@Test(priority=0)
	
	public void home()
	{
		TestID=1;
		Home hm=new Home(driver);
		hm.custlogin();
	}
	
	@Test(priority=1)
	public void custdetails() {
		TestID=2;
		newc=new newcustpage(driver);
		newc.custselect();
		newc.firstcust();
		newc.submit();
		Home hm=new Home(driver);
		hm.homebtn();
		Assert.fail();
	}
	
//	@Test(priority=3)
//	public void managerlogin() {
//		managerpage=new managerlogin_page(driver);
//		managerpage.managercode();
//		managerpage.transactions();
//		managerpage.backbtn();
//		managerpage.deposit();
//		driver.navigate().back();
//		managerpage.backbtn();
//		managerpage.withdrawl();
//		log=new Cust_logout(driver);
//		log.logoutbtn();
//		Home hm=new Home(driver);
//		hm.homebtn();
//
//	}
	
	@Test(priority=2)
	public void seondmanager() {
		TestID=3;
		two=new loginmanagertwo(driver);
		two.bankmanagerlogintab();
		two.addcust();
		two.fname();
		two.lname();
		two.postcode();
		two.submittab();
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(10));
		Alert alert=wait.until(ExpectedConditions.alertIsPresent());
		alert.accept();
		hm=new Home(driver);
		hm.homebtn();
		two.bankmanagerlogintab();
		two.openacc();
		two.blankcustname();
		two.selectcust();
		two.blankcurrency();
		two.selectcurrency();
		two.process();
		alert.accept();
		two.custm();
		hm=new Home(driver);
		hm.homebtn();
	}
	
	@AfterMethod
	public void examsc(ITestResult a) throws IOException
	{
		if(ITestResult.FAILURE==a.getStatus())
		{
			Screenshot.sc(driver, TestID);
		}
	}
	
	@AfterClass
	public void afterclass()
	{
		login=null;
		log=null;
		hm=null;
		managerpage=null;
		newc=null;
		two=null;
	}
	
	@AfterTest
	public void afterTest() {
		System.gc(); // Garbage collector object delete memory clear
		driver.close();
	}
	

}
