package com.epam.actions;

import com.epam.entity.Fare;
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

public class ActionsTest {
    private String fileName;
    private Actions<Fare> fareActions;
    private List<Fare>testList;

    @Before
    public void setUp() throws Exception {
        fileName = "farestest.txt";
        fareActions = new Actions<Fare>(fileName);
        testList = new ArrayList<>();
    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Ignore
    @Test
    public void shouldThrowIOExceptionOnSerialize() throws IOException {
        thrown.expect(IOException.class);
        thrown.expectMessage("IOException in serialize()");
        fareActions.serialize(testList);

    }


    @Ignore
    @Test
    public void shouldThrowEOFExceptionOnDeserialize() throws EOFException {
        thrown.expect(EOFException.class);
        thrown.expectMessage("EOFException in serialize()");
        testList = fareActions.deserialize();
    }

    @Ignore
    @Test
    public void shouldThrowIOExceptionOnDeserialize() throws IOException {
        thrown.expect(IOException.class);
        thrown.expectMessage("IOException in serialize()");
        assertNull(thrown);
        testList = fareActions.deserialize();
    }

    @Ignore
    @Test
    public void shouldThrowClassNotFoundExceptionOnDeserialize() throws ClassNotFoundException {
        thrown.expect(ClassNotFoundException.class);
        thrown.expectMessage("ClassNotFoundException in serialize()");
        testList = fareActions.deserialize();
    }

    @Ignore
    @Test
    public void shouldThrowNullPointerExceptionOnDeserialize() throws NullPointerException {
        thrown.expect(NullPointerException.class);
        thrown.expectMessage("NullPointerException in serialize()");
        testList = fareActions.deserialize();
    }
}