package com.epam.actions;

import com.epam.entity.Entity;
import com.epam.entity.PremiumBasedFare;
import org.junit.*;
import org.junit.rules.ExpectedException;

import java.io.IOException;
import java.io.StreamCorruptedException;
import java.util.List;


public class ActionsTest {
    Entity testEntity;
    Actions testAction;
    List<Entity> testList;

    @Before
    public void setUp() throws Exception {
        testEntity = new PremiumBasedFare("testInternet", 10000, 1000, 100, 10, 10);
        testAction = new Actions("fares.txt");
    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Ignore
    @Test
    public void shouldReturnNullPointerExceptionOnSerialize() throws NullPointerException {
        thrown.expect(NullPointerException.class);
        thrown.expectMessage("NullPointerException in Actions.serialize()");
        testAction.serialize(testEntity);
    }

    @Ignore
    @Test
    public void shouldReturnIOExceptionOnSerialize() throws IOException {
        thrown.expect(IOException.class);
        thrown.expectMessage("IOExceptionException in Actions.serialize()");
        testAction.serialize(testEntity);
    }

    @Ignore
    @Test
    public void shouldReturnStreamCorruptedExceptionOnSerialize() throws StreamCorruptedException {
        thrown.expect(StreamCorruptedException.class);
        thrown.expectMessage("StreamCorruptedException in Actions.serialize()");
        testAction.deserialize();
    }


    @Ignore
    @Test
    public void shouldReturnNullPointerExceptionOnDeserialize() throws NullPointerException {
        thrown.expect(NullPointerException.class);
        thrown.expectMessage("NullPointerException in Actions.serialize()");
        testList = testAction.deserialize();
    }

    @Ignore
    @Test
    public void shouldReturnIOExceptionOnDeserialize() throws IOException {
        thrown.expect(IOException.class);
        thrown.expectMessage("IOExceptionException in Actions.serialize()");
        testList = testAction.deserialize();
    }

    @Ignore
    @Test
    public void shouldReturnStreamCorruptedExceptionOnDeserialize() throws StreamCorruptedException {
        thrown.expect(StreamCorruptedException.class);
        thrown.expectMessage("StreamCorruptedException in Actions.serialize()");
        testList = testAction.deserialize();
    }
}