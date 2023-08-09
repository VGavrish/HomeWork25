package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

public class ArrayUtilsTest {

    @Test
    public void testExtractAfterLastFour() {
        int[] input = {1,2,4,4,2,3,4,1,7};
        int[] expected = {1,7};
        assertArrayEquals(expected, ArrayUtils.extractAfterLastFour(input));
    }

    @Test
    public void testExtractAfterLastFourNoFour() {
        int[] input = {1,2,3,5,6};
        assertThrows(RuntimeException.class, () -> ArrayUtils.extractAfterLastFour(input));
    }

    @Test
    public void testContainsOnlyOnesAndFours() {
        int[] input1 = {1,1,1,4,4,1,4,4};
        assertTrue(ArrayUtils.containsOnlyOnesAndFours(input1));

        int[] input2 = {1,1,1,1,1,1,1,1};
        assertFalse(ArrayUtils.containsOnlyOnesAndFours(input2));

        int[] input3 = {4,4,4,4};
        assertFalse(ArrayUtils.containsOnlyOnesAndFours(input3));

        int[] input4 = {1,4,4,1,1,4,3};
        assertFalse(ArrayUtils.containsOnlyOnesAndFours(input4));

    }
}
