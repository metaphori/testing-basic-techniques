using Xunit;

namespace it.unibo.testlecture.u02_unit_testing
{
    public class CalculatorTest
    {
        private readonly Calculator calc;

        public CalculatorTest(){
            calc = new Calculator();
        }

        [Theory]
        [Trait("Category","Basics")]
        [InlineData(1, 2, 3)]
        [InlineData(-1, -2, -3)]
        [InlineData(0, 5, 5)]
        [InlineData(-5, 0, -5)]
        [InlineData(int.MinValue, -1, int.MaxValue)]
        public void Test_Calculator_Add(int v1, int v2, int expected) {
            Assert.Equal(expected, calc.Add(v1,v2));
        }
    }
}
