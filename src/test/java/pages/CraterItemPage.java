package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Driver;

public class CraterItemPage {

	public CraterItemPage() {
		PageFactory.initElements(Driver.getDriver(), this);
	}

	// Test Case 1, Scenario: I am able to view and see page expected elemints.

	@FindBy(xpath = "//h3[text()='Items']")
	public WebElement PageHeaderText;

	@FindBy(xpath = "//ol[contains(@class, 'flex flex-wrap py-4 text-gray-900 rounded list-reset')]")
	public WebElement ItemNavPath;

	@FindBy(xpath = "//button[text()= 'Filter ']")
	public WebElement ItemFilterButton;

	@FindBy(xpath = "//button[text()= ' Add Item']")
	public WebElement AddItem;

	@FindBy(xpath = "//input[contains(@variant, 'primary')]")
	public WebElement CheckAllButton;

	@FindBy(xpath = "(//th[contains(@class, 'whitespace-nowrap px-6 py-3 text-left text-xs')])[2]")
	public WebElement NameText;

	@FindBy(xpath = "(//th[contains(@class, 'whitespace-nowrap px-6 py-3 text-left text-xs')])[3]")
	public WebElement UnitText;

	@FindBy(xpath = "(//th[contains(@class, 'whitespace-nowrap px-6 py-3 text-left text-xs')])[4]")
	public WebElement PriceText;

	@FindBy(xpath = "(//th[contains(@class, 'whitespace-nowrap px-6 py-3 text-left text-xs')])[5]")
	public WebElement ADDEDonText;

	@FindBy(xpath = "(//div[contains(@class, 'relative inline-block h-full text-left')])[3]")
	public WebElement threeDotsIcon;

	@FindBy(xpath = "(//a[contains(@class, 'text-gray-700 group flex items-center ')])[1]")
	public WebElement EditOption;

	@FindBy(xpath = "(//a[contains(@class, 'text-gray-700 group flex items-center ')])[2]")
	public WebElement DeleteOption;

	@FindBy(xpath = "//p[contains(@class, 'text-sm text-gray-700')]")
	public WebElement ShowingPaginationText;

	@FindBy(xpath = "(//a[contains(@aria-current, 'page')])[3]")
	public WebElement pageNum3;
	
	// Test Case 2, Scenario: I am able to verify Item page
	
	
	@FindBy(xpath = "//h3[contains(@class, 'text-2xl font-bold text-left text-black')]")
	public WebElement NewItemPage;
	
	@FindBy(xpath = "(//input[@type='text'])[2]")
	public WebElement ItemName;
	
	// this path for error message after fixing the bug
	//@FindBy(xpath = "Path")
	// public WebElement ErrorMessage;
	
	@FindBy(xpath = "//input[contains(@type, 'tel')]")
	public WebElement ItemPrice;
	
	@FindBy(xpath = "(//input[contains(@type, 'text')])[3]")
	public WebElement addItemUnit;
	
	@FindBy(xpath = "//textarea[contains(@name, 'description')]")
	public WebElement ItemDescription;
	// this path for error message after fixing the bug
		//@FindBy(xpath = "Path")
		// public WebElement DescriptionErrorMessage;
	
// Test Case 3, Scenario: I am able to add Item page
	
	@FindBy (xpath = "//span[text()='pc']")
	public WebElement addItem_pc_unit;
	

	@FindBy (xpath = "//button[text()=' Save Item']")
	public WebElement saveItemButton;
	
	
	@FindBy (xpath = "//div[@name='name']")
	public WebElement filterNameBox;
	
	@FindBy (xpath = "//p[text()='Success!']")
	public WebElement  flashMessage;
	
	@FindBy (xpath = "//path[contains(@fill-rule, 'evenodd']")
	public WebElement  flashMessageXXX;
	
	//Test Case 4, Scenario: I am able to filter Item page
	
	@FindBy (xpath = "//button[text()='Filter ']")
	public WebElement FilterButton;
	
	@FindBy (xpath = "//div[text()='Name ']")
	public WebElement ItemNameInTable;
	
	@FindBy (xpath = "//div[text()='Unit ']")
	public WebElement ItemUnitNmaeInTable;
	
	@FindBy (xpath = "//div[text()='Price ']")
	public WebElement PriceNameInTable;
	
	@FindBy (xpath = "//label[text()='Clear All']")
	public WebElement ClearALLInTable;
	
	
	@FindBy (xpath = "(//input[contains(@class, 'font-base block w-full sm:text-sm border-gray-200 rounded-md text-black focus:ring-primary-400 focus:border-primary-400')])[1]")
	public WebElement NameSearchInTable;
	
	@FindBy (xpath = "//a[text()='mercedes benz842']")
	public WebElement ItemNameInSEARCH;
	
	@FindBy (xpath = "//div[@class='p-0 relative mx-auto w-full flex items-center justify-end box-border cursor-pointer border border-gray-200 rounded-md bg-white text-sm leading-snug outline-none max-h-10 w-full']")
	public WebElement ItemUnitInSEARCH;
	
	@FindBy (xpath = "(//td[contains(@class, 'px-6 py-4 text-sm text-gray-500 whitespace-nowrap')])[3]")
	public WebElement ResultUnitInSEARCH;
	
	@FindBy (className = "(//div[contains(@class, 'flex flex-col mt-1')])[3]")
	public WebElement ItemPriceInSEARCH;
	
	@FindBy (xpath = "//span[contains(@class, 'block mt-1')]")
	public WebElement NoResultsFound;
	
	@FindBy (xpath = "//table[contains(@class, 'min-w-full divide-y divide-gray-200')]")
	public WebElement current_list_of_items;
	
	@FindBy (xpath = "//th[contains(@class, 'whitespace-nowrap px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider cursor-pointer text-bold text-black')]")
	public WebElement PriceToClose;
	
}

//text-sm leading-5 font-medium text-gray-900