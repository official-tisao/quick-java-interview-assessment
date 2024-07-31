package com.assessment.saheed;


import com.assessment.saheed.algorithm.question2.MaxXOR;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MaxXORTest {

    @Test
    public void testMaxXOR() {
        int[] arr = {1, 2, 3, 4};
        int expected = 7;
        int actual = MaxXOR.maxXor(arr);
        assertEquals(expected, actual);
    }
}
