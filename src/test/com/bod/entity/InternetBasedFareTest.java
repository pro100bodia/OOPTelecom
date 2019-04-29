package com.bod.entity;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class InternetBasedFareTest {
    InternetBasedFare internetBasedFare;

    @Before
    public void setUp() throws Exception {
        internetBasedFare = new InternetBasedFare("super_internet",10000, 1000, 100, 10 );
    }

    @Test
    public void shouldMatchIntCalls() {
        assertEquals(10000, internetBasedFare.getIntCalls());
    }

    @Test
    public void shouldMatchExtCalls() {
        assertEquals(1000, internetBasedFare.getExtCalls());
    }

    @Test
    public void shouldMatchSmsAmount() {
        assertEquals(100, internetBasedFare.getSmsAmount());
    }

    @Test
    public void shouldMatchMegabytes() {
        assertEquals(10, internetBasedFare.getInternetMegabytes());
    }

    @Test
    public void shouldMatchFee() {
        assertThat(619.0, is(internetBasedFare.calculateFee()));
    }
}