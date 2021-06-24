package it.unibo.testlecture.u02_unit;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class CalculatorTest {
    public static Calculator calculator;

    @BeforeAll public static void beforeAll(){
        calculator = new Calculator();
    }

    @Test void test_add_simple() {
        assertEquals(15, calculator.add(7, 8));
    }
}
