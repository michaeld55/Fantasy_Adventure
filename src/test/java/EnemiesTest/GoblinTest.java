package EnemiesTest;

import Enemies.Goblin;
import Resources.Armour;
import Resources.Weapon;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GoblinTest {

    private Goblin styx;
    private Weapon sword;
    private Armour none;

    @Before
    public void before() {
        sword = new Weapon("sword", 20, 10);
        none = new Armour("none", 0, 0);
        styx = new Goblin("Styx", 30, sword, none);
    }

    @Test
    public void basicTests() {
        assertEquals("Styx", styx.getName());
        assertEquals(30, styx.getHealth());
        assertEquals("none", styx.getArmour().getName());
        assertEquals("sword", styx.getWeapon().getName());
    }
}
