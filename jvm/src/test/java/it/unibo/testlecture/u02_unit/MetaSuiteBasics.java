package it.unibo.testlecture.u02_unit;

import org.junit.jupiter.api.DisplayName;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.IncludePackages;
import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.runner.RunWith;

@DisplayName("Basics suite")
@RunWith(JUnitPlatform.class)
@IncludeTags({ "basics" })
@SelectPackages("it.unibo")
public class MetaSuiteBasics {
}
