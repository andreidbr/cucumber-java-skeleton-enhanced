@ignore
Feature: Data table scenarios

  @SimpleDataTable @ReadScenarioName
  Scenario: Passing in multiple rows of details
    When I read the current scenario name
    Then I should find the following words
      | multiple |
      | rows     |
      | details  |

  @NoHeaders
  Scenario: Using data tables without headers
    Given I have 4 scenarios
    When I perform the following operations
      | add      | 2 |
      | subtract | 1 |
    Then I should have 5 scenarios

  @WithHeaders
  Scenario: Using data tables with headers
    Given I have 4 scenarios
    When I perform the following operations with headers
      | operation | count |
      | add       | 2     |
      | subtract  | 3     |
    Then I should have 3 scenarios