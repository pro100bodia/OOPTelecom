package com.bod.entity;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class PremiumBasedFareTest {
    PremiumBasedFare fare;

    @Before
    public void setUp() throws Exception {
        fare = new PremiumBasedFare("super_premium", 100000, 10000, 1000, 100, 10);
    }

    @Test
    public void calculateFee() {
        assertThat(3070.0, is(fare.calculateFee()));
    }

    @Test
    public void getInternetMegabytes() {
        assertEquals(100, fare.getInternetMegabytes());
    }

    @Test
    public void getTVchanels() {
        assertEquals(10, fare.getTVchanels());
    }
}