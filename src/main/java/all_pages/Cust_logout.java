package all_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Cust_logout {
	@FindBy(xpath="//button[@ng-show='logout']")
	private WebElement logoutbtn;
	
	//step2- initialise variable 
	public Cust_logout(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//step3- method creation
	public void logoutbtn()
	{
		logoutbtn.click();
	}
	

}
