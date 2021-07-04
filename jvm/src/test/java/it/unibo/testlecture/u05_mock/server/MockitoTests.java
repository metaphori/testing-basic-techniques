package it.unibo.testlecture.u05_mock.server;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class MockitoTests {
    @Test public void Mocks_vs_Spies(){
        List<Integer> mockedList = mock(ArrayList.class);
        mockedList.add(7);
        assertEquals(null, mockedList.get(0));
        assertEquals(0, mockedList.size());

        List<Integer> spy = spy(ArrayList.class);
        spy.add(7);
        assertEquals(7, spy.get(0));
        assertEquals(1, spy.size());
    }
}
