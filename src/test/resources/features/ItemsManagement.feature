@regression @itemsTests
Feature: View Items Page

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
