package com.bod.actions;

import com.bod.entity.Fare;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

public class ActionTest {
    Action action;

    @Before
    public void setUp() throws Exception {
        action = new Action();
        action.init();
    }

    @Test
    public void shouldNotReturnNullFaresList() {
        assertNotNull(action.getFaresList());
    }

    @Test
    public void shouldNotReturnNullClinetsList() {
        assertNotNull(action.getClientsList());
    }

    @Test
    public void shouldNotReturnNullClientsNum() {
        assertNotNull(action.getClientsNum());
    }

    @Test
    public void shouldSortFares() {
        List<Fare> faresList = action.getFaresList();
        List<Fare> sortedFaresList = new LinkedList<>(faresList);

        sortedFaresList = action.sortFares();

        assertNotEquals(faresList, sortedFaresList);
    }

    @Test
    public void shouldReturnNotNullWhileGettingFaresFromRange() {
        assertNotNull(action.getFaresFromRange(0.0, 10000.0));
    }
}