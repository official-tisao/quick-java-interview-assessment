package com.assessment.saheed.algorithm.question1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
    public static List<Interval> merge(int[][] intervals) {
        int n = intervals.length;
        if (n <= 1) {
            return new ArrayList<>();
        }

        // Convert int[][] to Interval[]
        Interval[] intervalArr = new Interval[n];
        for (int i = 0; i < n; i++) {
            intervalArr[i] = new Interval(intervals[i][0], intervals[i][1]);
        }

        // this sort the array by start time
        Arrays.sort(intervalArr, (a, b) -> Integer.compare(a.start, b.start));

        List<Interval> merged = new ArrayList<>();
        merged.add(intervalArr[0]);

        for (int i = 1; i < n; i++) {
            Interval current = intervalArr[i];
            Interval last = merged.get(merged.size() - 1);

            if (current.start <= last.end) {
                last.end = Math.max(last.end, current.end);
            } else {
                merged.add(current);
            }
        }

        return merged;
    }
}
