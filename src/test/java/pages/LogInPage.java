package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.BrowserUtils;
import utilities.DataReader;
import utilities.Driver;

public class LogInPage {
	public LogInPage() {
		PageFactory.initElements(Driver.getDriver(), this);
	}
	
	BrowserUtils utils = new BrowserUtils();
	
	@FindBy(name = "email")
	public WebElement emailField;
	
	@FindBy (name = "password")
	public WebElement passwordField;
	
	@FindBy(xpath = "//button[text()='Login']")
	public WebElement loginButton;
	
	@FindBy(xpath = "//*[@id=\"loginForm\"]/div[3]/div/a")
	public WebElement forgotPwLink;
	
	@FindBy(xpath = "//div[text()='Enter email ']")
	public WebElement forgotPwEmailHeader;
	
	@FindBy(xpath = "//div[text()='Send Reset Link']")
	public WebElement sendresetLinkBtn;
	
	@FindBy(xpath = "//a[text()='Back to Login?']")
	public WebElement backToLoginLink;
	
	@FindBy(xpath = "//*[@id=\"loginForm\"]/div[1]/div/div/input")
	public WebElement resetPwEmailFeild;
	
	@FindBy(xpath = "//span[text()='Incorrect Email.']")
	public WebElement invalidEmailFormatErrorMsg;
	
	@FindBy(xpath = "//span[text()='Field is required']")
	public WebElement feildIsRequiredErrorMsg;
	
	@FindBy(id = "identifierId")
	public WebElement gmailEmailField;
	
	
	
	
	
	public void login() {
		utils.actionsSendKeys(emailField, DataReader.getProperty("username"));
		utils.actionsSendKeys(passwordField, DataReader.getProperty("password"));
		loginButton.click();
	}
	
}
