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
        for (OrderItem item: orders) {
            int target = order.mapOrder(orders).get(item.getType());
            int[] bundleNum = new int[target + 1];
            bundles = bundle.convertBundle(bundle.determineBundle(item.getType(), bundle.filterBundle(item.getType())));
            calculator.getMin(target, bundles, bundleNum);
            calculator.start(target, item.getType(), bundles);
        }
//        int target = order.mapOrder(orders).get("FLAC");
//        int[] bundleNum = new int[target + 1];
//        bundles = filledBundle.convertBundle(filledBundle.determineBundle("FLAC", bundle.filterBundle("FLAC")));
//        calculator.getMin(target, bundles, bundleNum);
//        calculator.start(target, "FLAC", bundles);
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

    //    public static void writeResult() {
//        try {
//            PrintWriter outputFile = new PrintWriter("result.txt");
//            outputFile.close();
//        } catch (IOException exception) {
//            System.out.println("Unexpected I/O error occurred.");
//        }
//    }
}
