public class ImageBundle extends Bundle {

    private final String bundleType;

    public ImageBundle(int bundleVolume, double bundlePrice) {
        super(bundleVolume, bundlePrice);
        this.bundleType = "IMG";
    }

    public String getType() {
        return this.bundleType;
    }

    public String toString() {
        return "Bundle Type is " + bundleType + super.toString();
    }
}
