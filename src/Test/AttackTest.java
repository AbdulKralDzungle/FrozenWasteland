package Test;

import Command.Attack;
import Command.Command;
import Map.WorldMap;
import Npcs.Enemes.Crawler;
import Npcs.Npc;
import Player.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AttackTest {
    private Command cmd;
    private WorldMap wm;
    private Player p;
    private Npc n;

    @BeforeEach
    void setUp() {
        cmd = new Attack();
        wm = new WorldMap();
        p = new Player();
        n = new Crawler();
    }

    @Test
    void execute() {
        //cmd.execute(wm, )
    }

    @Test
    void apply() {
    }

    @Test
    void endsTurn() {
    }

    @Test
    void startInteraction() {
    }

    @Test
    void energyCost() {
    }
}