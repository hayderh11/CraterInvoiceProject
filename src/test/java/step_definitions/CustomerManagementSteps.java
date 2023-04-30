package step_definitions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

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
	
	@Given("I am logged into the Crater application")
	public void i_am_logged_into_the_crater_application() {
		
		Driver.getDriver().get(DataReader.getProperty("appUrl"));
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
}
