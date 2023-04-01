package all_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginmanagertwo {
	
	@FindBy(xpath="//button[text()='Bank Manager Login']")
	private WebElement bankmanagerlogintab;
	
	@FindBy(xpath="(//button[@class='btn btn-lg tab'])[1]")
	private WebElement addcust;
	
	@FindBy(xpath="//input[@ng-model='fName']")
	private WebElement fname;
	
	@FindBy(xpath="//input[@ng-model='lName']")
	private WebElement lname;
	
	@FindBy(xpath="//input[@ng-model='postCd']")
	private WebElement postcode;
	
	@FindBy(xpath="//button[text()='Add Customer']")
	private WebElement submittab;
	
	@FindBy(xpath="//button[@ng-class='btnClass2']")
	private WebElement openacc;
	
	@FindBy(xpath="//select[@name='userSelect']")
	private WebElement blankcustname;
	
	@FindBy(xpath="//option[text()='Harry Potter']")
	private WebElement selectcust;
	
	@FindBy(xpath="//select[@ng-model='currency']")
	private WebElement blankcurrency;
	
	@FindBy(xpath="//option[text()='Dollar']")
	private WebElement selectcurrency;
	
	@FindBy(xpath="//button[text()='Process']")
	private WebElement process;
	
	@FindBy(xpath="//button[@ng-class='btnClass3']")
	private WebElement custm;
	
	
	//step2- initialise variable 
	public loginmanagertwo(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//step3- method creation
	public void bankmanagerlogintab()
	{
		bankmanagerlogintab.click();
	}
	
	public void addcust()
	{
		addcust.click();
	}
	
	public void fname()
	{
		fname.sendKeys("Bharati");
	}
	
	public void lname()
	{
		lname.sendKeys("Kelkar");
	}
	
	public void postcode()
	{
		postcode.sendKeys("411062");
	}
	
	public void submittab()
	{
		submittab.click();
	}
	
	public void openacc()
	{
		openacc.click();
	}
	
	public void blankcustname()
	{
		blankcustname.click();
	}
	
	public void selectcust()
	{
		selectcust.click();
	}
	
	public void blankcurrency()
	{
		blankcurrency.click();
	}
	
	public void selectcurrency()
	{
		selectcurrency.click();
	}
	
	public void process()
	{
		process.click();
	}
	
	public void custm()
	{
		custm.click();
	}
	

}
