package Test;

import Efects.Strenght;
import Map.Location;
import Map.WorldMap;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LocationTest {
    Location loc;
    WorldMap world;

    @BeforeEach
    void setUp() {
        world = new WorldMap();
        world.initialize();
        loc = world.getCurrentLoc();
    }

    @Test
    void getName() {
        assertEquals("Tavern", loc.getName());
    }

    @Test
    void getGoToLocations() {
        int[] ids = new int[]{5};
        for (int i = 0; i < ids.length; i++) {
            assertEquals(ids[i], loc.getGoToLocations()[i]);
        }
        world.goTo(5);
        loc = world.getCurrentLoc();
        ids = new int[]{1, 2, 3, 4, 6};
        for (int i = 0; i < ids.length; i++) {
            assertEquals(ids[i], loc.getGoToLocations()[i]);
        }
    }

    @Test
    void getId() {
        assertEquals(1, loc.getId());
    }

    @Test
    void apply() {
        assertInstanceOf(Strenght.class, loc.apply());
    }
}