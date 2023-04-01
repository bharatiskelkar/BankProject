package all_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Cust_Login {
	
	@FindBy(xpath="//button[@ng-click='home()']")
	private WebElement loginscreen;

	
	//step2- initialise variable 
	public Cust_Login(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//step3- method creation
	public void loginscreen()
	{
		loginscreen.click();
	}
	
	

}
