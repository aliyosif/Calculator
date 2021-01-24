public class OrderItem {

    private final int target;
    private final String type;

    public OrderItem(int target, String type) {
        this.target = target;
        this.type = type;
    }

    public int getTarget() {
        return this.target;
    }

    public String getType() {
        return this.type;
    }

    public String toString() {
        return target + " " + type;
    }
}
