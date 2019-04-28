package com.bod.actions;

import com.bod.entity.Fare;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.EOFException;
import java.io.IOException;
import java.util.ArrayList;
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
        testList = new ArrayList<>();
    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Ignore
    @Test
    public void shouldThrowIOExceptionOnSerialize() throws IOException {
        thrown.expect(IOException.class);
        thrown.expectMessage("IOException in serialize()");
        fareSerializeService.serialize(testList);

    }


    @Ignore
    @Test
    public void shouldThrowEOFExceptionOnDeserialize() throws EOFException {
        thrown.expect(EOFException.class);
        thrown.expectMessage("EOFException in serialize()");
        testList = fareSerializeService.deserialize();
    }

    @Ignore
    @Test
    public void shouldThrowIOExceptionOnDeserialize() throws IOException {
        thrown.expect(IOException.class);
        thrown.expectMessage("IOException in serialize()");
        assertNull(thrown);
        testList = fareSerializeService.deserialize();
    }

    @Ignore
    @Test
    public void shouldThrowClassNotFoundExceptionOnDeserialize() throws ClassNotFoundException {
        thrown.expect(ClassNotFoundException.class);
        thrown.expectMessage("ClassNotFoundException in serialize()");
        testList = fareSerializeService.deserialize();
    }

    @Ignore
    @Test
    public void shouldThrowNullPointerExceptionOnDeserialize() throws NullPointerException {
        thrown.expect(NullPointerException.class);
        thrown.expectMessage("NullPointerException in serialize()");
        testList = fareSerializeService.deserialize();
    }
}