package step_definitions;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

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
	CraterItemPage veiwPage = new CraterItemPage ();
	

@Given("I am an external user, I am logged in")
public void i_am_an_external_user_i_am_logged_in() throws InterruptedException {
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
	utils.waitUntilElementVisible(veiwPage.AddItemButton);
	Assert.assertTrue(veiwPage.AddItemButton.isDisplayed());
}
@Then("I should see a table with the following columns:")
public void i_should_see_a_table_with_the_following_columns(io.cucumber.datatable.DataTable dataTable) throws InterruptedException {
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
	WebElement leftArrow = Driver.getDriver().findElement(By.xpath("(//a[contains(@class, 'disabled cursor-normal')])[2]"));
	String classAttribute = leftArrow.getAttribute("class");
	boolean isDisabled = classAttribute.contains("disabled");
	Assert.assertTrue(isDisabled);
}
@Then("if the user is on the last page, Right should be disabled")
public void if_the_user_is_on_the_last_page_right_should_be_disabled() {
	veiwPage.pageNum3.click();
	utils.waitUntilElementVisible(veiwPage.pageNum3);
	WebElement rightArrow = Driver.getDriver().findElement(By.xpath("(//a[contains(@class, 'relative inline-flex')])[5]"));
	String classAttribute = rightArrow.getAttribute("class");
	boolean isDisabled = classAttribute.contains("disabled");
	Assert.assertTrue(isDisabled);
   
}

}