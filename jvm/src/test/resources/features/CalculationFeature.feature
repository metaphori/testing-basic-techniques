Feature: Calculation
  As a user
  I want to use a calculator
  So that I can perform multiple kinds of calculations

  Background:
    Given a calculator

  Scenario: I want to sum two nums
    Given one operand 7
    And another operand 8
    When I run addition on them
    Then I should obtain result 15

  Scenario Outline: I want to subtract two nums
    Given one operand <operand1>
    And another operand <operand2>
    When I run subtraction on them
    Then I should obtain result <result>
    Examples:
      | operand1 | operand2 | result |
      | 10 |  3 |  7 |
      |  2 |  5 | -3 |
      | -5 |  3 | -8 |
      | -5 | -3 | -2 |
      |  0 |  0 |  0 |
