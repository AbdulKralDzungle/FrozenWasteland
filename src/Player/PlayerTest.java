package Player;

import Efects.Strenght;
import Items.WhiteLether;
import Npcs.Enemes.Crawler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {
    private Player player1;
    private Player player2;
    private Player player3;
    private Player player4;

    @BeforeEach
    void setUp() {
        player1 = new Player();
        player2 = new Player();
        player3 = new Player();
        player4 = new Player();
        player1.inicialize();
        player2.inicialize();
        player3.inicialize();
        player4.inicialize();
    }

    @Test
    void removeItem() {
        player1.putItem(new WhiteLether());
        assertTrue(player1.removeItem(0));
        player2.putItem(new WhiteLether());
        assertFalse(player2.removeItem(69));
        player3.putItem(new WhiteLether());
        assertTrue(player3.removeItem(0));
        assertFalse(player3.removeItem(0));
    }

    @Test
    void getBonusDmg() {
        player1.applyEffect(new Strenght());
        player1.ubdate(new Crawler());
        assertEquals(10, player1.getBonusDmg());
    }

    @Test
    void removeEnergy() {
        assertTrue(player1.removeEnergy(5));
        assertFalse(player2.removeEnergy(200));
        assertTrue(player3.removeEnergy(-5000));
        assertFalse(player4.removeEnergy(Integer.MAX_VALUE));
    }

    @Test
    void isDead() {
        player1.takeDmg(10);
        assertFalse(player1.isDead());
        player2.takeDmg(-590);
        assertFalse(player2.isDead());
        player3.takeDmg(Integer.MAX_VALUE);
        assertTrue(player3.isDead());
        player4.takeDmg(200);
        assertTrue(player4.isDead());
    }

    @Test
    void spendMoney() {
        assertTrue(player1.removeEnergy(5));
        assertFalse(player2.removeEnergy(200));
        assertTrue(player3.removeEnergy(-5000));
        assertFalse(player4.removeEnergy(Integer.MAX_VALUE));
    }

    @Test
    void getMoney() {
        assertEquals(999, player1.getMoney());
        player1.spendMoney(10);
        assertEquals(989, player1.getMoney());
        player1.spendMoney(Integer.MAX_VALUE);
        assertEquals(989, player1.getMoney());
    }

    @Test
    void getItem() {
        player2.putItem(new WhiteLether());
        assertInstanceOf(WhiteLether.class, player2.getItem(0));
    }
}