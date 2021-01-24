import java.util.stream.Stream;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.Scanner;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

public class Main {

    private static List<Bundle> bundles = new ArrayList<>();
    private static List<OrderItem> orders = new ArrayList<>();
    private static Calculator calculator = new Calculator();
    private static IOManager ioManager = new IOManager();


    public static void main(String[] args) {

        if (ioManager.readOrders().size() != 0)
            for (int i = 0; i < ioManager.readOrders().size(); i++) {
                System.out.println(ioManager.readOrders().get(i).toString());
            }
        waitResult();
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
