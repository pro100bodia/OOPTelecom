package com.bod.entity;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ClientTest {
    Client client;

    @Before
    public void setUp() throws Exception {
        client = new Client("Fill", "super_pooper_simple");
    }

    @Test
    public void shouldMatchName() {
        assertEquals("Fill", client.getName());
    }

    @Test
    public void shouldMatchFareName() {
        assertEquals("super_pooper_simple", client.getFareId());
    }
}