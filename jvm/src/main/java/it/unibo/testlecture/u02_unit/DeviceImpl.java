package it.unibo.testlecture.u02_unit;

public class DeviceImpl implements Device {
    private Boolean state;

    public DeviceImpl(){
        this.state = false;
    }

    @Override
    public void on() {
        this.state = true;
    }

    @Override
    public void off() {
        this.state = false;
    }

    @Override
    public Boolean isOn() {
        return state;
    }
}
