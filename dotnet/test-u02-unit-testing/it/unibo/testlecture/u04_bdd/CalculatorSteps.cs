using System;
using Xunit;
using TechTalk.SpecFlow; // [Binding], [Given] etc.
using it.unibo.testlecture.u02_unit_testing;

namespace it.unibo.testlecture.u04_bdd {
    [Binding]
    public class CalculatorSteps {
        Calculator calculator;
        int x, y, actualResult;

         [Given(@"a calculator")]
         public void GivenACalculator()
         {
             calculator = new Calculator();
         }
 

         [Given(@"one operand (.*)")]
         public void GivenOneOperand(int x)
         {
             this.x = x;
         }
 
         [Given(@"another operand (.*)")]
         public void GivenAnotherOperand(int y)
         {
             this.y = y;
         }
 
         [When(@"I run addition on them")]
         public void WhenIRunAdditionOnThem()
         {
             actualResult = calculator.Add(x, y);
         }

        [Then(@"I should obtain result (.*)")]
        public void ThenIShouldObtainResult(int expectedResult)
         {
             Assert.Equal(expectedResult, actualResult);
         }
    }
}