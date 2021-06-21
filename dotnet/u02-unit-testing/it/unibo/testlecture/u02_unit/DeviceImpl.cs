using System;

namespace it.unibo.testlecture.u02_unit_testing
{
    public class DeviceImpl : Device
    {
        public bool isOn { get; set; } 
        
    	public DeviceImpl(){
    	    this.isOn = false;  
    	}
    	
        public void on() { isOn = true; }
        public void off() { isOn = false; }
    }
}
