package it.unibo.testlecture.u01_intro;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * See also: https://learning.edx.org/course/course-v1:DelftX+ST1x+3T2020
 */
public class NumFinder {
    private int smallest = Integer.MAX_VALUE;
    private int largest = Integer.MIN_VALUE;

    public void find(int[] numbers){
        for(int n : numbers){
            if(n < smallest) smallest = n;
            else if(n > largest) largest = n;
        }
    }

    public int getSmallest(){ return smallest; }

    public int getLargest(){ return largest; }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.print("How many numbers? ");
        int n = in.nextInt();
        List<Integer> list = new ArrayList<>(n);
        for(int i=0; i < n; i++) {
            System.out.print("\n" + i + "th number: ");
            list.add(in.nextInt());
        }
        in.close();
        NumFinder nf = new NumFinder();
        nf.find(list.stream().mapToInt(Integer::intValue).toArray());
        System.out.println("\n\nSmallest: " + nf.getSmallest());
        System.out.println("Largest: " + nf.getLargest());
    }
}
