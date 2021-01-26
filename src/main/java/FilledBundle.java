import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FilledBundle {

    private Bundle bundle = new Bundle();

    public List<Integer> determineBundle(String type, Map<Integer, Double> bundleMap) {
        List<Integer> bundleNum;
        switch (type) {
            case "IMG":
                bundleMap = bundle.filterBundle("IMG");
                bundleNum = new ArrayList<>(bundleMap.keySet());
                break;
            case "FLAC":
                bundleMap = bundle.filterBundle("FLAC");
                bundleNum = new ArrayList<>(bundleMap.keySet());
                break;
            case "VID":
                bundleMap = bundle.filterBundle("VID");
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
}
