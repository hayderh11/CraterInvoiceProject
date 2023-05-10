package pages;

import java.util.List;

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
		public WebElement customersPageHeaderText;
		
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
	
	@FindBy (xpath = "(//button[contains(@type, 'button')])[3]")
		public WebElement threeDotsLinkIcon; 
	
	@FindBy (xpath = "//a[text()= ' View']")
		public WebElement viewButtonIcon;
	
	@FindBy (xpath = "//a[text()= ' Edit']")
		public WebElement editButtonIcon;
	
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
	
	@FindBy (xpath = "//a[text()= '4']")
		public WebElement pageNum3;
	
	@FindBy (xpath = "(//input[@name = 'name'])[1]")
		public WebElement basicInfoName; 
	
	@FindBy (xpath = "(//input[contains(@type, 'text')])[3]")
		public WebElement basicPrimaryContactName; 
	
	@FindBy (xpath = "(//input[contains(@type, 'text')])[4]")
		public WebElement basicInfoEmail; 
	
	@FindBy (xpath = "(//input[contains(@type, 'text')])[5]")
		public WebElement basicPhoneField; 
	
	@FindBy (xpath = "(//input[contains(@type, 'text')])[6]")
		public WebElement basicPrimaryCurrency; 
	
	@FindBy (xpath = "(//input[contains(@class, 'font-base block w-full')])[6]")
	public WebElement basicWebsiteField;
	
	@FindBy (xpath = "(//input[contains(@type, 'text')])[7]")
	public WebElement basicPrefixField;
	
	@FindBy (xpath = "//button[@role= 'switch']")
		public WebElement portalAccessSwitch; 
	
	@FindBy (xpath = "//input[@type= 'password']")
		public WebElement portalPassword;
	
	@FindBy (xpath = "//input[@name= 'confirm_password']")
		public WebElement portalConfirmPassword;
	
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
	
	@FindBy (xpath = "(//input[@name= 'address_name'])[2]")
		public WebElement shippingName; 
	
	@FindBy (xpath = "(//input[@type= 'text'])[15]")
		public WebElement shippingCountry; 
	
	@FindBy (xpath = "//input[@name= 'shipping.state']")
		public WebElement shippingState; 
	
	@FindBy (xpath = "//input[@name= 'shipping.city']")
		public WebElement shippingCity; 
	
	@FindBy (xpath = "//textarea[@name= 'shipping_street1']")
		public WebElement shippingAddress;
	
	@FindBy (xpath = "(//input[@name= 'phone'])[3]")
		public WebElement shippingPhone;
	
	@FindBy (xpath = "(//input[@name= 'zip'])[2]")
		public WebElement shippingZipCode;
	
	@FindBy (xpath = "//button[text()=' Save Customer']")
		public WebElement saveCustomer; 
	
	@FindBy (xpath = "//p[text()='//p[text()='Success!']")
		public WebElement successMessage; 
	
	@FindBy (xpath = "//p[text()='Customer created successfully']")
		public WebElement customerCreatedMessage; 
	
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
	
	@FindBy (xpath = "//div[contains(@class, 'inline-block min-w-full py-2')]")
		public WebElement dataTable; 
	
	@FindBy (xpath = "//span[contains(@class, 'font-medium text-primary-500 flex flex-col')]")
		public List<WebElement> customerRows; 
	
	@FindBy (xpath = "//h3[text()='Edit Customer']")
		public WebElement editCustomerHeaderText;
	
	@FindBy (xpath = "//h6[text()='Basic Info']")
		public WebElement basicInfoText; 
	
	@FindBy (xpath = "//h6[text()='Portal Access']")
		public WebElement portalAccessText;
	
	@FindBy (xpath = "//div[contains(@class, 'relative flex px-4 py-2 rounded-lg')]")
		public WebElement portalLoginUrl; 
	
	@FindBy (xpath = "//h6[text()='Billing Address']")
		public WebElement billingAddText; 
	
	@FindBy (xpath = "//h6[text()='Shipping Address']")
		public WebElement shippingAddText; 
	
	@FindBy (xpath = "//button[text()=' Update Customer']")
		public WebElement updateCustomer;
	
	@FindBy (xpath = "//div[@class= 'flex-1 w-0 ml-3 text-left']")
		public WebElement wholeFlashMessage;
	
	@FindBy (xpath = "//div[contains(@class, 'inline-block px-4 pt-5 pb-4 overflow-hidden text-left')]")
		public WebElement alertMessage;
	
	@FindBy (xpath = "//h3[text()='Are you sure?']")
		public WebElement modalTitle; 
	
	@FindBy (xpath = "//p[contains(text(),'You will not be able to recover this customer')]")
		public WebElement modalMessage; 
	
	@FindBy (xpath = "//button[text()='Ok']")
		public WebElement modalOkButton; 
	
	@FindBy (xpath = "//button[text()='Cancel']")
		public WebElement modalCancelButton; 
	
	
	
	
	
	
	
	
	}

