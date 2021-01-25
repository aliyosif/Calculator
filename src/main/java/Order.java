import java.util.*;

public class Order {

    private final Map<String, Integer> orderMap = new HashMap<>();
    private List<Integer> orderNum = new ArrayList<>();

    public Map<String, Integer> filterOrders(String type, List<OrderItem> orders) {
        switch (type) {
            case "IMG":
                for (OrderItem orderItem : orders) {
                    if (orderItem.getType().equalsIgnoreCase("IMG")) {
                        orderMap.put("IMG", orderItem.getTarget());
                    }
                }
                break;
            case "FLAC":
                for (OrderItem orderItem : orders) {
                    if (orderItem.getType().equalsIgnoreCase("FLAC")) {
                        orderMap.put("FLAC", orderItem.getTarget());
                    }
                }
                break;
            case "VID":
                for (OrderItem orderItem : orders) {
                    if (orderItem.getType().equalsIgnoreCase("VID")) {
                        orderMap.put("VID", orderItem.getTarget());
                    }
                }
                break;
            default:
                orderMap.put("No Format", 0);
                break;
        }
        return orderMap;
    }

    public List<Integer> getOrderNum(List<OrderItem> orders) {
        for (OrderItem item: orders) {
            orderNum.add(item.getTarget());
        }
        return orderNum;
    }
}
