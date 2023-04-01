package all_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home {
	
	@FindBy(xpath="//button[@ng-click='customer()']")
	private WebElement custlogin;
	
	@FindBy(xpath="//button[text()='Bank Manager Login']")
	private WebElement bankmanagerlogin;
	
	@FindBy(xpath="//button[@class='btn home']")
	private WebElement homebtn;
	
	//step2- initialise variable 
	public Home(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//step3- method creation
	public void custlogin()
	{
		custlogin.click();
	}
	
	public void bankmanagerlogin()
	{
		bankmanagerlogin.click();
	}
	
	public void homebtn()
	{
		homebtn.click();
	}
	
	
	
	

}
