package com.bod.actions;

import com.bod.entity.Fare;
import com.bod.entity.SimpleBasedFare;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

public class SerializeServiceTest {
    private String fileName;
    private SerializeService<Fare> fareSerializeService;
    private List<Fare>testList;

    @Before
    public void setUp() throws Exception {
        fileName = "farestest.txt";
        fareSerializeService = new SerializeService<Fare>(fileName);
        testList = fareSerializeService.deserialize();
    }

    @Test
    public void shouldWriteNewInstanceToFile() {
        List<Fare> testListBefore = new LinkedList<>(testList);
        testList.add(new SimpleBasedFare("super_pooper_simple", 1000, 100, 10));
        fareSerializeService.serialize(testList);
        testList = fareSerializeService.deserialize();
        assertNotEquals(testList, testListBefore);
    }
}