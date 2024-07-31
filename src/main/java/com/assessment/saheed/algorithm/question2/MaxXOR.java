package com.assessment.saheed.algorithm.question2;

public class MaxXOR {
    public static int maxXor(int[] arr) {
        int maxXor = 0, currXor = 0, lastValue = 0;
        for (int num : arr) {
            currXor = (num+lastValue);
            maxXor = Math.max(maxXor, currXor);
            lastValue = num;
        }
        return maxXor;
    }
}
