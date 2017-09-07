@feature
Feature: English Premier League event

  @scenario
  Scenario: As a WH Customer I want the ability to place a bet on a English Premier League event
    Given Navigate to http://sports.williamhill.com/betting/en-gb
    When Navigate to any football event
    And Select event and place a "0.15" bet for the home team to Win
    And Place bet and assert the odds and returns offered
    Then Close the browser
