package it.unibo.testlecture.u02_unit;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MetaTestLifecycle {
    private static Logger logger;

    private int k = 0;

    @BeforeAll public static void beforeAll(){
        logger = LoggerFactory.getLogger(MetaTestLifecycle.class);
        logger.info("Before All");
    }
    @AfterAll  public static void afterAll(){
        logger.info("After All");
    }
    @BeforeEach public void beforeEach(){  logger.info("Before Each");  }
    @AfterEach public void afterEach(){
        logger.info("After Each");
    }

    @ParameterizedTest
    @ValueSource(strings = { "", "foo", "bar", "x" })
    public void test_string_size_non_negative(String s){
        System.out.println(k++);
        Assertions.assertTrue(s.length() >= 0);
    }

}
