import java.util.stream.Stream;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.Scanner;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

public class Main {

//    private static List<Bundle> bundles = new ArrayList<>();
    private static List<OrderItem> orders = new ArrayList<>();
    private static Order order = new Order();
    private static OrderItem orderItem = new OrderItem(0, " ");
    private static Bundle bundle = new Bundle();
    private static int[] bundleNum;
    private static Calculator calculator = new Calculator();
    private static IOManager ioManager = new IOManager();


    public static void main(String[] args) {
//        calculator.start();


//        bundleNum = bundle.convertBundle(bundle.determineBundle("IMG", bundle.filterImageBundle()));
//        System.out.println(Arrays.toString(bundleNum));
//        for (Integer in: bundleNum) {
//            System.out.println(in + " ");
//        }
//        for (int i = 0; i < bundleNum.size(); i++) {
//            System.out.println(bundleNum.get(i) + " ");
//        }

        orders = ioManager.readOrders();
//        if (orders.size() != 0)
//            for (int i = 0; i < orders.size(); i++) {
//                System.out.println(orders.get(i).toString());
//            }
        order.mapOrder(orders).forEach((key, value) -> System.out.println(key + " : " + value));
//        for (Integer number: order.getOrderNum(orders)) {
//            System.out.println(number + " ");
//        }
//        waitResult();

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

    //    public static void writeStudents() {
//        try {
//            PrintWriter outputFile = new PrintWriter("result.txt");
//            outputFile.close();
//        } catch (IOException exception) {
//            System.out.println("Unexpected I/O error occurred.");
//        }
//    }
}
