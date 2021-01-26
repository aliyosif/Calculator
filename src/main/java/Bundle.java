import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Bundle {

    private final Map<Integer, Double> bundle = new HashMap<>();

    public Map<Integer, Double> filterBundle(String type) {
        switch (type) {
            case "IMG":
                bundle.put(5, 450.00);
                bundle.put(10, 800.00);
                break;
            case "FLAC":
                bundle.put(3, 427.50);
                bundle.put(6, 810.00);
                bundle.put(9, 1147.50);
                break;
            case "VID":
                bundle.put(3, 570.00);
                bundle.put(5, 900.00);
                bundle.put(9, 1530.00);
                break;
            default:
                bundle.put(0,0.0);
                break;
        }
        return bundle;
    }
}
