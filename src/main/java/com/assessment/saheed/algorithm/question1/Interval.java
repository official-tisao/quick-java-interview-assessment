package com.assessment.saheed.algorithm.question1;

import lombok.Data;

@Data
public class Interval {
    int start;
    int end;

    public Interval(int s, int e) {
        start = s;
        end = e;
    }
}

