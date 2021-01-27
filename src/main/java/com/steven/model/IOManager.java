package com.steven.model;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;
import java.io.*;

public class IOManager {

    private static final Logger logger = LogManager.getLogger(IOManager.class);

    public static Order readOrder() {
        Order order = new Order();
        String orderNum;
        try (FileReader inputFile = new FileReader("src/main/resources/order.txt")) {
            Scanner parser = new Scanner(inputFile);
            while (parser.hasNextLine()) {
                String orderItem = parser.nextLine();
                String[] parts = orderItem.split(" ");
                orderNum = parts[0];
                String orderType = parts[1];
                int target = Integer.parseInt(orderNum);
                order.getOrder().add(new OrderItem(target, orderType));
            }
        } catch (NumberFormatException exception) {
            logger.error("Invalid format found in order.txt.");
            System.exit(0);
        } catch (FileNotFoundException exception) {
            logger.error("order.txt not found.");
            System.exit(0);
        } catch (IOException exception) {
            logger.error("Unexpected I/O error occurred.");
            System.exit(0);
        }
        return order;
    }

    public static void writeResult(String result) {
        try (PrintWriter outputFile = new PrintWriter("src/main/resources/result.txt")) {
            outputFile.println(result);
        } catch (FileNotFoundException exception) {
            logger.error("order.txt not found.");
            System.exit(0);
        }
    }
}
