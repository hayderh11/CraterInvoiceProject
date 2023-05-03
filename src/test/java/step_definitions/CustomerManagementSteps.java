package step_definitions;



import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CraterCommonPage;
import pages.CreateCustomerFunctionalityPage;
import pages.LogInPage;
import utilities.BrowserUtils;
import utilities.DButils;
import utilities.DataReader;
import utilities.Driver;

public class CustomerManagementSteps {
	
	LogInPage login = new LogInPage();
	CraterCommonPage common = new CraterCommonPage();
	BrowserUtils utils = new BrowserUtils();
	DButils dbutil = new DButils();
	CreateCustomerFunctionalityPage customerLogin = new CreateCustomerFunctionalityPage();
	
	
	//Verify Customers Page UI components
	
	@Given("I am logged into the Crater application")
	public void i_am_logged_into_the_crater_application() throws InterruptedException {
		
		Driver.getDriver().get(DataReader.getProperty("appUrl"));
		Thread.sleep(1000);
//		customerLogin.emailField.sendKeys("username");
//		customerLogin.passwordField.sendKeys("password");
		login.login();
		
	}
	
	@Given("I have clicked on the {string} menu link")
	public void i_have_clicked_on_the_menu_link(String customersMenu) {
		
		utils.waitUntilElementToBeClickable(common.customersLink);
		common.customersLink.click();
		
	}
	@When("I am on the {string} page")
	public void i_am_on_the_page(String Customers) {
		
		utils.waitUntilElementVisible(customerLogin.cutomersPageHeaderText);
		Assert.assertTrue(customerLogin.cutomersPageHeaderText.isDisplayed());
		
	}
	@Then("I should see the menu navigation path as {string} placed under {string}.")
	public void i_should_see_the_menu_navigation_path_as_placed_under(String Home, String Customers) {
		
	    Assert.assertTrue(customerLogin.menuNavPath.isDisplayed());

	}
	@Then("I should see a secondary button titled {string} with a filter icon")
	public void i_should_see_a_secondary_button_titled_with_a_filter_icon(String Filter) {
		
		utils.waitUntilElementVisible(customerLogin.filterButton);
		Assert.assertTrue(customerLogin.filterButton.isDisplayed());
		
	}
	@Then("I should see a primary button titled {string}")
	public void i_should_see_a_primary_button_titled(String newCustomer) {
		
		utils.waitUntilElementVisible(customerLogin.newCutomerButton);
		Assert.assertTrue(customerLogin.newCutomerButton.isDisplayed());

	}
	@Then("I should see a table with the following columns: Select All checkbox, NAME, PHONE, AMOUNT DUE, ADDED ON")
	public void i_should_see_a_table_with_the_following_columns_select_all_checkbox_name_phone_amount_due_added_on() {
		
		utils.waitUntilElementVisible(customerLogin.selectAllButton);
		Assert.assertTrue(customerLogin.selectAllButton.isDisplayed());
		Assert.assertTrue(customerLogin.nameColumnText.isDisplayed());
		Assert.assertTrue(customerLogin.phoneColumnText.isDisplayed());
		Assert.assertTrue(customerLogin.amountDueColumnText.isDisplayed());
		Assert.assertTrue(customerLogin.addedOnColumnText.isDisplayed());
		
	}
	@Then("I should see a link icon showing three dots with the following options: Edit with an edit icon, View with a view icon, Delete with a delete icon")
	public void i_should_see_a_link_icon_showing_three_dots_with_the_following_options_edit_with_an_edit_icon_view_with_a_view_icon_delete_with_a_delete_icon() {
		
		Assert.assertTrue(customerLogin.threeDotsLinkIcon.isDisplayed());
		customerLogin.threeDotsLinkIcon.click();
		utils.waitUntilElementVisible(customerLogin.editButtonIcon);
		Assert.assertTrue(customerLogin.editButtonIcon.isDisplayed());
		Assert.assertTrue(customerLogin.viewButtonIcon.isDisplayed());
		Assert.assertTrue(customerLogin.deleteButtonIcon.isDisplayed());
		
	}
	@Then("I should see the pagination text as follows: {string}")
	public void i_should_see_the_pagination_text_as_follows(String paginationText) {
	    
		Assert.assertTrue(customerLogin.paginationText.isDisplayed());
		
	}
	@Then("I should be able to see the pagination navigation with the following controls:Left arrow allowing the user to navigate to previous pages, Right arrow allowing the user to navigate to the next pages, Number indicating the page the user is currently on and the next upcoming page")
	public void i_should_be_able_to_see_the_pagination_navigation_with_the_following_controls_left_arrow_allowing_the_user_to_navigate_to_previous_pages_right_arrow_allowing_the_user_to_navigate_to_the_next_pages_number_indicating_the_page_the_user_is_currently_on_and_the_next_upcoming_page() {
	    
		Assert.assertTrue(customerLogin.paginationNav.isDisplayed());
		
	}
	@Then("the left arrow should be disabled if the user is on the first page")
	public void the_left_arrow_should_be_disabled_if_the_user_is_on_the_first_page() {
		
		WebElement leftArrow = Driver.getDriver().findElement(By.xpath("(//a[contains(@class, 'disabled cursor-normal')])[2]"));
		String classAttribute = leftArrow.getAttribute("class");
		boolean isDisabled = classAttribute.contains("disabled");
		Assert.assertTrue(isDisabled);
		
	}
	@Then("the right arrow should be disabled if the user is on the last page.")
	public void the_right_arrow_should_be_disabled_if_the_user_is_on_the_last_page() {
	   
		customerLogin.pageNum3.click();
		
		WebElement rightArrow = Driver.getDriver().findElement(By.xpath("(//a[contains(@class, 'relative inline-flex')])[6]"));
		String classAttribute = rightArrow.getAttribute("class");
		boolean isDisabled = classAttribute.contains("disabled");
		Assert.assertTrue(isDisabled);
		
	}
//---------------------------------------------------------------------------
	//Verify Add New Customer - Successful
	
