package it.unibo.testlecture.u03_coverage;

public class ProgramToCover {
  public static void methodToCover(boolean c1, boolean c2, boolean c3, boolean c4, boolean c5, int k) {
    System.out.print("A");
    if(c1 && c2) System.out.print("B"); else System.out.print("C");
    System.out.print("D");
    if(c3 || c4) System.out.print("E"); else System.out.print("F");
    System.out.print("G");
    if(c5) System.out.print("H");
    for(int j = 1; j <= k; j++) System.out.print(j);
  }
}
