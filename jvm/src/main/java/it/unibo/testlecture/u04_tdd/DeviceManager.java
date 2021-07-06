package it.unibo.testlecture.u04_tdd;

import java.util.List;

public interface DeviceManager {
    void addDevice(Device d);
    List<Device> managedDevices();
    void turnAllOn();
}
