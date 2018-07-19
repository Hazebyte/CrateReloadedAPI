package com.hazebyte.crate.api.util;

public class Range {

    private double min;
    private double max;

    public Range() {
        set(0, 0);
    }

    public Range(double min, double max) {
        this.min = min;
        this.max = max;
        verify();
    }

    public void set(double min, double max) {
        this.min = min;
        this.max = max;
        verify();
    }

    public double getMin() {
        return min;
    }

    public double getMax() {
        return max;
    }

    private void verify() {
        if (min > max) {
            min = max;
        }
    }
}
