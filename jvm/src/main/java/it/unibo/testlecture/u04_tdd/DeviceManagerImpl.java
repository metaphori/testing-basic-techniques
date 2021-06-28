package it.unibo.testlecture.u04_tdd;

import java.util.ArrayList;
import java.util.List;

public class DeviceManagerImpl implements DeviceManager {
    private List<Device> devices;

    public DeviceManagerImpl(){
        devices = new ArrayList<>();
    }

    @Override
    public void addDevice(Device d) {
        devices.add(d);
    }

    @Override
    public List<Device> managedDevices() {
        return devices;
    }
}
