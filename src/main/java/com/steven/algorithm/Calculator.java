package com.steven.algorithm;

import com.steven.model.Bundle;
import com.steven.model.Order;
import com.steven.model.OrderItem;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Calculator {

    private static final Logger logger = LogManager.getLogger(Calculator.class);

    public static List<Integer> getResult(int target, String type, int[] types) {
        List<Integer> result = new ArrayList<>();
        int[] bundle = new int[target + 1];
        int min = getMinBundle(target, types, bundle);
        if (min > Integer.MAX_VALUE - target) {
            logger.error("");
        } else {
            for (int i = target; i > 0; ) {
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

    public static String buildResult(Order order, int[] bundles, Bundle bundle) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Output:");
        for (OrderItem item : order.getOrder()) {
            int target = order.mapOrder().get(item.getMediaType());
            int[] bundleNum = new int[target + 1];
            double answer;
            double total = 0;
            int count;
            bundles = bundle.convertBundle(bundle.determineBundle(item.getMediaType(), bundle.filterBundle(item.getMediaType())));
            stringBuilder.append("\n");
            stringBuilder.append(item);
            stringBuilder.append("\n");
            getMinBundle(target, bundles, bundleNum);
            for (Integer in : bundles) {
                if (bundle.filterBundle(item.getMediaType()).containsKey(in)) {
                    count = Collections.frequency(getResult(target, item.getMediaType(), bundles), in);
                    if (count > 0) {
                        answer = count * bundle.filterBundle(item.getMediaType()).get(in);
                        stringBuilder.append(count).append(" X ").append(in).append(" $").append(answer);
                        stringBuilder.append("\n");
                        total += answer;
                    }
                }
            }
            stringBuilder.append("Total: $").append(total);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
}
