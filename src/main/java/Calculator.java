import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.Scanner;
import java.util.Collections;
import java.util.Collections;
import java.util.List;

public class Calculator {

    private static List<Bundle> bundles = new ArrayList<>();
    private static IOManager ioManager = new IOManager();

    public static void print(String prompts) {
        System.out.print(prompts);
    }

    public static void println(String prompts) {
        System.out.println(prompts);
    }

    public static void determineBundle(List<OrderItem> orders, List<Bundle> bundles) {
//        ioManager.readBundles(bundles);
//        ioManager.readOrder(orders);
        for (int i = 0; i < bundles.size(); i++) {
            for (int j = 1; j < bundles.size(); j++) {

            }
        }
        List<Bundle> filteredBundles = bundles
                .stream()
                .collect(Collectors.toList());
    }

    public static void start() {
        int bundles[] = {3, 5, 9};
        int target = 38;
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

    public static void filterBundle(List<Bundle> bundles) {
        List<Bundle> typeBundle = new ArrayList<>();
//        bundles.stream().filter(bundle -> bundle.getType().equals("IMG")).forEach(typeBundle::add);
    }

    public static void filterOrder() {
        ioManager.readOrders().stream().filter(order -> order.getType().equals("IMG"));
    }


}
