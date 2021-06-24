using Xunit;
using System;
using System.Collections.Generic;

namespace it.unibo.testlecture.u02_unit_testing
{
    public class MetaTestLifecycle : IDisposable, IClassFixture<MyClassFixture>
    {
        private int k = 0;
        
        public MetaTestLifecycle(){
            Console.WriteLine("Before Each (constructor)");
        }

        public void Dispose(){
            Console.WriteLine("After Each (Dispose)");
        }

        [Theory]
        [Trait("Category","Meta")]
        [InlineData("")]
        [InlineData("foo")]
        public void Test_String_Length(string s) {
            Console.WriteLine(k++);
            Assert.True(s.Length >= 0);
        }
    }

    public class MyClassFixture : IDisposable {
        public MyClassFixture(){
            Console.WriteLine("Before All (my class fixture's constructor)");
        }

        public void Dispose(){
            Console.WriteLine("After All (my class fixture's Dispose)");
        }
    }
}
