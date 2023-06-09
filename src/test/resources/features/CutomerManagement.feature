
	@cutomersTest @regression
Feature: Create Customer Functionality for Invoice Application
  
  Background: 
    Given I am logged into the Crater application
		And I have clicked on the 'Customers' menu link
		When I am on the 'Customers' page
  

  @verifyCustomerUI @smokeTest
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
			
		@addNewCustomer
		Scenario: Verify Add New Customer - Successful
		Given I am on the Customers page
    When I click on "+ New Customer"
  	And I enter the following details for Basic Info:
    | Display Name      | Ronald Araujo Barcelona     |
  	| Primary Contact   | Ronald Araujo               |
    | Email             | ronald.ara@bracelona.com    |
    | Phone             | 7038924705                  |
    | Currency          | EUR - Euro                  |
    | Website           | www.barcelona.com           |
    | Prefix            | MR                          |
 	  And I enter the following details for Portal Access:
    | Password          | RonaldAraujo                 |
    | Confirm Password  | RonaldAraujo                 |
 	  And I enter the following details for Billing Address:
    | Name              | Ronald Araujo      |
    | Country           | Spain              |
    | State             | Catalonia          |
    | City              | Barcelona          |
    | Address           | 275 Camp Nou St    |
    | Phone             | 7038924705         |
    | Zip Code          | 27325              |
  	And I enter the following details for Shipping Address:
    | Name              | Ronald Araujo      |
    | Country           | Spain              |
    | State             | Catalonia          |
    | City              | Barcelona          |
    | Address           | 275 Camp Nou St    |
    | Phone             | 7038924705         |
    | Zip Code          | 27325              |
  	
  	Then I should not see any validation errors
  	And I click on the 'Save Customer' button
  	And I should see the flash message "Success! Customer created successfully" with a close button
 	  And the flash message should disappear within 5 seconds or less
  	When I click on the 'X' button to close the flash message
  	Then I should be on the Sales and expenses page
  	And I should see the following customer details:
    | Section           | Value               |
    | Basic Info        | John Smith Company  |
    | Display Name      | John Smith          |
    | Primary Contact   | john@example.com    |
    | Email             | 1234567890          |
    | Currency          | USD                 |
    | Website           | www.example.com     |
  	And the customer information for the following sections should be saved in the application database:
    | Basic Info        |
    | Portal Access     |
    | Billing Address   |
    | Shipping Address  |
    
    @verifyPopulation
    Scenario: Verify Population of Add Customer table.
    	Given I am on the Customers page
    	Then I should see the table data populated 
    	And I should be able to Select Check box populated for each customer row.
    	And I should be able to see Name column populated with the customer’s display name for each row.
    	And I should be able to see Phone column populated with the customer’s phone number for each row.
    	And I should be able to see Amount Due column populated with the current amount the customer owes.
    	And I should be able to see Added On column populated with the date that the customer was added on in the following format: <day> <Month> <Year>.
    	Then I should be able to see More link represented by three dots for each row in the table.
    
    @editCustomer
    Scenario: Verify Edit Customer
  		When I click on the more icon represented by three dots for the customer "Ronald Araujo Barcelona"
 		  And I choose to click on the button "Edit"
 		  Then I should be directed to the Edit Customer page
  		And I should see all the customer fields mentioned in AC 2, 2.1, 2.3, 2.4
  		When I edit the customer fields mentioned in AC 2, 2.1, 2.3, 2.4
  		And I need to click on the "Update Customer" button
  		Then I should be able see a flash message "Success! Customer updated successfully" with a close button to the right
  		And the flash box should disappear within 5 seconds or less
  		And I should be able to close the flash message by clicking on the 'X' button in the flash message 
  		And I should be directed to the sales and expenses page of the customer that was updated
  		And the application database should be updated with the edits made by me
    
    @deleteCustomer
    Scenario: Verify Delete Customer
    When I click on the three dots icon that is represented by three dots for the customer "Edit Customer"
		And I click on button "Delete"
		Then I should be prompted with a modal with title "<Alert Icon> Are you sure?" and message "You will not be able to recover this customer and all the related Invoices, Estimates and Payments."
		And the modal should have "Ok" and "Cancel" buttons
		When I click on "Cancel" or anywhere on the page
		Then the modal should be closed
		When I choose to click on "Ok" button that is on the model
		Then I should see a flash message "Success! Customer deleted successfully" with a close button to the right
		And I should be able to close the flash message appearing on the page by clicking on the 'X' button
		And I should be directed to the customer table
		And I should not be able to view the customer "Edit Customer" in the customer table
		And the customer record should be deleted from the application database.
    
    
    