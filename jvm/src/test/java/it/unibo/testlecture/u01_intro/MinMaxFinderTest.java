package it.unibo.testlecture.u01_intro;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

public class MinMaxFinderTest {

    @Test
    public void test_empty_array(){
        MinMaxFinder sut = new MinMaxFinder();
        Optional<ImmutablePair<Integer,Integer>> actual = sut.find(
                new int[]{ }
        );
        assertEquals(Optional.empty(), actual);
    }

    @Test
    public void test_increasing_values(){
        MinMaxFinder sut = new MinMaxFinder();
        Optional<ImmutablePair<Integer,Integer>> actual = sut.find(
                new int[]{ 1, 2, 3, 4 }
        );
        assertEquals(nonEmptyPair(1, 4), actual);
    }

    @Test
    public void test_decreasing_values(){
        MinMaxFinder sut = new MinMaxFinder();
        Optional<ImmutablePair<Integer,Integer>> actual = sut.find(
                new int[]{ 4, 3, 2, 1 }
        );
        assertEquals(nonEmptyPair(1, 4), actual);
    }

    @Test
    public void test_positive_and_negative_values(){
        MinMaxFinder sut = new MinMaxFinder();
        Optional<ImmutablePair<Integer,Integer>> actual = sut.find(
                new int[]{ 77, -5, 8, -13, 0 }
        );
        assertEquals(nonEmptyPair(-13, 77), actual);
    }

    private static Optional<ImmutablePair<Integer,Integer>> nonEmptyPair(Integer left, Integer right){
        return Optional.of(ImmutablePair.of(left, right));
    }
}
