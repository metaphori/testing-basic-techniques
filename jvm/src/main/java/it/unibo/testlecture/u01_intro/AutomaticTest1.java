package it.unibo.testlecture.u01_intro;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AutomaticTest1 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(args.length == 1
                ? new DataInputStream(AutomaticTest1.class.getClassLoader().getResourceAsStream(args[0]))
                : System.in);
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
