@Test
Feature: Test Background Feature
  Description: The purpose of this feature is to test the Background keyword

  Background: User is Logged In
    Given Open the Homepage
    And I navigate to the Book Store Card
    And I navigate to the Login Page
    When I submit username and password
    Then I should be logged in

  Scenario: User is Logout
    And I log out from the App
    Then See be log out of the app succesfull
    Then Close the App

  Scenario: Search a book and add the first book to the your collection
    And I navigate to the Book Store
    Given User search for "Git Pocket Guide"
    When Add the first book that appears in the search result to the basket
    Then User basket should display with added item
    Then Close the App

  Scenario: Navigate to a product and add the same to the User basket
    Given User navigate for Profile Page
    When See and delete the Book that you added to the basket
    Then User basket should display empty
    Then Close the App