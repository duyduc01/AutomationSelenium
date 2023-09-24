@tag
Feature: Error validation
  I want to use this template for my feature file

#	Background:
#	Given I landed on Ecommerce Page

  @ErrorValidation
  Scenario Outline: Error on login valiadation
    Given I landed on Ecommerce Page
    When Logged in with username <name> and password <password>
    Then "Incorrect..." error mesage is displayed on ConfirmationPage

    Examples: 
      | name  							| password 							
      | duduc01@gmail.com		|Daihocngoai20 				
