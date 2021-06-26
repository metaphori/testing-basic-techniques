using Xunit;
using System;
using System.Collections.Generic;

namespace it.unibo.testlecture.u02_unit_testing
{
    public class MetaTestAssertions
    {

        [Fact]
        [Trait("Category","Basics")] 
        public void Test_Assertions() {
            Assert.True(true);
            Assert.Equal(7.0, 5+2);
            Assert.Equal(7.2, 5+2, 0);
            Assert.StrictEqual(7.0, 5+2);
            Assert.Contains(new int[]{ 1,2,3 }, x => x == 3);
            Assert.DoesNotContain("foobar", "xxx");
            Assert.StartsWith("foo", "foobar");
            Assert.InRange(77, 0, 100);
            Assert.ThrowsAsync<Exception>(() => throw new Exception("!!!"));
            Assert.Superset(new HashSet<int> { 2, 3 }, new HashSet<int>{ 5, 2, 3 });
        }

        [CustomIgnoreFact]
        public void Test_To_Ignore(){ /* ... */ }

        [Fact]
        public void Test_Failing(){ 
            throw new Xunit.Sdk.XunitException("This test must fail");
         }
    }

    public class CustomIgnoreFactAttribute : FactAttribute {
        public CustomIgnoreFactAttribute() {
              if(new Random().Next() % 10 > 2) Skip = "Ignored because ...";
        }
    }
}
