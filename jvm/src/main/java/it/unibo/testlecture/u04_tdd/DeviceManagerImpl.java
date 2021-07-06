package it.unibo.testlecture.u04_tdd;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;

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
        return Collections.unmodifiableList(devices);
    }

    @Override
    public void turnAllOn() {
        doActionOnAll(d -> d.on());
    }

    private void doActionOnAll(Consumer<Device> action) {
        for(Device d : devices) action.accept(d);
    }
}