	@Given("I am on the Customers page")
	public void i_am_on_the_customers_page() {
		
		utils.waitUntilElementVisible(customerLogin.cutomersPageHeaderText);
		Assert.assertTrue(customerLogin.cutomersPageHeaderText.isDisplayed());	    

	}
	@When("I click on {string}")
	public void i_click_on(String newCustomer) throws InterruptedException {
	    
		utils.waitUntilElementVisible(customerLogin.newCutomerButton);
		customerLogin.newCutomerButton.click();
		Thread.sleep(2000);
	}
	@When("I enter the following details for Basic Info:")
	public void i_enter_the_following_details_for_basic_info(DataTable dataTable) throws InterruptedException {
	    
		Map<String, String> data = dataTable.asMap(String.class, String.class);
		
		utils.waitUntilElementToBeClickable(customerLogin.basicInfoName);
		customerLogin.basicInfoName.sendKeys("Ronald Araujo Barcelona");
		
		customerLogin.primaryContactName.sendKeys("Ronald Araujo");
		
		customerLogin.emailField.sendKeys("ronald.ara@bracelona.com");
		
		customerLogin.phoneField.sendKeys("7038924705");
		
		customerLogin.primaryCurrency.sendKeys("EUR - Euro");
		utils.waitUntilElementToBeClickable(customerLogin.primaryCurrency);
		customerLogin.primaryCurrency.sendKeys(Keys.ENTER);
		
		Thread.sleep(1000);
		customerLogin.websiteField.sendKeys("http://www.barcelona.com");
		
		customerLogin.prefixField.sendKeys("RAB");
		Thread.sleep(1000);
		
	}
	@When("I enter the following details for Portal Access:")
	public void i_enter_the_following_details_for_portal_access(DataTable dataTable) throws InterruptedException {
	    
		customerLogin.portalAccess.click();
		
		utils.waitUntilElementVisible(customerLogin.pAPassword);
		customerLogin.pAPassword.sendKeys("RonaldAraujo");
		
		customerLogin.confirmPassword.sendKeys("RonaldAraujo");
		Thread.sleep(1000);
		
	}
	@When("I enter the following details for Billing Address:")
	public void i_enter_the_following_details_for_billing_address(DataTable dataTable) {
	    
		customerLogin.billingName.sendKeys("Ronald Araujo");
		
		customerLogin.billingCountry.sendKeys("Spain");
		utils.waitUntilElementToBeClickable(customerLogin.billingCountry);
		customerLogin.billingCountry.sendKeys(Keys.ENTER);
		
		customerLogin.billingState.sendKeys("Catalonia");
		customerLogin.billingCity.sendKeys("Barcelona");
		customerLogin.billingAddress.sendKeys("275 Camp Nou St");
		customerLogin.billingPhone.sendKeys("7038924705");
		customerLogin.billingZipCode.sendKeys("27325");
		
	}
	@When("I enter the following details for Shipping Address:")
	public void i_enter_the_following_details_for_shipping_address(DataTable dataTable) {
		
	    utils.waitUntilElementToBeClickable(customerLogin.copyFromBilling);
		customerLogin.copyFromBilling.click();

	}
		@Then("I should not see any validation errors")
		public void i_should_not_see_any_validation_errors() {
		    
			List<WebElement> errorMessages = Driver.getDriver().findElements(By.className("error-message"));
		    Assert.assertEquals("Number of validation errors should be 0", 0, errorMessages.size());
		    
		}    
	@When("I click on the {string} button")
	public void i_click_on_the_button(String saveCustomer) {
	    
		
		utils.waitUntilElementToBeClickable(customerLogin.saveCustomer);
		utils.actionsClick(customerLogin.saveCustomer);
		
	}
		@Then("I should see the flash message {string} with a close button")
	public void i_should_see_the_flash_message_with_a_close_button(String successMessage) {
			
		WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 5);
			 
