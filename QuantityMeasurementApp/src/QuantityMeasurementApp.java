public class QuantityMeasurementApp {

    // Feet class
    static class Feet {
        private final double value;

        public Feet(double value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;

            Feet other = (Feet) obj;
            return Double.compare(this.value, other.value) == 0;
        }

        @Override
        public int hashCode() {
            return Double.hashCode(value);
        }
    }

    // Inches class
    static class Inches {
        private final double value;

        public Inches(double value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;

            Inches other = (Inches) obj;
            return Double.compare(this.value, other.value) == 0;
        }

        @Override
        public int hashCode() {
            return Double.hashCode(value);
        }
    }

    // Static method for Feet equality
    public static boolean checkFeetEquality(double v1, double v2) {
        Feet f1 = new Feet(v1);
        Feet f2 = new Feet(v2);
        return f1.equals(f2);
    }

    // Static method for Inches equality
    public static boolean checkInchesEquality(double v1, double v2) {
        Inches i1 = new Inches(v1);
        Inches i2 = new Inches(v2);
        return i1.equals(i2);
    }

    // Main method (acts as test runner)
    public static void main(String[] args) {

        // --- Feet Tests ---
        System.out.println("Feet Tests:");
        System.out.println("Same Value: " + checkFeetEquality(1.0, 1.0)); // true
        System.out.println("Different Value: " + checkFeetEquality(1.0, 2.0)); // false

        Feet f = new Feet(1.0);
        System.out.println("Null Comparison: " + f.equals(null)); // false
        System.out.println("Same Reference: " + f.equals(f)); // true
        System.out.println("Non-Numeric Input: " + f.equals("abc")); // false

        // --- Inches Tests ---
        System.out.println("\nInches Tests:");
        System.out.println("Same Value: " + checkInchesEquality(1.0, 1.0)); // true
        System.out.println("Different Value: " + checkInchesEquality(1.0, 2.0)); // false

        Inches i = new Inches(1.0);
        System.out.println("Null Comparison: " + i.equals(null)); // false
        System.out.println("Same Reference: " + i.equals(i)); // true
        System.out.println("Non-Numeric Input: " + i.equals("xyz")); // false

        // --- Example Output ---
        System.out.println("\nExample Output:");
        System.out.println("Input: 1.0 inch and 1.0 inch");
        System.out.println("Output: Equal (" + checkInchesEquality(1.0, 1.0) + ")");

        System.out.println("Input: 1.0 ft and 1.0 ft");
        System.out.println("Output: Equal (" + checkFeetEquality(1.0, 1.0) + ")");
    }
}