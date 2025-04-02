package Tests;

import Map.WorldMap;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WorldMapTest {
    private WorldMap wm;

    @BeforeEach
    void setUp() {
        wm = new WorldMap();
        wm.initialize();
    }

    @Test
    void getCurrentId() {
        assertEquals(1, wm.getCurrentId());
        wm.goTo(5);
        assertEquals(5, wm.getCurrentId());
        wm.goTo(-1);
        assertEquals(5, wm.getCurrentId());
        wm.goTo(10);
        assertEquals(5, wm.getCurrentId());
        wm.goTo(Integer.MAX_VALUE);
        assertEquals(5, wm.getCurrentId());
    }

    @Test
    void getCurrentLoc() {
        wm.goTo(5);
        assertEquals(5, wm.getCurrentId());
        wm.goTo(1);
        assertEquals(1, wm.getCurrentId());
    }

    @Test
    void goTo() {
        assertTrue(wm.goTo(5));
        assertFalse(wm.goTo(-1));
        assertFalse(wm.goTo(Integer.MAX_VALUE));
    }
}