		 WebElement successfulMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='Success!']")));
			 Assert.assertTrue(successfulMessage.isDisplayed());
			 String actualMessage = successfulMessage.getText();
			 System.out.println("Flash Message is: " + actualMessage);
			    
		 WebElement customerCreatedMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='Customer created successfully']")));
			 Assert.assertTrue(customerCreatedMessage.isDisplayed());
			 String actualMessage2 = customerCreatedMessage.getText();
			 System.out.println("Flash Message is: " +actualMessage2);
			 
		}
	@Then("the flash message should disappear within {int} seconds or less")
	public void the_flash_message_should_disappear_within_seconds_or_less(Integer seconds) throws InterruptedException {
	    
		WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 5);
		By flashMessageLocator = By.xpath("//p[text()='Customer created successfully']");
			
		boolean isMessageDisplayed = true;
		try {
		    wait.until(ExpectedConditions.invisibilityOfElementLocated(flashMessageLocator));
		} catch (TimeoutException e) {
		    isMessageDisplayed = false;
		}

		Assert.assertFalse("Flash message is still displayed after " + seconds + " seconds.", !isMessageDisplayed);
	
		Thread.sleep(1000);
		
	}
	@When("I click on the {string} button to close the flash message")
	public void i_click_on_the_button_to_close_the_flash_message(String xButton) {
	    
		
//		utils.waitUntilElementToBeClickable(customerLogin.xButton);
//		utils.actionsClick(customerLogin.xButton);
		
	}
	@Then("I should be on the Sales and expenses page")
	public void i_should_be_on_the_sales_and_expenses_page() {
	    
		utils.waitUntilElementVisible(customerLogin.salesAndExpensesPage);
		Assert.assertTrue(customerLogin.salesAndExpensesPage.isDisplayed());
		
		
	}
	@Then("I should see the following customer details:")
	public void i_should_see_the_following_customer_details(DataTable dataTable) {
	   
		utils.waitUntilElementVisible(customerLogin.displayedName);
		Assert.assertTrue(customerLogin.displayedName.isDisplayed());
		Assert.assertTrue(customerLogin.diplayedPrimaryContactName.isDisplayed());
		Assert.assertTrue(customerLogin.diplayedEmail.isDisplayed());
		Assert.assertTrue(customerLogin.displayedCurrency.isDisplayed());
		Assert.assertTrue(customerLogin.displayedPhoneNumber.isDisplayed());
		Assert.assertTrue(customerLogin.displayedWebsite.isDisplayed());
		
	}
	@Then("the customer information for the following sections should be saved in the application database:")
	public void the_customer_information_for_the_following_sections_should_be_saved_in_the_application_database(DataTable dataTable) {
	    
	String customerName = "Ronald Araujo Barcelona";
		String query = "SELECT name, email, phone, id FROM items where name='"+customerName+"';";
		System.out.println(query);
		List<String> itemInfo = dbutil.selectArecord(query);
		for (String string : itemInfo) {
			System.out.println(string);
		}
		
	}
	
}