package com.bod.entity;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class TVBasedFareTest {
    TVBasedFare fare;

    @Before
    public void setUp() throws Exception {
        fare = new TVBasedFare("super_television", 10000, 1000, 100, 10);
    }

    @Test
    public void calculateFee() {
        assertThat(619.0, is(fare.calculateFee()));
    }

    @Test
    public void getTVchanels() {
        assertEquals(10, fare.getTVchanels());
    }
}