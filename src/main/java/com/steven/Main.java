package com.steven;

import com.steven.algorithm.Calculator;
import com.steven.model.Bundle;
import com.steven.model.Order;
import com.steven.model.IOManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

    private static Order order = new Order();
    private static final Bundle bundle = new Bundle();
    private static int[] bundles;
    private static final Calculator calculator = new Calculator();
    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        initialiseCalculator();
        String result = calculator.buildResult(order, bundles, bundle);
        logger.info(result);
        IOManager.writeResult(result);
    }

    private static void initialiseCalculator() {
        order = IOManager.readOrder();
        order.mapOrder().forEach((key, value) -> logger.info(value + " " + key));
    }
}
