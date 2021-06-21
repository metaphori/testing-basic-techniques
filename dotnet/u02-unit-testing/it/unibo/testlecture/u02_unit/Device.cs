using System;

namespace it.unibo.testlecture.u02_unit_testing
{
    public interface Device
    {
        void on();
        void off();

        bool isOn { get; set; }
    }
}
