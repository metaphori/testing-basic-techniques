package it.unibo.testlecture.u01_intro;

public class AutomaticTest2 {
    public static void main(String[] args){
        NumFinder numFinder = new NumFinder();
        int[] input1 = new int[]{ 4, 25, 7, 9 };
        numFinder.find(input1);
        System.out.println("Apply to { 4, 25, 7, 9 } => " +
                " - smallest: " + numFinder.getSmallest() +
                " - largest: " + numFinder.getLargest());

        int[] input2 = new int[]{ 10, 20, 30 };
        numFinder.find(input2);
        System.out.println("Apply to { 10, 20, 30 } => " +
                " - smallest: " + numFinder.getSmallest() +
                " - largest: " + numFinder.getLargest());

        numFinder = new NumFinder();
        int[] input3 = new int[]{ 4, 3, 2, 1 };
        numFinder.find(input3);
        System.out.println("Apply to { 4, 3, 2, 1 } => " +
                " - smallest: " + numFinder.getSmallest() +
                " - largest: " + numFinder.getLargest());
    }
}
