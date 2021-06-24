package it.unibo.testlecture.u02_unit;

import org.junit.jupiter.api.DisplayName;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.runner.RunWith;

@DisplayName("Appliances suite")
@RunWith(JUnitPlatform.class)
//@SelectPackages("it.unibo.testlecture.u02_unit")
@SelectClasses({DeviceImplTest.class, CalculatorTest.class})
public class AppliancesSuite {
}
