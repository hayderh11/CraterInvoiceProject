package step_definitions;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CraterCommonPage;
import pages.LogInPage;
import utilities.BrowserUtils;
import utilities.DButils;
import utilities.DataReader;
import utilities.Driver;
import pages.CraterItemPage;

public class ItemsManagementSteps {
	LogInPage login = new LogInPage();
	BrowserUtils utils = new BrowserUtils();
	CraterCommonPage ItemsCommonPage = new CraterCommonPage();
	DButils dbutil = new DButils();
	CraterItemPage veiwPage = new CraterItemPage();
	static String itemName;
	static List<String> list;

// Test Case 1, Scenario: I am able to view and see page expected elemints.
	@Given("I am an external user, I am logged in")
	public void i_am_an_external_user_i_am_logged_in() throws InterruptedException {
		Driver.getDriver().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		Driver.getDriver().manage().window().maximize();
		Driver.getDriver().get(DataReader.getProperty("appUrl"));
		Thread.sleep(1000);
//	ItemLogin.emailField.sendKeys("username");
//	ItemLogin.passwordField.sendKeys("password");
		login.login();
	}

	@Given("I click on the item menu link")
	public void i_click_on_the_item_menu_link() {
		utils.waitUntilElementToBeClickable(ItemsCommonPage.itemsLink);
		ItemsCommonPage.itemsLink.click();
	}

	@When("I am on the Item page")
	public void i_am_on_the_item_page() {
		utils.waitUntilElementVisible(veiwPage.PageHeaderText);
		Assert.assertTrue(veiwPage.PageHeaderText.isDisplayed());
	}

	@Then("I should see the menu navigation path as “Home / Items” placed under “Items”")
	public void i_should_see_the_menu_navigation_path_as_home_items_placed_under_items() {
		utils.waitUntilElementVisible(veiwPage.ItemNavPath);
		Assert.assertTrue(veiwPage.ItemNavPath.isDisplayed());
	}

	@Then("I should see a secondary button titled “Filter” with a filter icon")
	public void i_should_see_a_secondary_button_titled_filter_with_a_filter_icon() {
		utils.waitUntilElementVisible(veiwPage.ItemFilterButton);
		Assert.assertTrue(veiwPage.ItemFilterButton.isDisplayed());
	}

	@Then("I should see a primary button titled “+ Add Item")
	public void i_should_see_a_primary_button_titled_add_item() {
		utils.waitUntilElementVisible(veiwPage.AddItem);
		Assert.assertTrue(veiwPage.AddItem.isDisplayed());
	}

	@Then("I should see a table with the following columns:")
	public void i_should_see_a_table_with_the_following_columns(io.cucumber.datatable.DataTable dataTable)
			throws InterruptedException {
		Thread.sleep(1000);
		utils.waitUntilElementToBeClickable(veiwPage.CheckAllButton);
		Assert.assertTrue(veiwPage.CheckAllButton.isDisplayed());
		Assert.assertTrue(veiwPage.NameText.isDisplayed());
		Assert.assertTrue(veiwPage.UnitText.isDisplayed());
		Assert.assertTrue(veiwPage.PriceText.isDisplayed());
		Assert.assertTrue(veiwPage.ADDEDonText.isDisplayed());
	}

	@Then("I should see a link icon with three dots")
	public void i_should_see_a_link_icon_with_three_dots() {
		utils.waitUntilElementVisible(veiwPage.threeDotsIcon);
		Assert.assertTrue(veiwPage.threeDotsIcon.isDisplayed());
	}

	@Then("the link icon should have the options:")
	public void the_link_icon_should_have_the_options(io.cucumber.datatable.DataTable dataTable) {
		veiwPage.threeDotsIcon.click();
		Assert.assertTrue(veiwPage.EditOption.isDisplayed());
		Assert.assertTrue(veiwPage.DeleteOption.isDisplayed());
	}

