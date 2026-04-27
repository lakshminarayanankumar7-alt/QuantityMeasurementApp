package com.apps.quantitymeasurement;

public class QuantityMeasurementApp {

    // Instance variables
    private double value;
    private LengthUnit unit;

    // Enum with conversion factors (base unit = inches)
    public enum LengthUnit {
        FEET(12.0),            // 1 foot = 12 inches
        INCHES(1.0),           // base unit
        YARDS(36.0),           // 1 yard = 36 inches
        CENTIMETERS(0.393701); // 1 cm = 0.393701 inches

        private final double conversionFactor;

        LengthUnit(double conversionFactor) {
            this.conversionFactor = conversionFactor;
        }

        public double getConversionFactor() {
            return conversionFactor;
        }
    }

    // Constructor
    public QuantityMeasurementApp(double value, LengthUnit unit) {
        if (unit == null) {
            throw new IllegalArgumentException("Unit cannot be null");
        }
        this.value = value;
        this.unit = unit;
    }

    // Convert to base unit (inches)
    private double convertToBaseUnit() {
        return Math.round(value * unit.getConversionFactor() * 100000.0) / 100000.0;
    }

    // Compare method
    public boolean compare(QuantityMeasurementApp that) {
        if (that == null) return false;
        return Double.compare(this.convertToBaseUnit(), that.convertToBaseUnit()) == 0;
    }

    // Override equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof QuantityMeasurementApp)) return false;
        QuantityMeasurementApp that = (QuantityMeasurementApp) o;
        return this.compare(that);
    }

    // Main method for testing
    public static void main(String[] args) {

        QuantityMeasurementApp q1 = new QuantityMeasurementApp(1.0, LengthUnit.FEET);
        QuantityMeasurementApp q2 = new QuantityMeasurementApp(12.0, LengthUnit.INCHES);
        System.out.println("Feet vs Inches: " + q1.equals(q2)); // true

        QuantityMeasurementApp q3 = new QuantityMeasurementApp(1.0, LengthUnit.YARDS);
        QuantityMeasurementApp q4 = new QuantityMeasurementApp(3.0, LengthUnit.FEET);
        System.out.println("Yards vs Feet: " + q3.equals(q4)); // true

        QuantityMeasurementApp q5 = new QuantityMeasurementApp(1.0, LengthUnit.YARDS);
        QuantityMeasurementApp q6 = new QuantityMeasurementApp(36.0, LengthUnit.INCHES);
        System.out.println("Yards vs Inches: " + q5.equals(q6)); // true

        QuantityMeasurementApp q7 = new QuantityMeasurementApp(100.0, LengthUnit.CENTIMETERS);
        QuantityMeasurementApp q8 = new QuantityMeasurementApp(39.3701, LengthUnit.INCHES);
        System.out.println("CM vs Inches: " + q7.equals(q8)); // true

        QuantityMeasurementApp q9 = new QuantityMeasurementApp(2.0, LengthUnit.YARDS);
        QuantityMeasurementApp q10 = new QuantityMeasurementApp(72.0, LengthUnit.INCHES);
        System.out.println("Multi-unit check: " + q9.equals(q10)); // true

        QuantityMeasurementApp q11 = new QuantityMeasurementApp(1.0, LengthUnit.CENTIMETERS);
        QuantityMeasurementApp q12 = new QuantityMeasurementApp(1.0, LengthUnit.FEET);
        System.out.println("CM vs Feet (not equal): " + q11.equals(q12)); // false
    }
}