import java.util.*;

public class Order {

    private final Map<Integer, String> order = new HashMap<>();

    public Map<Integer, String> filterOrders(String type, List<OrderItem> orders) {
        switch (type) {
            case "IMG":
                for (OrderItem orderItem : orders) {
                    if (orderItem.getType().equalsIgnoreCase("IMG")) {
                        order.put(orderItem.getTarget(), "IMG");
                    }
                }
                break;
            case "FLAC":
                for (OrderItem orderItem : orders) {
                    if (orderItem.getType().equalsIgnoreCase("FLAC")) {
                        order.put(orderItem.getTarget(), "FLAC");
                    }
                }
                break;
            case "VID":
                for (OrderItem orderItem : orders) {
                    if (orderItem.getType().equalsIgnoreCase("VID")) {
                        order.put(orderItem.getTarget(), "VID");
                    }
                }
                break;
            default:
                order.put(1, "No Format");
                break;
        }
        return order;
    }
}
