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
	
	@FindBy (xpath = "//th[text()='Amount Due ']")
		public WebElement amountDueColumnText; 
	
	@FindBy (xpath = "//th[text()='Added On ']")
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
	
	@FindBy (xpath = "(//input[@name = 'name'])[1]")
		public WebElement basicInfoName; 
	
	@FindBy (xpath = "(//input[contains(@type, 'text')])[3]")
		public WebElement primaryContactName; 
	
	@FindBy (xpath = "(//input[contains(@type, 'text')])[4]")
		public WebElement basicInfoEmail; 
	
	@FindBy (xpath = "(//input[contains(@type, 'text')])[5]")
		public WebElement phoneField; 
	
	@FindBy (xpath = "(//input[contains(@type, 'text')])[6]")
		public WebElement primaryCurrency; 
	
	@FindBy (xpath = "(//input[contains(@class, 'font-base block w-full')])[6]")
	public WebElement websiteField;
	
	@FindBy (xpath = "(//input[contains(@type, 'text')])[7]")
	public WebElement prefixField;
	
	@FindBy (xpath = "//button[@role= 'switch']")
		public WebElement portalAccess; 
	
	@FindBy (xpath = "//input[@type= 'password']")
		public WebElement pAPassword; 
	
	@FindBy (xpath = "//input[@name= 'confirm_password']")
		public WebElement confirmPassword; 
	
	@FindBy (xpath = "(//input[@name= 'address_name'])[1]")
		public WebElement billingName; 
	
	@FindBy (xpath = "(//input[@type= 'text'])[9]")
		public WebElement billingCountry; 
	
	@FindBy (xpath = "//input[@name= 'billing.state']")
		public WebElement billingState; 
	
	@FindBy (xpath = "//input[@name= 'billing.city']")
		public WebElement billingCity; 	
	
	@FindBy (xpath = "//textarea[@name= 'billing_street1']")
		public WebElement billingAddress;
	
	@FindBy (xpath = "(//input[@name= 'phone'])[2]")
		public WebElement billingPhone;
	
	@FindBy (xpath = "(//input[@name= 'zip'])[1]")
		public WebElement billingZipCode;
	
	@FindBy (xpath = "//button[text()= ' Copy from Billing']")
		public WebElement copyFromBilling; 
	
	@FindBy (xpath = "//button[text()=' Save Customer']")
		public WebElement saveCustomer; 
	
	@FindBy (xpath = "//p[text()='//p[text()='Success!']")
		public WebElement successMessage; 
	
	@FindBy (xpath = "//p[text()='Customer created successfully']")
		public WebElement customerCreatedMessage; 
	
	//@FindBy (xpath = "(//*[contains(concat(' ', normalize-space(@class), ' '), ' inline-flex ')])[1]")
	@FindBy (xpath = "//*[@class='text-gray-400 focus:text-gray-500 inline-flex w-5 h-5 transition duration-150 ease-in-out focus:outline-none']")
		public WebElement xButton; 
	
	@FindBy (xpath = "//h6[text()=' Sales & Expenses']")
		public WebElement salesAndExpensesPage; 
	
	@FindBy (xpath = "//p[text()='Ronald Araujo Barcelona ']")
		public WebElement displayedName;
	
	@FindBy (xpath = "//p[text()='Ronald Araujo ']")
		public WebElement diplayedPrimaryContactName; 
	
	@FindBy (xpath = "//p[text()='ronald.ara@bracelona.com ']")
		public WebElement diplayedEmail; 
	
	@FindBy (xpath = "//p[text()='EUR (€) ']")
		public WebElement displayedCurrency; 
	
	@FindBy (xpath = "//p[text()='7038924705 ']")
		public WebElement displayedPhoneNumber; 
	
	@FindBy (xpath = "//p[text()='http://www.barcelona.com ']")
		public WebElement displayedWebsite; 
	
	
	
	
	
	
	
	
	
	
	
	
	}

