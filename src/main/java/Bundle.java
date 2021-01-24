public class Bundle {

    private int bundleVolume;
    private double bundlePrice;

    public Bundle(int bundleVolume, double bundlePrice) {
        this.bundleVolume = bundleVolume;
        this.bundlePrice = bundlePrice;
    }

    public double getPrice() {
        return this.bundlePrice;
    }

    public int getVolume() {
        return this.bundleVolume;
    }

    public void setPrice(double price) {
        this.bundlePrice = price;
    }

    public void setVolume(int volume) {
        this.bundleVolume = volume;
    }

    public String toString() {
        return "Bundle Volume is " + bundleVolume
                + ", and Bundle Price is " + bundlePrice;
    }
}
