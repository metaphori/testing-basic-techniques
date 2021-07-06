package it.unibo.testlecture.u02_unit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

// Test suite
public class DeviceImplTest {
    // Fixture
    private Device device;

    @BeforeEach
    public void init(){
        // Fixture setup (Arrange)
        device = new DeviceImpl();
    }

    @Test
    public void test_starting_state_of_device(){
        assertFalse(device.isOn(), "Device must be off, initially.");
    }

    @Test
    @Tags({ @Tag("basics"), @Tag("appliances") })
    public void test_turning_on_when_off() {
        assumeTrue(!device.isOn());

        // Act
        device.on();

        // Assert
        assertTrue(device.isOn());
    }

    @Test
    @Tags({ @Tag("basics"), @Tag("appliances") })
    public void test_turning_off_when_on() {
        // Arrange
        device.on();
        assumeTrue(device.isOn());

        // Act
        device.off();

        // Assert
        assertFalse(device.isOn());
    }
}