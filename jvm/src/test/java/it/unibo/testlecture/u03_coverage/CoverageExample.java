package it.unibo.testlecture.u03_coverage;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class CoverageExample {

    @Test
    public void condition_coverage(){
        // To cover all the conditions, just ensure that each one takes a different value
        ProgramToCover.methodToCover(false, true, false, true, true, 3);
        ProgramToCover.methodToCover(true, false, true, false, false, 3);
    }

    @Test
    public void decision_coverage(){
        /*
            System.out.print("A");
            if(c1 && c2) System.out.print("B"); else System.out.print("C");
            System.out.print("D");
            if(c3 || c4) System.out.print("E"); else System.out.print("F");
            System.out.print("G");
            if(c5) System.out.print("H");
            for(int j = 1; j <= k; j++) System.out.print(j);
        */

        // To cover all the decisions, just ensure that each one takes a different value
        ProgramToCover.methodToCover(true, true, false, false, true, 3);
        ProgramToCover.methodToCover(false, false, true, false, false, 3);
    }

    @Test @Disabled
    public void decision_condition_coverage(){
        ProgramToCover.methodToCover(true, true, false, false, true, 3);
        ProgramToCover.methodToCover(false, false, true, true, false, 3);
    }

}
