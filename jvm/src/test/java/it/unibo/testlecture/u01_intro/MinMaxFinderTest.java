package it.unibo.testlecture.u01_intro;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MinMaxFinderTest {

    @Test
    public void test_empty_array(){
        assertEquals(Optional.empty(), MinMaxFinder.find(
                new int[]{ }
        ));
    }

    @Test
    public void test_increasing_values(){
        assertEquals(nonEmptyPair(1, 4), MinMaxFinder.find(
                new int[]{ 1, 2, 3, 4 }
        ));
    }

    @Test
    public void test_decreasing_values(){
        assertEquals(nonEmptyPair(1, 4), MinMaxFinder.find(
                new int[]{ 4, 3, 2, 1 }
        ));
    }

    @Test
    public void test_positive_and_negative_values(){
        assertEquals(nonEmptyPair(-13, 77), MinMaxFinder.find(
                new int[]{ 77, -5, 8, -13, 0 }
        ));
    }

    private static Optional<ImmutablePair<Integer,Integer>> nonEmptyPair(Integer left, Integer right){
        return Optional.of(ImmutablePair.of(left, right));
    }
}
