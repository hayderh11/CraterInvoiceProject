package step_definitions;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CraterCommonPage;
import pages.LogInPage;
import utilities.BrowserUtils;
import utilities.DButils;
import utilities.DataReader;
import utilities.Driver;

public class ForgotPasswordManagementSteps {
	LogInPage login = new LogInPage();
	CraterCommonPage common = new CraterCommonPage();
	BrowserUtils utils = new BrowserUtils();
	DButils dbutil = new DButils();
	Actions actions = new Actions(Driver.getDriver());

	// Validate Forgot Password Link
	@Given("I am on the Crater Invoice Application")
	public void i_am_on_the_crater_invoice_application() throws InterruptedException {
		Driver.getDriver().get(DataReader.getProperty("appUrl"));
		Thread.sleep(2000);
		Assert.assertTrue(login.loginButton.isDisplayed());
		System.out.println("The Login Button is Displayed");
	}

	@When("I click on the forgot password link")
	public void i_click_on_the_forgot_password_link() {
		utils.waitUntilElementVisible(login.forgotPwLink);
		login.forgotPwLink.click();
	}

	@Then("I should see the {string} textbox")
	public void i_should_see_the_textbox(String emailTextbox) {
		utils.waitUntilElementVisible(login.forgotPwEmailHeader);
		Assert.assertTrue(login.forgotPwEmailHeader.isDisplayed());
	}

	@Then("I should see the {string} button")
	public void i_should_see_the_button(String sendresetLink) {
		utils.waitUntilElementVisible(login.sendresetLinkBtn);
		Assert.assertTrue(login.sendresetLinkBtn.isDisplayed());
	}

	@Then("I should see the {string} link")
	public void i_should_see_the_link(String backToLoginLink) {
		utils.waitUntilElementVisible(login.backToLoginLink);
		Assert.assertTrue(login.backToLoginLink.isDisplayed());
	}

	public void quitDriver() throws InterruptedException {
		Thread.sleep(2000);
		Driver.quitDriver();
	}

	// Validating the error messages

	@When("I enter an invalid email {string}")
	public void i_enter_an_invalid_email(String invalidEmail) throws InterruptedException {
		utils.waitUntilElementVisible(login.resetPwEmailFeild);
		utils.actionsSendKeys(login.resetPwEmailFeild, invalidEmail);
		utils.waitUntilElementVisible(login.invalidEmailFormatErrorMsg);
		Assert.assertTrue(login.invalidEmailFormatErrorMsg.isDisplayed());
	}

	@When("I leave the {string} textbox empty")
	public void i_leave_the_textbox_empty(String resetPasswordField) throws InterruptedException {
		login.resetPwEmailFeild.clear();
		Thread.sleep(2000);
		login.resetPwEmailFeild.click();
		Thread.sleep(2000);
		utils.actionsSendKeys(login.resetPwEmailFeild, " ");
		Assert.assertTrue(login.feildIsRequiredErrorMsg.isDisplayed());
	}

	@Then("I enter a valid email {string}")
	public void i_enter_a_valid_email(String validEmail) throws InterruptedException {
		Thread.sleep(2000);
		utils.actionsSendKeys(login.resetPwEmailFeild, validEmail);
	}

	@Then("I click on the'Send Reset Link'")
	public void i_click_on_the_send_reset_link() {
		utils.waitUntilElementToBeClickable(login.sendresetLinkBtn);
		login.sendresetLinkBtn.click();

	}

	@Then("I click on the {string} link")
	public void i_click_on_the_link(String backToLogin) throws InterruptedException {
		Thread.sleep(1000);
		utils.waitUntilElementToBeClickable(login.backToLoginLink);
		login.backToLoginLink.click();
		Thread.sleep(2000);
		Assert.assertTrue(login.loginButton.isDisplayed());
		Thread.sleep(1000);
		Driver.getDriver().get(DataReader.getProperty("gmail"));
		login.gmailEmailField.sendKeys(DataReader.getProperty("email"));
	}

}
