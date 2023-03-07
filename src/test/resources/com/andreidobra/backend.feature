@api
Feature: Backend functionality

  @UUIDValidation
  Scenario: Title of the page should match expected
    When User successfully logs in
#    Thanks to Cucumber expressions, the next step points to the same step definition as previous one
#    When I successfully log in
    Then A unique user ID is assigned of length 36