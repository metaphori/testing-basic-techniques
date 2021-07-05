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