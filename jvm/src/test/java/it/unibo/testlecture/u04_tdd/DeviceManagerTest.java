package it.unibo.testlecture.u04_tdd;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.List;

public class DeviceManagerTest {

    @Test
    @Tag("tdd")
    public void add_two_devices_to_manager(){
        DeviceManager dm = new DeviceManagerImpl();
        Device d1 = new DeviceImpl();
        Device d2 = new DeviceImpl();

        dm.addDevice(d1);
        dm.addDevice(d2);
        List<Device> devices = dm.managedDevices();

        assertTrue(devices.contains(d1));
        assertTrue(devices.contains(d2));
    }
}
