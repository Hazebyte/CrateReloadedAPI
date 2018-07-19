package com.hazebyte.crate.api.util;

import org.junit.Test;

import static org.junit.Assert.*;

public class RangeTest {

    private double min = 0;
    private double max = 20;

    @Test
    public void simple() {
        Range range = new Range(min, max);
        assertEquals("min is 0", range.getMin(), min, 0.01);
        assertEquals("max is 20", range.getMax(), max, 0.01);
    }

    @Test
    public void minGreaterThanMax() {
        double min = 21;
        Range range = new Range(min, max);
        assertEquals("min should be 20", range.getMin(), 20.0, 0.01);
        assertEquals("max should be 20", range.getMax(), 20.0, 0.01);
    }

    @Test
    public void maxLessThanMin() {
        double max = -5;
        Range range = new Range(min, max);
        assertEquals("min should be -5", range.getMin(), -5.0, 0.01);
        assertEquals("max should be -5", range.getMax(), -5.0, 0.01);
    }
}