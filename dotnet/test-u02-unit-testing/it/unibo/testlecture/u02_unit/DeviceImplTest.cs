using Xunit;

namespace it.unibo.testlecture.u02_unit_testing
{
    public class DeviceImplTest
    {
        private readonly Device sut;

        public DeviceImplTest(){
            sut = new DeviceImpl();
        }

        [Fact]
        [Trait("Category","Basics")] 
        public void Test_Device_Impl_TurnOn_From_Starting_State() {
            Assert.True(!sut.isOn);
            sut.on();
            Assert.True(sut.isOn);
        }
    }
}
