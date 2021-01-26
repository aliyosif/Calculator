package com.steven;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Main {

    private static List<OrderItem> orders = new ArrayList<>();
    private static Order order = new Order();
    private static Bundle bundle = new Bundle();
    private static int[] bundles;
    private static Calculator calculator = new Calculator();
    private static IOManager ioManager = new IOManager();

    public static void main(String[] args) {
        orders = ioManager.readOrders();
        order.mapOrder(orders).forEach((key, value) -> System.out.println(value + " " + key));
        waitResult();
        ioManager.writeResult(orders, order, bundles, bundle, calculator);

    }

    public static void println(String prompts) {
        System.out.println(prompts);
    }

    private static void waitResult() {
        println("");
        println("Calculating...Please wait...");
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException ie) {
            Thread.currentThread().interrupt();
        }
        println("");
        println("Output:");
    }
}
