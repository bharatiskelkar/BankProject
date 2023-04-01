package all_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class newcustpage {
	
	@FindBy(xpath="//select[@name='userSelect']")
	private WebElement custselect;
	
	@FindBy(xpath="(//option[@class='ng-binding ng-scope'])[1]")
	private WebElement firstcust;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement submit;
	
	//step2- initialise variable 
	public newcustpage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//step3- method creation
	public void custselect()
	{
		custselect.click();
	}
	
	public void firstcust()
	{
		firstcust.click();
	}
	
	public void submit()
	{
		submit.click();
	}
}
