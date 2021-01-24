import java.util.stream.Stream;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.Scanner;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

public class Main {

    //    private static int imgBundle;
//    private static int flacBundle;
//    private static int vidBundle;
//    private static Bundle ib1 = new Bundle("IMG", 5, 450);
//    private static Bundle ib2 = new Bundle("IMG", 10, 800);
//    private static Bundle ab1 = new Bundle("FLAC", 3, 427.5);
//    private static Bundle ab2 = new Bundle("FLAC", 6, 810);
//    private static Bundle ab3 = new Bundle("FLAC", 9, 1147.5);
//    private static Bundle vb1 = new Bundle("VID", 3, 570);
//    private static Bundle vb2 = new Bundle("VID", 5, 900);
//    private static Bundle vb3 = new Bundle("VID", 9, 1530);
    private static List<Bundle> bundles = new ArrayList<>();
    private static List<Order> orders = new ArrayList<>();
    private static Calculator calculator = new Calculator();
    private static IOManager ioManager = new IOManager();


    public static void main(String[] args) {
        println("Your Order Input:");
        ioManager.readOrder(orders);
        if (orders.size() != 0)
            for (int i = 0; i < orders.size(); i++) {
                System.out.println(orders.get(i).toString());
            }
        waitResult();
//        calculator.determineBundle(bundles, 15);

//        ioManager.readBundles(bundles);
//        for (Bundle bundle: bundles) {
//            System.out.println(bundle.toString());
//        }
//        for (int i = 0; i < bundles.size(); i++) {
//            System.out.println(bundles.get(i).toString());
//        }
//        calculator = new Calculator();
//        Integer[] img = new Integer[]{ib1.getVolume(), ib2.getVolume()};
//        Integer[] flac = new Integer[]{ab1.getVolume(), ab2.getVolume(), ab3.getVolume()};
//        Integer[] vid = new Integer[]{vb1.getVolume(), vb2.getVolume(), vb3.getVolume()};
//        takeInput();
//        println("");
//        println("Output:");
//        calculator.imgCalculator(img, imgBundle);
//        calculator.flacCalculator(flac, flacBundle);
//        calculator.vidCalculator(vid, vidBundle);
    }

    public static void print(String prompts) {
        System.out.print(prompts);
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
