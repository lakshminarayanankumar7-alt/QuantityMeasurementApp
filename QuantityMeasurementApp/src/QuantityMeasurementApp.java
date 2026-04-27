public class QuantityMeasurementApp {

    // Inner class representing Feet measurement
    static class Feet {
        private final double value;

        // Constructor
        public Feet(double value) {
            this.value = value;
        }

        public double getValue() {
            return value;
        }

        @Override
        public boolean equals(Object obj) {
            // Same reference
            if (this == obj) return true;

            // Null or different type
            if (obj == null || getClass() != obj.getClass()) return false;

            // Cast and compare
            Feet other = (Feet) obj;
            return Double.compare(this.value, other.value) == 0;
        }

        @Override
        public int hashCode() {
            return Double.hashCode(value);
        }
    }

    // Main method with all test cases
    public static void main(String[] args) {

        Feet f1 = new Feet(1.0);
        Feet f2 = new Feet(1.0);
        Feet f3 = new Feet(2.0);

        // Test: Same value
        System.out.println("Test Same Value: " + f1.equals(f2)); // true

        // Test: Different value
        System.out.println("Test Different Value: " + f1.equals(f3)); // false

        // Test: Null comparison
        System.out.println("Test Null Comparison: " + f1.equals(null)); // false

        // Test: Same reference
        System.out.println("Test Same Reference: " + f1.equals(f1)); // true

        // Test: Non-numeric input
        System.out.println("Test Non-Numeric Input: " + f1.equals("abc")); // false

        // Example output
        System.out.println("\nExample:");
        System.out.println("Input: 1.0 ft and 1.0 ft");
        System.out.println("Output: Equal (" + f1.equals(f2) + ")");
    }
}