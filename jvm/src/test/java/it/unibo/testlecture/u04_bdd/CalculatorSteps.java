package it.unibo.testlecture.u04_bdd;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import it.unibo.testlecture.u02_unit.Calculator;
import org.junit.jupiter.api.Assertions;

public class CalculatorSteps {
    Calculator calculator;
    int x, y, actualResult;

    @Given("a calculator")
    public void a_calculator() {
        calculator = new Calculator();
    }


    @Given("one operand {int}")
    public void one_operand(Integer x) {
        this.x = x;
    }

    @Given("another operand {int}")
    public void another_operand(Integer y) {
        this.y = y;
    }

    @When("I run addition on them")
    public void i_run_addition_on_them() {
        actualResult = calculator.add(x, y);
    }

    @When("I run subtraction on them")
    public void i_run_subtraction_on_them() {
        actualResult = calculator.subtract(x, y);
    }

    @Then("I should obtain result {int}")
    public void i_should_obtain_result(Integer expectedResult) {
        Assertions.assertEquals(expectedResult, actualResult);
    }

}
