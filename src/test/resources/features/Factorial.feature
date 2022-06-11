@wip
Feature: As a user, I should calculate the factorial

  Scenario: Calculate the factorial
    Given the user is on given page
    And the user enters "8" in the input box
    When the user clicks on the calculate button
    Then the user sees "40320" as a result and the message of factorial