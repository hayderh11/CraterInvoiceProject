package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Driver;

public class CraterCommonPage {
	public CraterCommonPage() {
		PageFactory.initElements(Driver.getDriver(), this);

	}

	@FindBy(xpath = "//a[text()=' Items']")
	public WebElement itemsLink;
	
	@FindBy(xpath = "//a[text()=' Customers']")
	public WebElement customersLink;

	@FindBy(xpath = "//a[text()=' Estimates']")
	public WebElement estimatesLink;
	
	@FindBy(xpath = "//a[text()=' Invoices']")
	public WebElement invoicesLink;
	
	@FindBy(xpath = "//a[text()=' Recurring Invoices']")
	public WebElement recurringInvoicesLink;
	
	@FindBy(xpath = "//a[text()=' Payments']")
	public WebElement paymentsLink;
	
	@FindBy(xpath = "//a[text()=' Expenses']")
	public WebElement expensesLink;
	
	@FindBy(xpath = "//a[text()=' Settings']")
	public WebElement settingsLink;
	
	
}

	