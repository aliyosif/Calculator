public class Bundle {
    private String bundleType;
    private int bundleVolume;
    private double bundlePrice;

    public Bundle(String bundleType, int bundleVolume, double bundlePrice) {
        this.bundleType = bundleType;
        this.bundleVolume = bundleVolume;
        this.bundlePrice = bundlePrice;
    }

    public String getType() {
        return this.bundleType;
    }

    public double getPrice() {
        return this.bundlePrice;
    }

    public int getVolume() {
        return this.bundleVolume;
    }

    public void setType(String type) {
        this.bundleType = type;
    }

    public void setPrice(double price) {
        this.bundlePrice = price;
    }

    public void setVolume(int volume) {
        this.bundleVolume = volume;
    }
}
