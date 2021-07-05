package it.unibo.testlecture.u04_bdd;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = { "classpath:features/CalculationFeature.feature" },
        tags = { "bdd" },
        glue = { "classpath:it.unibo.testlecture.u04_bdd" },
        plugin = { "pretty", "html:target/cucumber/html" })
public class RunCucumberTests { }

// IntelliJ Idea: run by right clicking on feature file