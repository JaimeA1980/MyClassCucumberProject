#Author: syntax team (asel@syntaxtechs.com)
@sprint2 @addemployee
Feature: Add Employee

  Background: 
    Given I am logged into HRMS
    And I navigated to Add Employee Page

  Scenario: Add new Employee
    When I add "John", "S" and "Schmidt"
    And I click Save
    Then I see Employee has been succesfully added

  @regression
  Scenario Outline: Add new Employee
    When I add "<FirstName>", "<MiddleName>" and "<LastName>"
    And I click Save
    Then I see Employee with "<FirstName>", "<MiddleName>" and "<LastName>" is displayed

    Examples: 
      | FirstName | MiddleName | LastName |
      | James     |            | Smith    |
      | Analia    | J          | Smith    |
      | Sasha     | J          | Smith    |
      | David     | J          | Smith    |

  Scenario: Add Employee without employee id
    When I add "Guadalupe", "Maria" and "Yañez"
    And I delete employee id
    And I click Save
    Then I see employee without employee id is being added

  @temp
  Scenario: Add and Modify Employee Details
    When I enter employee details
      | FirstName | MiddleName | LastName |
      | John      | J          | Smith    |
    And I click Save
    Then I am able to modify Employee Details
      | DriverLicense | ExpirationDate | SSN         | SIN     | Gender | MaritalStatus | Nationality | DOB        |
      | N78787886     | 2021-12-08     | 123-45-6789 | 7687687 | Male   | Other         | Afghan      | 1980-10-10 |
      | Nhkjkgkhgkg   | 2018-12-08     | yiy-45-6789 | uyiy    | Female | Married       | Burmese     | 1980-10-10 |

  Scenario: Add Employee negative scenario
    When I click Save
    Then I see required error message next to the first and last name

 
  Scenario: AddEmployee and Login Credentials
    When I add "Nepo", "Ricky" and "Scandaloso"
    And I click on create login checkbox
    And I enter "Nepom20202", "Syntax@1234" and confirm "Syntax@1234"
    When I click Save
    Then I see Employee has been succesfully added
