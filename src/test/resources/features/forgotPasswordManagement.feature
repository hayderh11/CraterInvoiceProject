 @forgotPassword @regression
 
 Feature: As a User, I should be able to reset my password
 
 Background: 
 Given I am on the Crater Invoice Application 
 
 @forgotPasswordLink @smokeTest
 Scenario: As a User, I should be able to use the forgot password link
 When I click on the forgot password link
 Then I should see the 'Enter email' textbox
 And I should see the 'Send Reset Link' button
 And I should see the 'Back To Login' link
 
 @forgotPasswordErrorMsgs
 Scenario: As a User, I am able to see the valid error messages
 When I click on the forgot password link
 Then I should see the 'Enter email' textbox
 And I should see the 'Send Reset Link' button
 And I should see the 'Back To Login' link
 When I enter an invalid email '234%@rwe@.com'
 And I leave the 'Enter email' textbox empty
 Then I enter a valid email 'Cratertesting@gmail.com'
 And I click on the'Send Reset Link'
 And I click on the 'Back To Login' link
 
 
