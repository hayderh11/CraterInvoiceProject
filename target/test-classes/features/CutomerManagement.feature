#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template

@cutomersTest
Feature: Create Customer Functionality for Invoice Application
  
  Background: 
    Given I am logged into the Crater application
		And I have clicked on the 'Customers' menu link
		
  

  @verifyCustomer
  Scenario: Verify Customers Page UI components
    When I am on the 'Customers' page
    Then I should see the menu navigation path as "Home / Customers" placed under "Customers".
		And I should see a secondary button titled "Filter" with a filter icon
		And I should see a primary button titled "+ New Customer"
		And I should see a table with the following columns: Select All checkbox, NAME, PHONE, AMOUNT DUE, ADDED ON
		And I should see a link icon showing three dots with the following options: Edit with an edit icon, View with a view icon, Delete with a delete icon
		And I should see the pagination text as follows: "Showing 1 to 10 of <Total customers> results"
		And I should be able to see the pagination navigation with the following controls:Left arrow allowing the user to navigate to previous pages, Right arrow allowing the user to navigate to the next pages, Number indicating the page the user is currently on and the next upcoming page
		And the left arrow should be disabled if the user is on the first page
		And the right arrow should be disabled if the user is on the last page.	
			
			
			
			
#Login into the Crater application.
#Click on 'Customers' menu link.
#I should be navigated to Page titled 'Customers'. 
#I should see the menu navigation path as "Home / customers" placed under "Customers".
#Button 1- I should see a secondary button titled "Filter" with a filter icon. 
#Button 2 - I should see a primary button titled "+ New Customer".
#I should see a table with the following columns:
#|Select All checkbox.| NAME.| PHONE.| AMOUNT DUE.| ADDED ON.| 
#I should see a link icon showing three dots with the following options:
#Option 1: Edit with an edit icon.
#Option 2: View with a view icon.
#Option 3: Delete with a delete icon.
#I should see Pagination text as follows: ‘Showing 1 to 10 of <Total customers> ‘results’.
#I should be able to see Pagination navigation with the following controls:
#Left arrow allowing the user navigate to previous pages.
#Right arrow allowing the user to navigate to the next pages.
#Number indicating the page the user is currently on and the next upcoming page.
#Left arrow is disabled if the user is on the first page.
#Right arrow is disabled if the user is on the last page.

