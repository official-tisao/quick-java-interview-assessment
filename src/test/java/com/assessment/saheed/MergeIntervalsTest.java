package com.assessment.saheed;

import com.assessment.saheed.algorithm.question1.Interval;
import com.assessment.saheed.algorithm.question1.MergeIntervals;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MergeIntervalsTest {

    @Test
    public void testMergeOverlappingIntervals() {
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        List<Interval> expected = Arrays.asList(new Interval(1, 6), new Interval(8, 10), new Interval(15, 18));
        List<Interval> actual = MergeIntervals.merge(intervals);
        assertEquals(expected, actual);
    }
}
