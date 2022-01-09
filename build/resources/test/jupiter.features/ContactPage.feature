@JupiterTest
Feature: Contact Page

  @Test
  Scenario: Verify Error functionality on Contact Page
    Given User is on home page
    And User is on Contact Page
    When User clicks submit button on Contact Page
    Then Validate Errors are displayed on Contact Page
    When User enters forename on Contact Page
    And User enters email on Contact Page
    And User enters message on Contact Page
    And User clicks submit button on Contact Page
    Then Validate errors are not displayed on Contact Page
    #And User closes the application


  Scenario: Verify successful submission message displayed on contact Page
    Given User is on home page
    And User is on Contact Page
    When User enters all mandatory fields on Contact Page
    And User clicks submit button on Contact Page
    Then Validate successful submission message displayed
#    And User closes the application


  Scenario: Verify Error message for Invalid data on Contact Page
    Given User is on home page
    And User is on Contact Page
    When User enters all mandatory fields with invalid data on Contact Page
    And User clicks submit button on Contact Page
    Then Validate Errors are displayed for invalid data on Contact Page
#    And User closes the application


  Scenario: Verify the items are added to cart successfully
    Given User is on home page
    And User is on Shop Page
    And User adds "Funny Cow" item with "2" quantities
    And User adds "Fluffy Bunny" item with "1" quantities
    When User clicks on cart menu
    Then Verify the items are added to cart successfully
#    And User closes the application
