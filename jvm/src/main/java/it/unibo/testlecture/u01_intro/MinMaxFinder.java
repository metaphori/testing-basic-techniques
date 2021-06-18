package it.unibo.testlecture.u01_intro;

import org.apache.commons.lang3.tuple.ImmutablePair;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

/*
 * Improves over NumFinder
 */
public class MinMaxFinder {
    public Optional<ImmutablePair<Integer,Integer>> find(int[] numbers){
        if(numbers == null) return Optional.empty();

        Optional<Integer> smallest = Optional.empty();
        Optional<Integer> largest = Optional.empty();

        for(int n : numbers){
            smallest = smallest.map(x -> x < n ? x : n).or(() -> Optional.of(n));
            largest = largest.map(x -> x > n ? x : n).or(() -> Optional.of(n));
        }

        final Optional<Integer> min = smallest;
        final Optional<Integer> max = largest;
        return min.flatMap(minv -> max.map(maxv -> ImmutablePair.of(minv,maxv)));
    }
}
