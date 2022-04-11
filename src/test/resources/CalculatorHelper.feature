#Author: Velko Kapitanov
@sumTable
Feature: Calculation with different numeric types

  Rule: Addition with integers

    Scenario: Calculation with numbers
      Given I have integers
      When I add numbers 3 and 5
      Then The results is 8

  Rule: Addition with doubles

    Scenario: Calculation with numbers
      Given I have doubles
      When I add double 3.1 and 5.1
      Then The result is 8.2


    Scenario: Data table of positive and negative numbers
      Given I have table with numbers
        | 3 | -1 |
        | 2 | -5 |
      When  Operation is difference
      Then Print result

