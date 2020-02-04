Feature: Report

  Background: 
    Given I am logged into HRMS
    And I navigated to the Reports Page

@regression
  Scenario: Search for invalid report
    When I enter invalid report "NoExiste"
    And I click search button
    Then I see no record found message
@regression
  Scenario: Search for valid report
    When I enter valid report "Candidates"
    And I click search button
    Then I see the search report is displayed
