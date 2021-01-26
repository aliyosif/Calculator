package com.steven.test;

import com.steven.algorithm.Calculator;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class Tester {

    @Test
    public void testResult() {
        Calculator calculator = new Calculator();
        List<Integer> count = new ArrayList<>();
        int[] bundles = {3, 5, 9};
        count = calculator.getResult(38, "VID", bundles);
        assertEquals(6, count.size());
    }
}
