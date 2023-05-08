@regression @itemsTests
Feature: Items Page

  Background: 
    Given I am an external user, I am logged in
    And I click on the item menu link

  @ViewItemsPage @smkoetest
  Scenario: I am able to view and see page expected elemints
    When I am on the Item page
    Then I should see the menu navigation path as “Home / Items” placed under “Items”
    And I should see a secondary button titled “Filter” with a filter icon
    And I should see a primary button titled “+ Add Item
    And I should see a table with the following columns:
      | Select All | NAME | UNIT | PRICE | ADDED ON |
    And I should see a link icon with three dots
    And the link icon should have the options:
      | Edit   |
      | Delete |
    And I should see pagination text as "Showing 1 to 10 of <Total items> results"
    And if the user is on the first page, Left should be disabled
    And if the user is on the last page, Right should be disabled

  @VerifyItemPage @smoketest
  Scenario: I am able to verify Item page
    When I click on "+ Add Item"
    Then I should be on the page
    And in Name Field, I should see an Error Message "Display Name must be less than 50 characters" if i insert 50 characters or more
    And I should see Price with numerical values
    And I should see Unit dropdown displays A total of 34 units
    And in Description Field, I should see an Error Message "Description must be 200 characters or less" if i insert 200 characters or more

  @AddItems @smoketest
  Scenario: I am able to add Item page
    When I able to click on "+ Add Item"
    Then I am on the page
    When I provide item information name "mercedes benz", price 30000, unit "pc", and description "a good Car"
    Then I click Save Item button
    And I should see a flash message "Success! Item created successfully” with a close button to the right."
    And The flash message should disappear within 5 seconds or less.
    Then I can close the flash message by clicking on the 'X' button.
    And I should be navigated to the Items Page.
    Then The Item is added to the Item list table
    And I should be able to see the item in database name "iphone", price 1800, unit "pc", and description "a good iphone"

  @FilterItems @smoketest
  Scenario: I am able to filter Item page
  When I able to click on Filte icon
  Then I should see the following text boxes appear such as box-1 for Name, box-2 for Unit, box-3 for Price and link-1 for clear all
  And If I type a value in the Name text box, then the application will perform a wild card search for any item matching the value
  And If I type a value in the Unit text box, then the application will perform a wild card search for any item matching the value.
  And If I type a value in the price 30000 text box, then the application will perform a wild card search for any item matching the value.
  And If I type a value in one or more of the text boxes, then the application will perform a wild card search based on a item matching all combinations.
  And If my search does not return any results then I should see an empty table with the following message in grey "No Results Found"
  And If I click on the ‘Clear All’ link then the application will display the current list of items.
  And If I click on the ‘Filter’ button again then I should see the dialog with following closed:such as box-1 for Name, box-2 for Unit, box-3 for Price and link-1 for clear all
  