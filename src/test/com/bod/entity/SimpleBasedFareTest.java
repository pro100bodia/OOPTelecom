package com.bod.entity;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class SimpleBasedFareTest {
    Fare fare;

    @Before
    public void setUp() throws Exception {
        fare = new SimpleBasedFare("super_simple", 1000, 100, 10);
    }

    @Test
    public void calculateFee() {
        assertThat(123.0, is(fare.calculateFee()));
    }
}
