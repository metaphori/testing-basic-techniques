using System;

namespace it.unibo.testlecture.u03_coverage {
    public class ProgramToCover {
        public static void methodToCover(bool c1, bool c2, bool c3, bool c4, bool c5, int k) {
            Console.Write("A");
            if(c1 && c2) Console.Write("B"); else Console.Write("C");
            Console.Write("D");
            if(c3 || c4) Console.Write("E"); else Console.Write("F");
            Console.Write("G");
            if(c5) Console.Write("H");
            Console.WriteLine();
            // for(int j = 1; j <= k; j++) Console.Write(j);
        }
    }
}