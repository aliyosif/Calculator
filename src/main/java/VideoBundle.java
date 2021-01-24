public class VideoBundle extends Bundle {

    private final String bundleType;

    public VideoBundle(int bundleVolume, double bundlePrice) {
        super(bundleVolume, bundlePrice);
        this.bundleType = "VID";
    }

    public String getType() {
        return this.bundleType;
    }

    public String toString() {
        return "Bundle Type is " + bundleType + super.toString();
    }
}
