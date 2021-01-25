public class ImageBundle {

    private int bundleVolume;
    private double bundlePrice;

    public ImageBundle(int bundleVolume, double bundlePrice) {
        this.bundleVolume = bundleVolume;
        this.bundlePrice = bundlePrice;
    }

    public double getPrice() {
        return this.bundlePrice;
    }

    public int getVolume() {
        return this.bundleVolume;
    }

    public String toString() {
        return "This IMG Bundle's Volume is " + bundleVolume
                + ", and Bundle Price is " + bundlePrice;
    }
}
