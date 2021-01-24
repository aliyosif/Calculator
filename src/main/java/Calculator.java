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
//    private static Bundle ib1 = new Bundle("IMG", 5, 450);
//    private static Bundle ib2 = new Bundle("IMG", 10, 800);
//    private static Bundle ab1 = new Bundle("FLAC", 3, 427.5);
//    private static Bundle ab2 = new Bundle("FLAC", 6, 810);
//    private static Bundle ab3 = new Bundle("FLAC", 9, 1147.5);
//    private static Bundle vb1 = new Bundle("VID", 3, 570);
//    private static Bundle vb2 = new Bundle("VID", 5, 900);
//    private static Bundle vb3 = new Bundle("VID", 9, 1530);

    public static void print(String prompts) {
        System.out.print(prompts);
    }

    public static void println(String prompts) {
        System.out.println(prompts);
    }

    public static void determineBundle(List<OrderItem> orders, List<Bundle> bundles) {
//        ioManager.readBundles(bundles);
//        ioManager.readOrder(orders);
        for (int i=0; i < bundles.size(); i++) {
            for (int j = 1; j < bundles.size(); j++) {

            }
        }
        List<Bundle> filteredBundles = bundles
                .stream()
                .collect(Collectors.toList());
    }

    public static void filterBundle(List<Bundle> bundles) {
        List<Bundle> typeBundle = new ArrayList<>();
//        bundles.stream().filter(bundle -> bundle.getType().equals("IMG")).forEach(typeBundle::add);
    }

    public static void filterOrder() {
        ioManager.readOrders().stream().filter(order -> order.getType().equals("IMG"));
    }



}
