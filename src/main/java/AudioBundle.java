public class AudioBundle extends Bundle {

    private final String bundleType;

    public AudioBundle(int bundleVolume, double bundlePrice) {
        super(bundleVolume, bundlePrice);
        this.bundleType = "FLAC";
    }

    public String getType() {
        return this.bundleType;
    }

    public String toString() {
        return "Bundle Type is " + bundleType + super.toString();
    }
}
