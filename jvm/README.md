# Basic Testing Techniques (JVM)

![workflow-jvm badge](https://github.com/metaphori/testing-basic-techniques/actions/workflows/workflow-jvm.yaml/badge.svg)

## Project setup

**`gradle init`**

```
$ gradle init

Select type of project to generate:
  1: basic
  2: application
  3: library
  4: Gradle plugin
Enter selection (default: basic) [1..4] 2

Select implementation language:
  1: C++
  2: Groovy
  3: Java
  4: Kotlin
Enter selection (default: Java) [1..4] 3

Select build script DSL:
  1: Groovy
  2: Kotlin
Enter selection (default: Groovy) [1..2] 2

Select test framework:
  1: JUnit 4
  2: TestNG
  3: Spock
  4: JUnit Jupiter
Enter selection (default: JUnit 4) [1..4] 4

Project name (default: jvm): testing-basics
Source package (default: testing.basics): it.unibo.testlecture

```

## Units

### Unit 01 - Introduction to software testing

- Consider package: `it.unibo.testlecture.u01_intro`
- Consider `NumFinder`
- Consider `AutomaticTest1`
- Now let's separate the "main" application from the "test" code
- Consider `AutomaticTest2`
- Consider `AutomaticTest3`
- Now, let's use a test automation framework (like JUnit)
- Consider the revised SUT `MinMaxFinder`
- Consider `MinMaxFinderTest`
- We can still improve it: consider `MinMaxFinderParameterizedTest`
- You can run tests as follows: `./gradlew test --rerun-tasks`

### Unit 02 - Testing basics in JUnit 5

- Exercise
    - Analyse `AccountHolder`, `BankAccount` and `SimpleBankAccount`
    - Analyse and run the proposed test: `SimpleBankAccountTest`
    - Implement a new version of a bank account, allowing the deposit and
      the withdraw using also the ATM. Each transaction done with the
      ATM implies paying a 1$ fee.
          - The new bank account must implements the BankAccount interface and coded into a new class SimpleBankAccountWithAtm
          - It is requested to provide a new test class for the new bank account ( `SimpleBankAccountWithAtmTest` )
    - Apply the DRY principle to refactor the written code, avoiding repetitions of code
          -This principle must be applied both to classes and tests.

### Unit 03 - Coverage

- See `ProgramToCover` and test `CoverageExample`

### Unit 04 - TDD

- Exercise
    - following the TDD approach, provide an implementation for the CircularList interface

## Contacts

- Roberto Casadei, roby [dot] casadei [at] unibo [dot] it
