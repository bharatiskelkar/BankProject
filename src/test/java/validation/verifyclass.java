package validation;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import all_pages.Cust_Login;
import all_pages.Cust_logout;
import all_pages.Home;
import all_pages.loginmanagertwo;
import all_pages.managerlogin_page;
import all_pages.newcustpage;

public class verifyclass {
	
	ChromeDriver driver;
	Cust_Login login;
	Cust_logout log;
	Home hm;
	managerlogin_page managerpage;
	newcustpage newc;
	loginmanagertwo two;
	
	@BeforeClass
	public void beforefirst()
	{
		//System.setProperty("Webdriver.crome.driver","C:\\Users\\OMKAR\\Downloads\\chromedriver_win32\\chromedriver.exe");
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver=new ChromeDriver(options);
		driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		String url=driver.getCurrentUrl();
		System.out.println(url);
		Assert.assertEquals(url, "https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login","Test case pass");
	
	}
	
	@BeforeMethod
	public void banklogin() 
	{
		login=new Cust_Login(driver);
		//login.loginscreen();
	}
	
	@Test(priority=0)
	public void home()
	{
		Home hm=new Home(driver);
		hm.custlogin();
		//hm.bankmanagerlogin();
	}
	
	@Test(priority=1)
	public void custdetails() {
		newc=new newcustpage(driver);
		newc.custselect();
		newc.firstcust();
		newc.submit();
	}
	
	@Test(priority=2)
	public void managerlogin() {
		managerpage=new managerlogin_page(driver);
		managerpage.managercode();
		managerpage.transactions();
		managerpage.backbtn();
		managerpage.deposit();
		driver.navigate().back();
		managerpage.backbtn();
		managerpage.withdrawl();
		log=new Cust_logout(driver);
		log.logoutbtn();
		Home hm=new Home(driver);
		hm.homebtn();

	}
	
	@Test(priority=3)
	public void seondmanager() {
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
	
	@AfterClass
	public void endcls()
	{
		driver.close();
	}

}
