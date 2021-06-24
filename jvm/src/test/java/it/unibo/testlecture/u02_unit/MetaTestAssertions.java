package it.unibo.testlecture.u02_unit;

import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MetaTestAssertions {
    @Test
    public void test_assertions(){
        assertTrue(true);
        assertEquals(7., 5f+2);
        assertEquals(7.2, 7.0, 0.5);
        assertNotEquals(7, 5+3);
        assertArrayEquals(new int[]{ 1, 2, 3}, List.of(1, 2, 3).stream().mapToInt(i->i).toArray());
        assertTimeout(Duration.ofMillis(500), () -> Thread.sleep(100));
        assertTimeoutPreemptively(Duration.ofMillis(500), () -> Thread.sleep(100));
        assertAll(() -> assertTrue(true), () -> assertFalse(false));
        assertDoesNotThrow(() -> { });
        assertThrows(RuntimeException.class, () -> { throw new RuntimeException("exception"); } );
        assertNotSame(new int[]{ 1 }, new int[] { 1 });
        assertSame(this, this);
        assertNull(null);
        assertNotNull(this);
        // Descriptive messages for assertXXX()
        assertTrue(true, "an assertion");
        assertTrue(true, () -> "an assertion");
    }

    @Test
    public void test_assumptions(){
        Assumptions.assumeTrue(false);
        fail();
    }

    @Test @Disabled
    public void test_to_ignore(){
        fail();
    }
}
