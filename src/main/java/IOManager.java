import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.*;

public class IOManager {

    public static void readBundles(List<Bundle> bundles) {
        try {
            FileReader inputFile = new FileReader("src/main/resources/bundle.txt");
            Scanner parser = new Scanner(inputFile);
            while (parser.hasNextLine()) {
                String file = parser.nextLine();
                String[] parts = file.split(", ");
                String bundleType = parts[0];
                String bundleVol = parts[1];
                String bundlePrice = parts[2];
                int volume = Integer.parseInt(bundleVol);
                double price = Double.parseDouble(bundlePrice);
                bundles.add(new Bundle(bundleType, volume, price));
            }
            inputFile.close();
        } catch (FileNotFoundException exception) {
            System.out.println("bundle.txt not found");
        } catch (IOException exception) {
            System.out.println("Unexpected I/O error occurred.");
        }
    }

    public static void readOrder(List<Order> orders) {
        try {
            FileReader inputFile = new FileReader("src/main/resources/order.txt");
            Scanner parser = new Scanner(inputFile);
            while (parser.hasNextLine()) {
                String order = parser.nextLine();
                String[] parts = order.split(" ");
                String bundleNum = parts[0];
                String bundleType = parts[1];
                int target = Integer.parseInt(bundleNum);
                orders.add(new Order(target, bundleType));
//                System.out.println(order);
            }
            inputFile.close();
        } catch (FileNotFoundException exception) {
            System.out.println("bundle.txt not found");
        } catch (IOException exception) {
            System.out.println("Unexpected I/O error occurred.");
        }
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
