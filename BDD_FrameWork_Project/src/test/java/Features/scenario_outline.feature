@Test
Feature: Add/Delete New Employee Table
  Description:Add_Delete_New_Employee (Using Scenario Outline and Data Driven Model)
  Scenario Outline: Add_Delete_New_Employee
    Given Open the Homepage
    Then Choose The Card Type
    When Choose The Element Type
    Then See The Record Table
    Then Click the Add Button
    Then Give the Firstname "<firstName>"
    Then Give the LastName "<lastName>"
    Then Give the Email "<email>"
    Then Give the Age "<age>"
    Then Give the Salary "<salary>"
    Then Give the Department "<department>"
    When Click the Submit Button
    Then Delete The New Register

    Examples:
      | firstName | lastName | email           | age | salary | department |
      | ftm       | Krks     | test@gmail.com  | 25  | 10000  | IT         |
      | stm       | Trts     | test1@gmail.com | 30  | 20000  | IT         |
      | ktm       | Krks     | test@gmail.com  | 25  | 30000  | IT         |






