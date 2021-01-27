package com.steven;

import com.steven.algorithm.Calculator;
import com.steven.model.Bundle;
import com.steven.model.Order;
import com.steven.model.IOManager;
import lombok.Lombok;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.TimeUnit;

public class Main {

    private static Order order = new Order();
    private static final Bundle bundle = new Bundle();
    private static int[] bundles;
    private static final Calculator calculator = new Calculator();
    private static final Logger logger = LogManager.getLogger(Main.class);
//    private static final Lombok lombok = new Lombok();

    public static void main(String[] args) {
        initialiseCalculator();
        waitResult();
        String result = calculator.buildResult(order, bundles, bundle);
        logger.info(result);
        IOManager.writeResult(result);
    }

    private static void initialiseCalculator() {
        order = IOManager.readOrder();
        order.mapOrder().forEach((key, value) -> logger.info(value + " " + key));
    }

    private static void waitResult() {
        logger.info("");
        logger.info("Calculating...Please wait...");
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException ie) {
            Thread.currentThread().interrupt();
        }
        logger.info("");
    }
}
