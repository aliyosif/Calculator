package com.steven;

import java.util.*;
import java.io.*;

public class IOManager {

    public static List<OrderItem> readOrders() {
        List<OrderItem> orders = new ArrayList<>();
        String bundleNum = "";
        try {
            FileReader inputFile = new FileReader("src/main/resources/order.txt");
            Scanner parser = new Scanner(inputFile);
            while (parser.hasNextLine()) {
                String order = parser.nextLine();
                String[] parts = order.split(" ");
                bundleNum = parts[0];
                String bundleType = parts[1];
                int target = Integer.parseInt(bundleNum);
                orders.add(new OrderItem(target, bundleType));
            }
            if (!isInteger(bundleNum)) {
                System.out.println("Invalid format found in order.txt");
                System.out.println("HINT: Each line with a number followed by one space and the type code.");
                System.exit(0);
            }
            inputFile.close();
        } catch (NumberFormatException exception) {
            System.out.println("Invalid format found in order.txt!!!");
            System.exit(0);
        } catch (FileNotFoundException exception) {
            System.out.println("order.txt not found");
            System.exit(0);
        } catch (IOException exception) {
            System.out.println("Unexpected I/O error occurred.");
            System.exit(0);
        }
        return orders;
    }

    public static boolean isInteger(String part) {
        if (part == null)
            return false;
        for (int i = 0; i < part.length(); i++) {
            if (!Character.isDigit(part.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static void writeResult(List<OrderItem> orders, Order order, int[] bundles, Bundle bundle, Calculator calculator) {
        try {
            PrintWriter outputFile = new PrintWriter("src/main/resources/result.txt");
            for (OrderItem item: orders) {
                int target = order.mapOrder(orders).get(item.getType());
                int[] bundleNum = new int[target + 1];
                double answer = 0;
                double total = 0;
                int count = 0;
                bundles = bundle.convertBundle(bundle.determineBundle(item.getType(), bundle.filterBundle(item.getType())));
                System.out.println("");
                System.out.println(target + " " + item.getType());
                calculator.getMin(target, bundles, bundleNum);
//                for (Integer in: calculator.getResult(target, item.getType(), bundles)) {
//                    if (bundle.filterBundle(item.getType()).containsKey(in)) {
//                        System.out.println(in + " $" + bundle.filterBundle(item.getType()).get(in));
//                        answer = in * bundle.filterBundle(item.getType()).get(in);
//                        total += answer;
//                    }
//                }
                for (Integer in: calculator.getResult(target, item.getType(), bundles)) {
                    for (Integer num: calculator.getResult(target, item.getType(), bundles)) {

                    }
                    if (bundle.filterBundle(item.getType()).containsKey(in)) {
                        System.out.println(in + " $" + bundle.filterBundle(item.getType()).get(in));
                        answer = in * bundle.filterBundle(item.getType()).get(in);
                        total += answer;
                    }
                }
                System.out.println("Total: $" + total);
                outputFile.println(item.getTarget() + " " + item.getType() + "\n"
                                    + calculator.getMin(target, bundles, bundleNum));
            }
            outputFile.close();
        } catch (FileNotFoundException exception) {
            System.out.println("order.txt not found");
            System.exit(0);
        }
    }
}
