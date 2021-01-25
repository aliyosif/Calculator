import java.util.*;

public class Order {

    private final Map<Integer, String> orderMap = new HashMap<>();
    private List<Integer> orderNum = new ArrayList<>();

    public Map<Integer, String> filterOrders(String type, List<OrderItem> orders) {
        switch (type) {
            case "IMG":
                for (OrderItem orderItem : orders) {
                    if (orderItem.getType().equalsIgnoreCase("IMG")) {
                        orderMap.put(orderItem.getTarget(), "IMG");
                    }
                }
                break;
            case "FLAC":
                for (OrderItem orderItem : orders) {
                    if (orderItem.getType().equalsIgnoreCase("FLAC")) {
                        orderMap.put(orderItem.getTarget(), "FLAC");
                    }
                }
                break;
            case "VID":
                for (OrderItem orderItem : orders) {
                    if (orderItem.getType().equalsIgnoreCase("VID")) {
                        orderMap.put(orderItem.getTarget(), "VID");
                    }
                }
                break;
            default:
                orderMap.put(1, "No Format");
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
