package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Driver;

public class CreateCustomerFunctionalityPage {

	
	public CreateCustomerFunctionalityPage() {
		PageFactory.initElements(Driver.getDriver(), this);
	}
	
	@FindBy (xpath = "//input[@name='email']")
		public WebElement emailField;
	
	@FindBy (xpath = "//input[@name='password']")
		public WebElement passwordField;
	
	@FindBy (xpath = "//h3[text()='Customers']")
		public WebElement cutomersPageHeaderText;
		
	@FindBy (xpath ="//ol[contains(@class, 'flex flex-wrap py-4')]")
		public WebElement menuNavPath;  
	
	@FindBy (xpath = "//button[text()= 'Filter ']")
		public WebElement filterButton;
	
	@FindBy (xpath = "//button[text()= ' New Customer']")
		public WebElement newCutomerButton; 
	
	@FindBy (xpath = "(//div[contains(@class, 'absolute')])[3]")
		public WebElement selectAllButton; 
	
	@FindBy (xpath = "//th[text()='Name ']")
		public WebElement nameColumnText; 
	
	@FindBy (xpath = "//th[text()='Phone ']")
		public WebElement phoneColumnText; 
	
	@FindBy (xpath = "//th[text()='Phone ']")
		public WebElement amountDueColumnText; 
	
	@FindBy (xpath = "//th[text()='Phone ']")
		public WebElement addedOnColumnText; 
	
	@FindBy (xpath = "//button[contains(@id, 'headlessui-menu-button-5')]")
		public WebElement threeDotsLinkIcon; 
	
	@FindBy (xpath = "//a[text()= ' View']")
		public WebElement editButtonIcon;
	
	@FindBy (xpath = "//a[text()= ' Edit']")
		public WebElement viewButtonIcon;
	
	@FindBy (xpath = "//a[text()= ' Delete']")
		public WebElement deleteButtonIcon;
	
	@FindBy (xpath = "//p[@class='text-sm text-gray-700']")
		public WebElement paginationText; 
	
	@FindBy (xpath = "//nav[contains(@aria-label, 'Pagination')]")
		public WebElement paginationNav; 
	
	@FindBy (xpath = "//span[text()= 'Previous']")
		public WebElement leftArrow; 
	
	@FindBy (xpath = "//span[text()= 'Next']")
		public WebElement rightArrow; 
	
	@FindBy (xpath = "//a[text()= '3']")
		public WebElement pageNum3;
	
	}

