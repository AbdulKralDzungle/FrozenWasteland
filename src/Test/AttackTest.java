package Test;

import Command.Attack;
import Command.Command;
import Map.WorldMap;
import Npcs.Enemes.Crawler;
import Npcs.Npc;
import Player.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AttackTest {
    private Command cmd;
    private WorldMap wm;
    private Player p;
    private Npc npc;
    private Npc npc2;

    @BeforeEach
    void setUp() {
        cmd = new Attack();
        wm = new WorldMap();
        p = new Player();
        p.initialize();
        wm.initialize();
        npc = new Crawler();
        npc2 = new Crawler();
    }


    @Test
    void apply() {
        wm.goTo(5);
        wm.goTo(6);
        cmd.execute(wm, "0", npc, p);
        assertNull(cmd.apply());
    }

    @Test
    void endsTurn() {
        assertFalse(cmd.endsTurn());
        cmd.execute(wm, "0", npc, p);
        cmd.execute(wm, "0", npc, p);
        cmd.execute(wm, "0", npc, p);
        cmd.execute(wm, "0", npc, p);
        cmd.execute(wm, "0", npc, p);
        cmd.execute(wm, "0", npc, p);
        assertTrue(cmd.endsTurn());
    }

    @Test
    void startInteraction() {
        cmd.execute(wm, "0", npc2, p);
        assertNotNull(cmd.startInteraction());
        cmd.execute(wm, "0", npc2, p);
        cmd.execute(wm, "0", npc2, p);
        cmd.execute(wm, "0", npc2, p);
        cmd.execute(wm, "0", npc2, p);
        cmd.execute(wm, "0", npc2, p);
        cmd.execute(wm, "0", npc2, p);
        assertNull(cmd.startInteraction());
    }

    @Test
    void energyCost() {
        assertEquals(3,cmd.energyCost());
    }
}