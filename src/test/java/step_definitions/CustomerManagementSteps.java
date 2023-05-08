package step_definitions;




import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
import io.cucumber.java.en.And;
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
	
	String customerName = "Ronald Araujo Barcelona";
	
//------------------------------------------
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
		customerLogin.basicInfoName.sendKeys(customerName);
		
		customerLogin.basicPrimaryContactName.sendKeys("Ronald Araujo");
		
		customerLogin.emailField.sendKeys("rronald.ara@bracelona.com");
		
		customerLogin.basicPhoneField.sendKeys("7038924705");
		
		customerLogin.basicPrimaryCurrency.sendKeys("EUR - Euro");
		utils.waitUntilElementToBeClickable(customerLogin.basicPrimaryCurrency);
		customerLogin.basicPrimaryCurrency.sendKeys(Keys.ENTER);
		
		Thread.sleep(1000);
		customerLogin.basicWebsiteField.sendKeys("http://www.barcelona.com");
		
		customerLogin.basicPrefixField.sendKeys("RAB");
		Thread.sleep(1000);
		
	}
	@When("I enter the following details for Portal Access:")
	public void i_enter_the_following_details_for_portal_access(DataTable dataTable) throws InterruptedException {
	    
		customerLogin.portalAccessSwitch.click();
		
		utils.waitUntilElementVisible(customerLogin.portalPassword);
		customerLogin.portalPassword.sendKeys("RonaldAraujo");
		
		customerLogin.portalConfirmPassword.sendKeys("RonaldAraujo");
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
			 System.out.println("Flash Message is: " + actualMessage2);
			 
			
			 
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
	public void i_click_on_the_button_to_close_the_flash_message(String xButton) throws InterruptedException {
		
		
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
		String query = "SELECT name, email, phone, id FROM cutomers where name='"+customerName+"';";
		System.out.println(query);
		List<String> customerInfo = dbutil.selectArecord(query);
		for (String string : customerInfo) {
			System.out.println(string);
		}
		
	}
	//----------------------------------------------------------
		//Verify Population of Add Customer table.
	
	@Then("I should see the table data populated")
	public void i_should_see_the_table_data_populated() {

		
		WebElement table = Driver.getDriver().findElement(By.xpath("//div[@class= 'relative table-container']"));
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		if (rows.size() > 0) {
		    System.out.println("PASS! Table is populated with data.");
		} else {
		    System.out.println("FAIL! Table is empty.");
		}
	}
	@Then("I should be able to Select Check box populated for each customer row.")
	public void i_should_be_able_to_select_check_box_populated_for_each_customer_row() throws InterruptedException {
	    
		Thread.sleep(1000);
		
		 WebElement table = Driver.getDriver().findElement(By.xpath("//div[@class= 'relative table-container']"));
		    List<WebElement> rows = table.findElements(By.tagName("tr")); 
		 
		    for (WebElement row : rows) { 
		        WebElement checkbox = row.findElement(By.xpath("(//input[contains(@type, 'checkbox')])[1]")); 
		        if (!checkbox.isSelected()) { 
		            checkbox.click(); 
		            System.out.println("PASS! I am able to Select the Check Boxes");
		        }
		        
		    }
	}
	@Then("I should be able to see Name column populated with the customer’s display name for each row.")
	public void i_should_be_able_to_see_name_column_populated_with_the_customer_s_display_name_for_each_row() {
	    
		WebElement table = Driver.getDriver().findElement(By.xpath("//div[@class= 'relative table-container']")); 
	    List<WebElement> rows = table.findElements(By.tagName("tr")); 
	    for (WebElement row : rows) { 
	        List<WebElement> columns = row.findElements(By.tagName("td")); 
	        
	        if (!columns.isEmpty()) { 
	            String name = columns.get(1).getText(); 
	            Assert.assertNotNull(name);
	            System.out.println("PASS! I am able to see Name Column Populated With Customer's Display Name");
	        }
	    }
		
	}
	@Then("I should be able to see Phone column populated with the customer’s phone number for each row.")
	public void i_should_be_able_to_see_phone_column_populated_with_the_customer_s_phone_number_for_each_row() {
	    
		WebElement table = Driver.getDriver().findElement(By.xpath("//div[@class='relative table-container']")); 
	    List<WebElement> rows = table.findElements(By.tagName("tr")); 

	    for (WebElement row : rows) { 
	        List<WebElement> columns = row.findElements(By.tagName("td")); 

	        if (!columns.isEmpty()) { 
	            String phone = columns.get(2).getText(); 
	            System.out.println("Phone number: " + phone);
	        }else {
	        	System.out.println("FAIL! Phone Columns are Empty.");
	        }
	    }
		
	}
	@Then("I should be able to see Amount Due column populated with the current amount the customer owes.")
	public void i_should_be_able_to_see_amount_due_column_populated_with_the_current_amount_the_customer_owes() {
	    
		WebElement table = Driver.getDriver().findElement(By.xpath("//div[@class='relative table-container']"));
		List<WebElement> rows = table.findElements(By.tagName("tr")); 

		for (WebElement row : rows) { 
		    List<WebElement> columns = row.findElements(By.tagName("td")); 
		    boolean allAmountsDueDisplayed = true;
		   
		    if (!columns.isEmpty()) {
		        String amountDue = columns.get(3).getText();
		        if (amountDue != null && !amountDue.isEmpty()) {
		            System.out.println("PASS! Amount Due is displayed: " + amountDue);
		        } else {
		            allAmountsDueDisplayed = false;
		            System.out.println("FAIL! Amount Due is not displayed for this customer.");
		        }
		        	
		    }
		}
		}	
	
	@Then("I should be able to see Added On column populated with the date that the customer was added on in the following format: <day> <Month> <Year>.")
	public void i_should_be_able_to_see_added_on_column_populated_with_the_date_that_the_customer_was_added_on_in_the_following_format_day_month_year() {
	    
		WebElement table = Driver.getDriver().findElement(By.xpath("//div[@class='relative table-container']"));
	    List<WebElement> rows = table.findElements(By.tagName("tr"));

	    SimpleDateFormat formatter = new SimpleDateFormat("dd MMMM yyyy");

	    for (WebElement row : rows) {
	        List<WebElement> columns = row.findElements(By.tagName("td"));

	        if (!columns.isEmpty()) {
	            String addedOn = columns.get(4).getText();
	            try {
	                Date date = formatter.parse(addedOn);
	                Assert.assertNotNull(date);
	                System.out.println("PASS! I am Able to See the Added On Date in the Correct Format for Each Customer.");
	            } catch (ParseException e) {
	                System.out.println("FAIL! The Added On Date is Not in the Correct Format.");
	            }
	        }
	    }
	}
	
	@Then("I should be able to see More link represented by three dots for each row in the table.")
	public void i_should_be_able_to_see_more_link_represented_by_three_dots_for_each_row_in_the_table() {
	    
		WebElement table = Driver.getDriver().findElement(By.xpath("//div[@class='relative table-container']"));
	    List<WebElement> rows = table.findElements(By.tagName("tr"));
	    
	    for (WebElement row : rows) {
	        WebElement moreLink = row.findElement(By.xpath("(//div[contains(@class, 'relative inline-block h-full text-left')])[4]"));
	        Assert.assertTrue(moreLink.isDisplayed());
	        System.out.println("PASS! I am able to see More link represented by three dots for each row in the table.");
	    }
	    	
	    }
	//-----------------------------------------------------
		//Verify Edit Customer
	
	@When("I click on the more icon represented by three dots for the customer {string}")
	public void i_click_on_the_more_icon_represented_by_three_dots_for_the_customer(String RonaldAraujoBarcelona) {
		
		utils.waitUntilElementToBeClickable(customerLogin.threeDotsLinkIcon);
	    utils.actionsClick(customerLogin.threeDotsLinkIcon);
		
	}
	@When("I choose to click on the button {string}")
	public void i_choose_to_click_on_the_button(String RonaldAraujoBarcelona) throws InterruptedException {
		
	    utils.waitUntilElementToBeClickable(customerLogin.editButtonIcon);
	    Thread.sleep(1000);
	    customerLogin.editButtonIcon.click();
	    
	}
	@Then("I should be directed to the Edit Customer page")
	public void i_should_be_directed_to_the_edit_customer_page() {
	    
		utils.waitUntilElementVisible(customerLogin.editCustomerHeaderText);
		Assert.assertTrue(customerLogin.editCustomerHeaderText.isDisplayed());
		
	}
	@Then("I should see all the customer fields mentioned in AC {int}, {double}, {double}, {double}")
	public void i_should_see_all_the_customer_fields_mentioned_in_ac(Integer AC2, Double AC2_1, Double AC2_3, Double AC2_4) {
	    
		utils.waitUntilElementVisible(customerLogin.basicInfoText);
		Assert.assertTrue(customerLogin.basicInfoText.isDisplayed());
		Assert.assertTrue(customerLogin.basicInfoName.isDisplayed());
		Assert.assertTrue(customerLogin.basicPrimaryContactName.isDisplayed());
		Assert.assertTrue(customerLogin.basicInfoEmail.isDisplayed());
		Assert.assertTrue(customerLogin.basicPhoneField.isDisplayed());
		Assert.assertTrue(customerLogin.basicPrimaryCurrency.isDisplayed());
		Assert.assertTrue(customerLogin.basicWebsiteField.isDisplayed());
		Assert.assertTrue(customerLogin.basicPrefixField.isDisplayed());
		
		utils.waitUntilElementVisible(customerLogin.portalAccessText);
		Assert.assertTrue(customerLogin.portalAccessText.isDisplayed());
		Assert.assertTrue(customerLogin.portalAccessSwitch.isDisplayed());
		utils.waitUntilElementVisible(customerLogin.portalLoginUrl);
		Assert.assertTrue(customerLogin.portalLoginUrl.isDisplayed());
		Assert.assertTrue(customerLogin.portalPassword.isDisplayed());
		Assert.assertTrue(customerLogin.portalConfirmPassword.isDisplayed());
		
		utils.waitUntilElementVisible(customerLogin.billingAddText);
		Assert.assertTrue(customerLogin.billingAddText.isDisplayed());
		Assert.assertTrue(customerLogin.billingName.isDisplayed());
		Assert.assertTrue(customerLogin.billingCountry.isDisplayed());
		Assert.assertTrue(customerLogin.billingState.isDisplayed());
		Assert.assertTrue(customerLogin.billingCity.isDisplayed());
		Assert.assertTrue(customerLogin.billingAddress.isDisplayed());
		Assert.assertTrue(customerLogin.billingPhone.isDisplayed());
		Assert.assertTrue(customerLogin.billingZipCode.isDisplayed());
		
		utils.waitUntilElementVisible(customerLogin.shippingAddText);
		Assert.assertTrue(customerLogin.shippingAddText.isDisplayed());
		Assert.assertTrue(customerLogin.shippingName.isDisplayed());
		Assert.assertTrue(customerLogin.shippingCountry.isDisplayed());
		Assert.assertTrue(customerLogin.shippingState.isDisplayed());
		Assert.assertTrue(customerLogin.shippingCity.isDisplayed());
		Assert.assertTrue(customerLogin.shippingAddress.isDisplayed());
		Assert.assertTrue(customerLogin.shippingPhone.isDisplayed());
		Assert.assertTrue(customerLogin.shippingZipCode.isDisplayed());
		
	}
	@When("I edit the customer fields mentioned in AC {int}, {double}, {double}, {double}")
	public void i_edit_the_customer_fields_mentioned_in_ac(Integer AC2, Double AC2_1, Double AC2_3, Double AC2_4) {
	    
		customerLogin.basicInfoName.clear();
		customerLogin.basicInfoName.sendKeys("Edit Customer");
		customerLogin.basicPrimaryContactName.clear();
		customerLogin.basicPrimaryContactName.sendKeys("Edit Name");
		customerLogin.basicInfoEmail.clear();
		customerLogin.basicInfoEmail.sendKeys("editemail@primetech.com");
		customerLogin.basicPhoneField.clear();
		customerLogin.basicPhoneField.sendKeys("703-908-7642");
		customerLogin.basicPrimaryCurrency.clear();
		customerLogin.basicPrimaryCurrency.sendKeys("IQD - Iraqi Dinar", Keys.ENTER);
		customerLogin.basicWebsiteField.clear();
		customerLogin.basicWebsiteField.sendKeys("http://www.editwebsite.com");
		customerLogin.basicPrefixField.clear();
		customerLogin.basicPrefixField.sendKeys("SDET");
		
		customerLogin.portalPassword.clear();
		customerLogin.portalPassword.sendKeys("Editpassword123");
		customerLogin.portalConfirmPassword.clear();
		customerLogin.portalConfirmPassword.sendKeys("Editpassword123");

		customerLogin.billingName.clear();
		customerLogin.billingName.sendKeys("Edit Customer");
		customerLogin.billingCountry.clear();
		customerLogin.billingCountry.sendKeys("Iraq", Keys.ENTER);
		customerLogin.billingState.clear();
		customerLogin.billingState.sendKeys("Babylon");
		customerLogin.billingCity.clear();
		customerLogin.billingCity.sendKeys("Hilla");
		customerLogin.billingAddress.clear();
		customerLogin.billingAddress.sendKeys("780 Babylon St");
		customerLogin.billingPhone.clear();
		customerLogin.billingPhone.sendKeys("703-908-7642");
		customerLogin.billingZipCode.clear();
		customerLogin.billingZipCode.sendKeys("25708");
		
		customerLogin.copyFromBilling.click();
		
	}
	
	@And("I need to click on the {string} button")
	public void i_need_to_click_on_the_button(String updateCustomer) throws InterruptedException {
	    
		utils.waitUntilElementVisible(customerLogin.updateCustomer);
		Thread.sleep(500);
		utils.actionsClick(customerLogin.updateCustomer);
		
	}
	@Then("I should be able see a flash message {string} with a close button to the right")
	public void i_should_be_able_see_a_flash_message_with_a_close_button_to_the_right(String string) {
	    
		WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 5);
		 
		 WebElement successfulMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='Success!']")));
			 Assert.assertTrue(successfulMessage.isDisplayed());
			 String actualMessage = successfulMessage.getText();
			 System.out.println("Flash Message is: " + actualMessage);
			    
		 WebElement customerUpdatedMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='Customer updated successfully']")));
			 Assert.assertTrue(customerUpdatedMessage.isDisplayed());
			 String actualMessage2 = customerUpdatedMessage.getText();
			 System.out.println("Flash Message is: " + actualMessage2);
		
	}
	@Then("the flash box should disappear within {int} seconds or less")
	public void the_flash_box_should_disappear_within_seconds_or_less(Integer seconds) throws InterruptedException {
		
		WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 5);
		By flashMessageLocator = By.xpath("//p[text()='Customer updated successfully']");
			
		boolean isMessageDisplayed = true;
		try {
		    wait.until(ExpectedConditions.invisibilityOfElementLocated(flashMessageLocator));
		} catch (TimeoutException e) {
		    isMessageDisplayed = false;
		}

		Assert.assertFalse("Flash message is still displayed after " + seconds + " seconds.", !isMessageDisplayed);
	
		Thread.sleep(1000);
		
	}
	@Then("I should be able to close the flash message by clicking on the {string} button in the flash message")
	public void i_should_be_able_to_close_the_flash_message_by_clicking_on_the_button_in_the_flash_message(String xButton) {
	    
//		utils.waitUntilElementToBeClickable(customerLogin.xButton);
//		utils.actionsClick(customerLogin.xButton);
		
	}
	@Then("I should be directed to the sales and expenses page of the customer that was updated")
	public void i_should_be_directed_to_the_sales_and_expenses_page_of_the_customer_that_was_updated() {
	   
		utils.waitUntilElementVisible(customerLogin.salesAndExpensesPage);
		Assert.assertTrue(customerLogin.salesAndExpensesPage.isDisplayed());
		
	}
	@Then("the application database should be updated with the edits made by me")
	public void the_application_database_should_be_updated_with_the_edits_made_by_me() {
	    
		String customerName = "Edit Customer";
		String query = "SELECT name, email, phone, id FROM cutomers where name='"+customerName+"';";
		System.out.println(query);
		List<String> customerInfo = dbutil.selectArecord(query);
		for (String string : customerInfo) {
			System.out.println(string);
		}
	}
	
}
	
