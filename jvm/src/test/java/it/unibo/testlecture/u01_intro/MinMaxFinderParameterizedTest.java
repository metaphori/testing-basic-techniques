package it.unibo.testlecture.u01_intro;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Optional;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MinMaxFinderParameterizedTest {

    @ParameterizedTest(name = "[{index}] {2}")
    @MethodSource("minMaxFinderTestCases")
    public void test_empty_array(int[] inputs, Optional<ImmutablePair<Integer,Integer>> expected, String name){
        MinMaxFinder sut = new MinMaxFinder();
        Optional<ImmutablePair<Integer,Integer>> actual = sut.find(inputs);
        assertEquals(expected, actual);
    }

    private static Stream<Arguments> minMaxFinderTestCases(){
        return Stream.of(
                Arguments.of(null, Optional.empty(), "null array"),
                Arguments.of(new int[]{ }, Optional.empty(), "empty array"),
                Arguments.of(new int[]{ -5 }, nonEmptyPair(-5, -5), "singleton array"),
                Arguments.of(new int[]{ 1, 2, 3, 4 }, nonEmptyPair(1, 4), "monotonically increasing sequence"),
                Arguments.of(new int[]{ 4, 3, 2, 1 }, nonEmptyPair(1, 4), "monotonically decreasing sequence"),
                Arguments.of(new int[]{ Integer.MAX_VALUE, Integer.MIN_VALUE }, nonEmptyPair(Integer.MIN_VALUE, Integer.MAX_VALUE), "boundary values")
        );
    }

    private static Optional<ImmutablePair<Integer,Integer>> nonEmptyPair(Integer left, Integer right){
        return Optional.of(ImmutablePair.of(left, right));
    }
}
