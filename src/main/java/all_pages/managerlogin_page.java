package all_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class managerlogin_page {

	@FindBy(xpath="//select[@ng-hide='noAccount']")
	private WebElement managercode;
	
	@FindBy(xpath="(//button[@class='btn btn-lg tab'])[1]")
	private WebElement transactions;
	
	@FindBy(xpath="//button[text()='Back']")
	private WebElement backbtn;
	
	@FindBy(xpath="(//button[@class='btn btn-lg tab'])[2]")
	private WebElement deposit;
	
	@FindBy(xpath="(//button[@class='btn btn-lg tab'])[3]")
	private WebElement withdrawl;
	
	//step2- initialise variable 
	public managerlogin_page(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//step3- method creation
	public void managercode()
	{
		managercode.click();
	}
	
	public void transactions()
	{
		transactions.click();
	}
	
	public void backbtn()
	{
		backbtn.click();
	}
	
	public void deposit()
	{
		deposit.click();
	}
	
	public void withdrawl()
	{
		withdrawl.click();
	}
	
}
