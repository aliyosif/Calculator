public class OrderItem {

    private int target;
    private String type;

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

    public void setTarget(int theTarget) {
        this.target = theTarget;
    }

    public void setType(int theType) {
        this.target = theType;
    }

    public String toString() {
        return target + " " + type;
    }
}
