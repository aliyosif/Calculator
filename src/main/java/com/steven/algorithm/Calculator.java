package com.steven.algorithm;

import java.util.ArrayList;
import java.util.List;

public class Calculator {

    public static List<Integer> getResult(int target, String type, int[] types) {
        List<Integer> result = new ArrayList<>();
        int[] bundle = new int[target + 1];
        int min = getMinBundle(target, types, bundle);
        if (min > Integer.MAX_VALUE - target) {
//            System.out.println("No suitable bundle found!!");
            System.out.print("");
        } else {
            for (int i = target; i > 0;) {
                result.add(bundle[i]);
                i = i - bundle[i];
            }
        }
        return result;
    }

    public static int getMinBundle(int target, int[] types, int[] bundle) {

        int[] min = new int[target + 1];
        min[0] = 0;
        for (int i = 1; i < target + 1; i++) {
            if (i >= types[0]) {
                min[i] = min[i - types[0]] + 1;
                bundle[i] = types[0];
            } else {
                min[i] = Integer.MAX_VALUE - target;
            }
            for (int j = 1; j < types.length; j++) {
                if (i >= types[j] && (min[i] > min[i - types[j]] + 1)) {
                    min[i] = min[i - types[j]] + 1;
                    bundle[i] = types[j];
                }
            }
        }
        return min[target];
    }
}
