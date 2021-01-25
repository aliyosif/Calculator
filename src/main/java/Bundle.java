import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Bundle {

    private final Map<Integer, Double> imgBundle = new HashMap<>();
    private final Map<Integer, Double> flacBundle = new HashMap<>();
    private final Map<Integer, Double> vidBundle = new HashMap<>();
    private final Map<String, int[]> mapBundle = new HashMap<>();

    public List<Integer> determineBundle(String type, Map<Integer, Double> bundleMap) {
        List<Integer> bundleNum;
        switch (type) {
            case "IMG":
                bundleMap = filterImageBundle();
                bundleNum = new ArrayList<>(bundleMap.keySet());
                break;
            case "FLAC":
                bundleMap = filterAudioBundle();
                bundleNum = new ArrayList<>(bundleMap.keySet());
                break;
            case "VID":
                bundleMap = filterVideoBundle();
                bundleNum = new ArrayList<>(bundleMap.keySet());
                break;
            default:
                bundleNum = new ArrayList<>();
                break;
        }
        return bundleNum;
    }

    public int[] convertBundle(List<Integer> bundleList) {
        int[] bundleArray = new int[bundleList.size()];
        for (int i = 0; i < bundleList.size(); i++) {
            bundleArray[i] = bundleList.get(i);
        }
        return bundleArray;
    }

    public Map<String, int[]> mapBundle() {
        return mapBundle;
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
}
