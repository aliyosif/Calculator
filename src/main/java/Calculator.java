public class Calculator {

    public static void start(int target, String type, int[] bundles) {

        int bundle[] = new int[target + 1];
        int min = getMin(target, bundles, bundle);
        if (min > Integer.MAX_VALUE - target) {
            System.out.println("No suitable bundle found!!");
        } else {
                System.out.println(target + " " + type);
            for (int i = target; i > 0;) {
                System.out.println(bundle[i] + "\t");
                i = i - bundle[i];
            }
        }
    }

    public static int getMin(int target, int bundles[], int bundle[]) {

        int min[] = new int[target + 1];
        min[0] = 0;
        for (int i = 1; i < target + 1; i++) {
            if (i >= bundles[0]) {
                min[i] = min[i - bundles[0]] + 1;
                bundle[i] = bundles[0];
            } else {
                min[i] = Integer.MAX_VALUE - target;
            }
            for (int j = 1; j < bundles.length; j++) {
                if (i >= bundles[j] && (min[i] > min[i - bundles[j]] + 1)) {
                    min[i] = min[i - bundles[j]] + 1;
                    bundle[i] = bundles[j];
                }
            }
        }
        return min[target];
    }
}
