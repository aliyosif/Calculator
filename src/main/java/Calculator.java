import java.util.*;
import java.util.stream.Collectors;
import java.util.Collections;

public class Calculator {

    private static List<Bundle> bundles = new ArrayList<>();
    private static Bundle bundle = new Bundle();
    private static IOManager ioManager = new IOManager();
    private static List<OrderItem> orders = new ArrayList<>();
    private static Order order = new Order();

    public static void start(int target, List<Integer> bundleNum) {

        int[] bundles = bundle.convertBundle(bundleNum);
        target = 38;
        int bundle[] = new int[target + 1];
        int min = getMinCount(target, bundles, bundle);
        if (min > Integer.MAX_VALUE - target) {
            System.out.println("No suitable bundle found!!");
        } else {
            System.out.println("When the num is " + target + " ，the min coins required: " + min);
            for (int i = target; i > 0;) {
                System.out.print(bundle[i] + "\t");
                i = i - bundle[i];
            }
        }
    }

    public static int getMinCount(int target, int c[], int r[]) {
        int a[] = new int[target + 1];
        a[0] = 0;
        for (int i = 1; i < target + 1; i++) {
            if (i >= c[0]) {
                a[i] = a[i - c[0]] + 1;
                r[i] = c[0];
            } else {
                a[i] = Integer.MAX_VALUE - target;
            }
            for (int j = 1; j < c.length; j++) {
                if (i >= c[j] && (a[i] > a[i - c[j]] + 1)) {
                    a[i] = a[i - c[j]] + 1;
                    r[i] = c[j];
                }
            }
        }
        return a[target];
    }

    public static Map<Integer, int[]> mapBundleOrder(List<OrderItem> item) {

        Map<Integer, int[]> bundleOrder = new HashMap<>();

//        order.filterOrders()
        return bundleOrder;
    }

}
