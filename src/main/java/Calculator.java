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
    private static Bundle ib1 = new Bundle("IMG", 5, 450);
    private static Bundle ib2 = new Bundle("IMG", 10, 800);
    private static Bundle ab1 = new Bundle("FLAC", 3, 427.5);
    private static Bundle ab2 = new Bundle("FLAC", 6, 810);
    private static Bundle ab3 = new Bundle("FLAC", 9, 1147.5);
    private static Bundle vb1 = new Bundle("VID", 3, 570);
    private static Bundle vb2 = new Bundle("VID", 5, 900);
    private static Bundle vb3 = new Bundle("VID", 9, 1530);

    public static void print(String prompts) {
        System.out.print(prompts);
    }

    public static void println(String prompts) {
        System.out.println(prompts);
    }

    public static void determineBundle(List<Bundle> bundles) {

    }

    public static void flacCalculator(Integer[] bundle, int target) {
        // ArrayList<Integer> result = new ArrayList<Integer>();
        Arrays.sort(bundle, Collections.reverseOrder());
        double result;
        int tmpBundle;
        int remain;
        int bundleNum1 = 0;
        int bundleNum2 = 0;
        int bundleNum3 = 0;
        tmpBundle = (int) (target / bundle[0]);
        remain = target % bundle[0];

        if (target == 0) {
            println("No bundle order input!!");
        }
        if (remain == 0) {  // Only have 9-Bundle
            bundleNum1 = tmpBundle;
            result = bundleNum1 * ab3.getPrice();
            System.out.println(target + " FLAC $" + result);
            System.out.println(bundleNum1 + " x " + bundle[0] + " $" + result);
        } else {
            if (tmpBundle == 0) {   // No 9-Bundle
                bundleNum1 = 0;
                if (target == bundle[1]) {
                    bundleNum2 = 1;
                    result = bundleNum2 * ab2.getPrice();
                    System.out.println(target + " FLAC $" + result);
                    System.out.println(bundleNum2 + " x " + bundle[1] + " $" + result);
                } else if (target == bundle[2]) {
                    bundleNum3 = 1;
                    result = bundleNum3 * ab1.getPrice();
                    System.out.println(target + " FLAC $" + result);
                    System.out.println(bundleNum3 + " x " + bundle[2] + " $" + result);
                } else {
                    println("No bundle order could be made!!");
                }
            } else {    // has 9-Bundle
                bundleNum1 = tmpBundle;
                bundleNum2 = (int) (remain / bundle[1]);
                remain = remain % bundle[1];
                if (remain == 0) {  // A combination of 9-Bundle and 6-Bundle
                    result = bundleNum1 * ab3.getPrice() + bundleNum2 * ab2.getPrice();
                    System.out.println(target + " FLAC $" + result);
                    System.out.println(bundleNum1 + " x " + bundle[0] + " $" + ab3.getPrice());
                    System.out.println(bundleNum2 + " x " + bundle[1] + " $" + ab2.getPrice());
                } else {    // May have 6-Bundle
                    if (bundleNum2 == 0) {
                        remain = target - bundleNum1 * bundle[0];
                        if (remain == bundle[2]) {  // A combination of 9-Bundle and 3-Bundle
                            bundleNum3 = remain;
                            result = bundleNum1 * ab3.getPrice() + bundleNum3 * ab1.getPrice();
                            System.out.println(target + " FLAC $" + result);
                            System.out.println(bundleNum1 + " x " + bundle[0] + " $" + ab3.getPrice());
                            System.out.println(bundleNum3 + " x " + bundle[2] + " $" + ab1.getPrice());
                        } else {
                            println("No bundle order could be made!!");
                        }
                    } else {    // Has 9-Bundle and 6-Bundle
                        remain = target - bundleNum1 * bundle[0] - bundleNum2 * bundle[1];
                        if (remain % bundle[2] == 0) {  // A combination of 9-Bundle and 3-Bundle
                            bundleNum3 = (int) (remain / bundle[2]);
                            result = bundleNum1 * ab3.getPrice() + bundleNum2 * ab2.getPrice() + bundleNum3 * ab1.getPrice();
                            System.out.println(target + " FLAC $" + result);
                            System.out.println(bundleNum1 + " x " + bundle[0] + " $" + ab3.getPrice());
                            System.out.println(bundleNum2 + " x " + bundle[1] + " $" + ab2.getPrice());
                            System.out.println(bundleNum3 + " x " + bundle[2] + " $" + ab1.getPrice());
                        } else {
                            println("No bundle order could be made!!");
                        }
                    }
                }
            }
        }
    }

    // IMG
    public static void imgCalculator(Integer[] bundle, int target) {
        // ArrayList<Integer> result = new ArrayList<Integer>();
        Arrays.sort(bundle, Collections.reverseOrder());
        double result;
        int remain;
        int bundleNum1 = 0;
        int bundleNum2 = 0;

        bundleNum1 = (int) (target / bundle[0]);
        remain = target % bundle[0];
        if (target == 0) {
            println("No bundle order input!!");
        }
        if (bundleNum1 == 0) {
            if (remain == 0) {
                println("No bundle order input could be found!!");
            } else if (remain % bundle[1] == 0) {
                bundleNum2 = (int) (remain / bundle[1]);
                result = bundleNum2 * ib1.getPrice();
                System.out.println(target + " IMG $" + result);
                System.out.println(bundleNum2 + " x " + bundle[1] + " $" + ib1.getPrice());
            } else {
                println("No bundle order could be made!!");
            }
        } else {
            if (remain == 0) {
                result = bundleNum1 * ib2.getPrice();
                System.out.println(target + " IMG $" + result);
                System.out.println(bundleNum1 + " x " + bundle[0] + " $" + ib2.getPrice());
            } else if (remain % bundle[1] == 0) {
                bundleNum2 = (int) (remain / bundle[1]);
                result = bundleNum1 * ib2.getPrice() + bundleNum2 * ib1.getPrice();
                System.out.println(target + " IMG $" + result);
                System.out.println(bundleNum1 + " x " + bundle[0] + " $" + bundleNum1 * ib2.getPrice());
                System.out.println(bundleNum2 + " x " + bundle[1] + " $" + ib1.getPrice());
            } else {
                println("No bundle order could be made!!");
            }
        }
    }

    public static void vidCalculator(Integer[] bundle, int target) {
        // ArrayList<Integer> result = new ArrayList<Integer>();
        Arrays.sort(bundle, Collections.reverseOrder());
        double result;
        int tmpBundle;
        int remain;
        int bundleNum1 = 0;
        int bundleNum2 = 0;
        int bundleNum3 = 0;
        tmpBundle = (int) (target / bundle[0]);
        remain = target % bundle[0];

        if (target == 0) {
            println("No bundle order input!!");
        }
        if (remain == 0) {  // Only have 9-Bundle
            bundleNum1 = tmpBundle;
            result = bundleNum1 * vb3.getPrice();
            System.out.println(target + " FLAC $" + result);
            System.out.println(bundleNum1 + " x " + bundle[0] + " $" + result);
        } else {
            if (tmpBundle == 0) {   // No 9-Bundle
                bundleNum1 = 0;
                tmpBundle = (int) (target / bundle[1]);
                remain = target - bundle[1];
                if (remain == bundle[2]) {  // A combination of 5-Bundle and 3-Bundle
                    bundleNum2 = 1;
                    bundleNum3 = 1;
                    result = bundleNum2 * vb2.getPrice() + bundleNum3 * vb1.getPrice();
                    System.out.println(target + " FLAC $" + result);
                    System.out.println(bundleNum2 + " x " + bundle[1] + " $" + vb2.getPrice());
                    System.out.println(bundleNum3 + " x " + bundle[2] + " $" + vb1.getPrice());
                } else if (remain == 0) {   // Only 5-Bundle
                    bundleNum2 = 1;
                    result = bundleNum2 * vb2.getPrice();
                    System.out.println(target + " FLAC $" + result);
                    System.out.println(bundleNum2 + " x " + bundle[1] + " $" + result);
                } else if (target % bundle[2] == 0) {
                    bundleNum3 = (int) (target / bundle[2]);
                    result = bundleNum3 * vb1.getPrice();
                    System.out.println(target + " FLAC $" + result);
                    System.out.println(bundleNum3 + " x " + bundle[2] + " $" + result);
                } else {
                    println("No bundle order could be made!!");
                }
            } else {    // has 9-Bundle
                bundleNum1 = tmpBundle;
                bundleNum2 = (int) (remain / bundle[1]);
                remain = remain % bundle[1];
                if (remain == 0) {  // A combination of 9-Bundle and 5-Bundle
                    result = bundleNum1 * vb3.getPrice() + bundleNum2 * vb2.getPrice();
                    System.out.println(target + " FLAC $" + result);
                    System.out.println(bundleNum1 + " x " + bundle[0] + " $" + vb3.getPrice());
                    System.out.println(bundleNum2 + " x " + bundle[1] + " $" + vb2.getPrice());
                } else {    // May have 6-Bundle
                    if (bundleNum2 == 0) {
                        remain = target - bundleNum1 * bundle[0];
                        if (remain == bundle[2]) {  // A combination of 9-Bundle and 3-Bundle
                            bundleNum3 = 1;
                            result = bundleNum1 * vb3.getPrice() + bundleNum3 * vb1.getPrice();
                            System.out.println(target + " FLAC $" + result);
                            System.out.println(bundleNum1 + " x " + bundle[0] + " $" + vb3.getPrice());
                            System.out.println(bundleNum3 + " x " + bundle[2] + " $" + vb1.getPrice());
                        } else {
                            println("No bundle order could be made!!");
                        }
                    } else {    // Has 9-Bundle and 5-Bundle
                        remain = target - bundleNum1 * bundle[0] - bundleNum2 * bundle[1];
                        if (remain % bundle[2] == 0) {  // A combination of all types of bundle
                            bundleNum3 = (int) (remain / bundle[2]);
                            result = bundleNum1 * vb3.getPrice() + bundleNum2 * vb2.getPrice() + bundleNum3 * vb1.getPrice();
                            System.out.println(target + " FLAC $" + result);
                            System.out.println(bundleNum1 + " x " + bundle[0] + " $" + vb3.getPrice());
                            System.out.println(bundleNum2 + " x " + bundle[1] + " $" + vb2.getPrice());
                            System.out.println(bundleNum3 + " x " + bundle[2] + " $" + vb1.getPrice());
                        } else {
                            println("No bundle order could be made!!");
                        }
                    }
                }
            }
        }
    }
}