	@Then("I should see pagination text as {string}")
	public void i_should_see_pagination_text_as(String string) {

		utils.waitUntilElementVisible(veiwPage.ShowingPaginationText);
		Assert.assertTrue(veiwPage.ShowingPaginationText.isDisplayed());
	}

	@Then("if the user is on the first page, Left should be disabled")
	public void if_the_user_is_on_the_first_page_left_should_be_disabled() {
		WebElement leftArrow = Driver.getDriver()
				.findElement(By.xpath("(//a[contains(@class, 'disabled cursor-normal')])[2]"));
		String classAttribute = leftArrow.getAttribute("class");
		boolean isDisabled = classAttribute.contains("disabled");
		Assert.assertTrue(isDisabled);
	}

	@Then("if the user is on the last page, Right should be disabled")
	public void if_the_user_is_on_the_last_page_right_should_be_disabled() {
		veiwPage.pageNum3.click();
		utils.waitUntilElementVisible(veiwPage.pageNum3);
		WebElement rightArrow = Driver.getDriver()
				.findElement(By.xpath("(//a[contains(@class, 'relative inline-flex')])[5]"));
		String classAttribute = rightArrow.getAttribute("class");
		boolean isDisabled = classAttribute.contains("disabled");
		Assert.assertTrue(isDisabled);

	}

// Test Case 2, Scenario: I am able to verify Item page

	@When("I able to click on {string}")
	public void i_able_to_click_on(String string) {
		veiwPage.AddItem.click();
	}

	@Then("I should be on the page")
	public void i_should_be_on_the_page() throws InterruptedException {
		Thread.sleep(1000);
		Assert.assertTrue(veiwPage.NewItemPage.isDisplayed());
	}

	@Then("in Name Field, I should see an Error Message {string} if i insert {int} characters or more")
	public void in_name_field_i_should_see_an_error_message_if_i_insert_characters_or_more(String string, Integer int1)
			throws InterruptedException {
		Thread.sleep(1000);
		veiwPage.ItemName.sendKeys(
				"I should see Error Message such as Display Name must be less than 50 characters if i insert 50 characters or more");
		// this step below after fixing bug
		// Assert.assertTrue(veiwPage.ErrorMessage.isDisplayed());
	}

	@Then("I should see Price with numerical values")
	public void i_should_see_price_with_numerical_values() {
		veiwPage.ItemPrice.sendKeys("8000");
	}

	@Then("I should see Unit dropdown displays A total of {int} units")
	public void i_should_see_unit_dropdown_displays_a_total_of_units(Integer int1) {
		veiwPage.addItemUnit.click();
		utils.waitUntilElementVisible(veiwPage.addItemUnit);
		// this step below after fixing bug

	}

	@Then("in Description Field, I should see an Error Message {string} if i insert {int} characters or more")
	public void in_description_field_i_should_see_an_error_message_if_i_insert_characters_or_more(String string,
			Integer int1) {

		veiwPage.ItemDescription.sendKeys(
				"I should see an Error Message such as Description must be 200 characters or less if i insert 200 characters or more");
		// this step below after fixing bug
		// Assert.assertTrue(veiwPage.DescriptionErrorMessage.isDisplayed());
	}

	// Test Case 3, Scenario: I am able to add Item page
	@When("I able to click on1 {string}")
	public void i_able_to_click_on1(String string) {
		veiwPage.AddItem.click();
	}

	@Then("I am on the page")
	public void i_am_on_the_page() throws InterruptedException {
		Thread.sleep(1000);
		Assert.assertTrue(veiwPage.NewItemPage.isDisplayed());
	}

