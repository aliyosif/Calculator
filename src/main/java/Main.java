import java.util.stream.Stream;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.Scanner;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

public class Main {

    private static int imgBundle;
    private static int flacBundle;
    private static int vidBundle;
    private static Bundle ib1 = new ImageBundle("IMG", 5, 450);
    private static Bundle ib2 = new ImageBundle("IMG", 10, 800);
    private static Bundle ab1 = new AudioBundle("FLAC", 3, 427.5);
    private static Bundle ab2 = new AudioBundle("FLAC", 6, 810);
    private static Bundle ab3 = new AudioBundle("FLAC", 9, 1147.5);
    private static Bundle vb1 = new VideoBundle("VID", 3, 570);
    private static Bundle vb2 = new VideoBundle("VID", 5, 900);
    private static Bundle vb3 = new VideoBundle("VID", 9, 1530);
    private static Calculator calculator;
    private static InputOutput inputOutput = new InputOutput();

    public static void main(String[] args) {
        calculator = new Calculator();
        Integer[] img = new Integer[]{ib1.getVolume(), ib2.getVolume()};
        Integer[] flac = new Integer[]{ab1.getVolume(), ab2.getVolume(), ab3.getVolume()};
        Integer[] vid = new Integer[]{vb1.getVolume(), vb2.getVolume(), vb3.getVolume()};
        takeInput();
        inputOutput.println("");
        inputOutput.println("Output:");
        calculator.imgCalculator(img, imgBundle);
        calculator.flacCalculator(flac, flacBundle);
        calculator.vidCalculator(vid, vidBundle);
    }

    private static void takeInput() {
        Scanner input = new Scanner(System.in);
        inputOutput.print("Please enter the number of Image format for the order: ");
        imgBundle = input.nextInt();
        inputOutput.print("Please enter the number of Audio format for the order: ");
        flacBundle = input.nextInt();
        inputOutput.print("Please enter the number of Video format for the order: ");
        vidBundle = input.nextInt();
        inputOutput.println("Your Order Input:");
        System.out.println(imgBundle + " IMG");
        System.out.println(flacBundle + " FLAC");
        System.out.println(vidBundle + " VID");
        inputOutput.println("");
        inputOutput.println("Calculating...Please wait...");
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException ie) {
            Thread.currentThread().interrupt();
        }
    }
}
