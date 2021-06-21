package it.unibo.testlecture.u02_unit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

public class DeviceImplTest {         // Test suite
    private Device device;              // Fixture

    @BeforeEach
    public void init(){                 // (1. Arrange)
        this.device = new DeviceImpl();   // Fixture setup
    }

    @Test
    public void test_turning_on_when_off() throws Exception {
        assumeTrue(!this.device.isOn());  // Assumption
        this.device.on();                 // (2. Act)
        assertTrue(this.device.isOn());   // (3. Assert)
    }
}