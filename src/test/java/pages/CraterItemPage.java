package pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Driver;

public class CraterItemPage {
	
	public CraterItemPage() {
		PageFactory.initElements(Driver.getDriver(), this);
	}
	
	
	
	
	@FindBy (xpath = "//h3[text()='Items']")
	public WebElement PageHeaderText;

	
	@FindBy (xpath ="//ol[contains(@class, 'flex flex-wrap py-4 text-gray-900 rounded list-reset')]")
		public WebElement ItemNavPath;  
	
	@FindBy (xpath = "//button[text()= 'Filter ']")
	public WebElement ItemFilterButton;
	
	@FindBy (xpath = "//button[text()= ' Add Item']")
	public WebElement AddItemButton; 
	
	@FindBy (xpath = "//input[contains(@variant, 'primary')]")
	public WebElement CheckAllButton; 
	
	@FindBy (xpath = "(//th[contains(@class, 'whitespace-nowrap px-6 py-3 text-left text-xs')])[2]")
	public WebElement NameText; 
	
	
	@FindBy (xpath = "(//th[contains(@class, 'whitespace-nowrap px-6 py-3 text-left text-xs')])[3]")
	public WebElement UnitText; 
	
	@FindBy (xpath = "(//th[contains(@class, 'whitespace-nowrap px-6 py-3 text-left text-xs')])[4]")
	public WebElement PriceText; 
	
	@FindBy (xpath = "(//th[contains(@class, 'whitespace-nowrap px-6 py-3 text-left text-xs')])[5]")
	public WebElement ADDEDonText;
	
	@FindBy (xpath = "(//div[contains(@class, 'relative inline-block h-full text-left')])[3]")
	public WebElement threeDotsIcon;
	
	@FindBy (xpath = "(//a[contains(@class, 'text-gray-700 group flex items-center ')])[1]")
	public WebElement EditOption;
	
	@FindBy (xpath = "(//a[contains(@class, 'text-gray-700 group flex items-center ')])[2]")
	public WebElement DeleteOption;
	
	@FindBy (xpath = "//p[contains(@class, 'text-sm text-gray-700')]")
	public WebElement ShowingPaginationText;
	
	@FindBy (xpath = "(//a[contains(@aria-current, 'page')])[3]")
	public WebElement pageNum3;
	
}