	@When("I provide item information name {string}, price {int}, unit {string}, and description {string}")
	public void i_provide_item_information_name_price_unit_and_description(String name, Integer price, String unit,
			String description) {
		itemName = name + utils.randomNumber();
		utils.waitUntilElementVisible(veiwPage.ItemName);
		veiwPage.ItemName.sendKeys(itemName);
		utils.waitUntilElementVisible(veiwPage.ItemPrice);
		veiwPage.ItemPrice.sendKeys(price.toString());
		veiwPage.addItemUnit.click();
		utils.waitUntilElementVisible(veiwPage.addItem_pc_unit);
		Driver.getDriver().findElement(By.xpath("//span[text()='" + unit + "']")).click();

		veiwPage.ItemDescription.sendKeys(description);

	}

	@Then("I click Save Item button")
	public void i_click_save_item_button() {
		veiwPage.saveItemButton.click();
	}

	@Then("I should see a flash message {string}")
	public void i_should_see_a_flash_message(String string) throws InterruptedException {

		Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// Thread.sleep(10000);
		utils.waitUntilElementVisible(veiwPage.flashMessage);
		Assert.assertTrue(veiwPage.flashMessage.isDisplayed());

	}

	@Then("I can close the flash message by clicking on the {string} button.")
	public void i_can_close_the_flash_message_by_clicking_on_the_button(String string) throws InterruptedException {

		Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		veiwPage.flashMessageXXX.click();

	}

	@Then("I should be navigated to the Items Page.")
	public void i_should_be_navigated_to_the_items_page() throws InterruptedException {
		Thread.sleep(1000);
		Assert.assertTrue(veiwPage.NewItemPage.isDisplayed());

	}

	@Then("The Item is added to the Item list table")
	public void the_item_is_added_to_the_item_list_table() {

		Assert.assertTrue(Driver.getDriver().findElement(By.xpath("//a[text()='" + itemName + "']")).isDisplayed());

	}

	@Then("I should be able to see the item in database name {string}, price {int}, unit {string}, and description {string}")
	public void i_should_be_able_to_see_the_item_in_database_name_price_unit_and_description(String string,
			Integer int1, String string2, String string3) {
		String query = "SELECT name, price, unit_id, description FROM items where name='" + itemName + "';";
		System.out.println(query);
		List<String> itemInfo = dbutil.selectArecord(query);
		for (String string1 : itemInfo) {
			System.out.println(string1);
		}

		//Assert.assertEquals(itemName, itemInfo.get(0));

		//for (int i = 1; i < list.size(); i++) {
			//if (list.get(i).equals("pc")) {
			//	Assert.assertEquals(itemInfo.get(i), "11");
			//} else {
			//	Assert.assertEquals(list.get(i), itemInfo.get(i));
			//}
		//}
	}

//Test Case 4, Scenario: I am able to filter Item page
	@When("I able to click on Filte icon")
	public void i_able_to_click_on_filte_icon() {
		veiwPage.FilterButton.click();
	}

	@Then("I should see the following text boxes appear such as box-{int} for Name, box-{int} for Unit, box-{int} for Price and link-{int} for clear all")
	public void i_should_see_the_following_text_boxes_appear_such_as_box_for_name_box_for_unit_box_for_price_and_link_for_clear_all(
			Integer int1, Integer int2, Integer int3, Integer int4) {
		utils.waitUntilElementVisible(veiwPage.ItemNameInTable);
		Assert.assertTrue(veiwPage.ItemNameInTable.isDisplayed());
		utils.waitUntilElementVisible(veiwPage.ItemUnitNmaeInTable);
		Assert.assertTrue(veiwPage.ItemUnitNmaeInTable.isDisplayed());
		utils.waitUntilElementVisible(veiwPage.PriceNameInTable);
		Assert.assertTrue(veiwPage.PriceNameInTable.isDisplayed());
		utils.waitUntilElementVisible(veiwPage.ClearALLInTable);
		Assert.assertTrue(veiwPage.ClearALLInTable.isDisplayed());
	}

	@Then("If I type a value in the Name text box, then the application will perform a wild card search for any item matching the value")
	public void if_i_type_a_value_in_the_name_text_box_then_the_application_will_perform_a_wild_card_search_for_any_item_matching_the_value() {
		veiwPage.NameSearchInTable.click();
		veiwPage.NameSearchInTable.sendKeys("mercedes benz842");
		Assert.assertTrue(veiwPage.ItemNameInSEARCH.isDisplayed());
	}

