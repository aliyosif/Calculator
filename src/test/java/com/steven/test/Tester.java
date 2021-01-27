package com.steven.test;

import com.steven.algorithm.Calculator;
import com.steven.model.IOManager;
import com.steven.model.OrderItem;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class Tester {

    @Test
    public void testResult() {
        Calculator calculator = new Calculator();
        List<Integer> count;
        int[] bundles = {3, 5, 9};
        count = calculator.getResult(38, "VID", bundles);
        assertEquals(6, count.size());
    }

    @Test
    public void testReadFile() {
        IOManager ioManager = new IOManager();
        List<OrderItem> itemList = ioManager.readOrder().getOrder();
        assertEquals(3, itemList.size());
    }
}
