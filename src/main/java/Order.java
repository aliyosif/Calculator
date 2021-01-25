import java.util.*;

public class Order {

    private final Map<String, Integer> orderMap = new HashMap<>();
    private List<Map<String, Integer>> mapsList = new ArrayList<>();

    public Map<String, Integer> mapOrder(List<OrderItem> orders) {
        for (int i = 0; i < orders.size(); i++) {
            orderMap.put(orders.get(i).getType(), orders.get(i).getTarget());
        }
        return orderMap;
    }

    public List<Map<String, Integer>> listMaps(List<OrderItem> orders) {
        for (int i = 0; i < orders.size(); i++) {
            orderMap.put(orders.get(i).getType(), orders.get(i).getTarget());
            mapsList.add(orderMap);
        }
        return mapsList;
    }
}