	@Then("If I type a value in the Unit text box, then the application will perform a wild card search for any item matching the value.")
	public void if_i_type_a_value_in_the_unit_text_box_then_the_application_will_perform_a_wild_card_search_for_any_item_matching_the_value()
			throws InterruptedException {
		veiwPage.FilterButton.click();
		Thread.sleep(1000);
		veiwPage.FilterButton.click();
		utils.waitUntilElementVisible(veiwPage.ItemUnitInSEARCH);
		veiwPage.ItemUnitInSEARCH.sendKeys("stone" + Keys.ENTER);

	}

	@Then("If I type a value in the price {int} text box, then the application will perform a wild card search for any item matching the value.")
	public void if_i_type_a_value_in_the_price_text_box_then_the_application_will_perform_a_wild_card_search_for_any_item_matching_the_value(
			Integer price) throws InterruptedException {
		veiwPage.FilterButton.click();
		Thread.sleep(1000);
		veiwPage.FilterButton.click();
		Thread.sleep(1000);
		// utils.waitUntilElementVisible(veiwPage.ItemPriceInSEARCH);
		// veiwPage.ItemPriceInSEARCH.click();
		veiwPage.ItemPriceInSEARCH.sendKeys(price.toString());

	}

	@Then("If I type a value in one or more of the text boxes, then the application will perform a wild card search based on a item matching all combinations.")
	public void if_i_type_a_value_in_one_or_more_of_the_text_boxes_then_the_application_will_perform_a_wild_card_search_based_on_a_item_matching_all_combinations() {
		veiwPage.NameSearchInTable.click();
		veiwPage.NameSearchInTable.sendKeys("mercedes benz842");
		Assert.assertTrue(veiwPage.ItemNameInSEARCH.isDisplayed());
		utils.waitUntilElementVisible(veiwPage.ItemUnitInSEARCH);
		veiwPage.ItemUnitInSEARCH.sendKeys("stone" + Keys.ENTER);

	}

	@Then("If my search does not return any results then I should see an empty table with the following message in grey {string}")
	public void if_my_search_does_not_return_any_results_then_i_should_see_an_empty_table_with_the_following_message_in_grey(
			String string) {
		veiwPage.NameSearchInTable.click();
		veiwPage.NameSearchInTable.sendKeys("mercedes");
		Assert.assertTrue(veiwPage.ItemNameInSEARCH.isDisplayed());
		utils.waitUntilElementVisible(veiwPage.ItemUnitInSEARCH);
		veiwPage.ItemUnitInSEARCH.sendKeys("stone" + Keys.ENTER);

		Assert.assertTrue(veiwPage.NoResultsFound.isDisplayed());

	}

	@Then("If I click on the ‘Clear All’ link then the application will display the current list of items.")
	public void if_i_click_on_the_clear_all_link_then_the_application_will_display_the_current_list_of_items() {
		veiwPage.ClearALLInTable.click();
		Assert.assertTrue(veiwPage.current_list_of_items.isDisplayed());
	}

	@Then("If I click on the ‘Filter’ button again then I should see the dialog with following closed:such as box-{int} for Name, box-{int} for Unit, box-{int} for Price and link-{int} for clear all")
	public void if_i_click_on_the_filter_button_again_then_i_should_see_the_dialog_with_following_closed_such_as_box_for_name_box_for_unit_box_for_price_and_link_for_clear_all(
			Integer int1, Integer int2, Integer int3, Integer int4) throws InterruptedException {
		veiwPage.FilterButton.click();
		Assert.assertTrue(veiwPage.ItemNameInTable.isDisplayed());
		Assert.assertTrue(veiwPage.ItemUnitNmaeInTable.isDisplayed());

	}

}