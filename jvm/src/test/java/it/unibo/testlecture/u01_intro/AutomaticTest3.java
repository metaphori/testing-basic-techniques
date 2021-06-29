package it.unibo.testlecture.u01_intro;

public class AutomaticTest3 {
    public static void main(String[] args){
        NumFinder numFinder = new NumFinder();
        int[] input1 = new int[]{ 4, 25, 7, 9 };
        numFinder.find(input1);
        if(!(numFinder.getSmallest() == 4 && numFinder.getLargest() == 25)){
            System.out.println("Test Case #1 failed");
        }

        numFinder = new NumFinder();
        numFinder.find(null);
        if(!(numFinder.getSmallest() == Integer.MAX_VALUE && numFinder.getLargest() == Integer.MIN_VALUE)){
            System.out.println("Test Case #1b failed");
        }

        numFinder = new NumFinder();
        int[] input2 = new int[]{ 10, 20, 30 };
        numFinder.find(input2);
        if(!(numFinder.getSmallest() == 10 && numFinder.getLargest() == 30)){
            System.out.println("Test Case #2 failed");
        }

        numFinder = new NumFinder();
        int[] input3 = new int[]{ 4, 3, 2, 1 };
        numFinder.find(input3);
        if(!(numFinder.getSmallest() == 1 && numFinder.getLargest() == 4)){
            System.out.println("Test Case #3 failed");
        }
    }
}
