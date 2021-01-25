import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Bundle {

    private final int bundleVolume;
    private final double bundlePrice;
    private final Map<Integer, Double> imgBundle = new HashMap<>();
    private final Map<Integer, Double> flacBundle = new HashMap<>();
    private final Map<Integer, Double> vidBundle = new HashMap<>();

    public Bundle(int bundleVolume, double bundlePrice) {
        this.bundleVolume = bundleVolume;
        this.bundlePrice = bundlePrice;
    }

    public Map<Integer, Double> filterAudioBundle() {
        imgBundle.put(5, 450.00);
        imgBundle.put(10, 800.00);
        return imgBundle;
    }

    public Map<Integer, Double> filterImageBundle() {
        flacBundle.put(3, 427.50);
        flacBundle.put(6, 810.00);
        flacBundle.put(9, 1147.50);
        return flacBundle;
    }

    public Map<Integer, Double> filterVideoBundle() {
        vidBundle.put(3, 570.0);
        vidBundle.put(5, 900.0);
        vidBundle.put(9, 1530.00);
        return vidBundle;
    }

    public double getPrice() {
        return this.bundlePrice;
    }

    public int getVolume() {
        return this.bundleVolume;
    }

    public String toString() {
        return "Bundle Volume is " + bundleVolume
                + ", and Bundle Price is " + bundlePrice;
    }
}
