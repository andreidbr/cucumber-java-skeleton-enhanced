@ui
Feature: Frontend functionality

  Background:
    Given User opens "Chrome" browser

  @TitleValidation
  Scenario Outline: Title of the page should match expected
    When User navigates to "<url>"
    Then the title of the page should be "<expectedTitle>"

    Examples:
      | url                     | expectedTitle                     |
      | https://andreidobra.com | Andrei Dobra \| AndreiDobra.com   |
      | https://duckduckgo.com  | DuckDuckGo — Privacy, simplified. |