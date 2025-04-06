package Test;

import Command.Command;
import Command.GoTo;
import Efects.Efect;
import Map.WorldMap;
import Npcs.Enemes.Crawler;
import Npcs.Npc;
import Player.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GoToTest {
    private Command cmd;
    private WorldMap wm;
    private Player p;
    private Npc npc;
    private Npc npc2;

    @BeforeEach
    void setUp() {
        cmd = new GoTo();
        wm = new WorldMap();
        p = new Player();
        p.initialize();
        wm.initialize();
        npc = new Crawler();
    }

    @Test
    void execute() {
        cmd.execute(wm, "0", npc, p);
        assertEquals(5, wm.getCurrentId());

    }

    @Test
    void exit() {
        assertFalse(cmd.exit());
    }


    @Test
    void endsTurn() {
        assertTrue(cmd.endsTurn());
    }

    @Test
    void energyCost() {
        assertEquals(6, cmd.energyCost());
    }
}