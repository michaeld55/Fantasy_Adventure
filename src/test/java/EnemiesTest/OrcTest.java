package EnemiesTest;

import Enemies.Orc;
import Resources.Armour;
import Resources.Weapon;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class OrcTest {

    private Orc arkail;
    private Weapon axe;
    private Armour basic;

    @Before
    public void before() {
        axe = new Weapon("axe", 30, 20);
        basic = new Armour("Leather", 5, 5);
        arkail = new Orc("Arkail", 40, axe, basic);
    }

    @Test
    public void basicTests() {

        assertEquals("Arkail", arkail.getName());
        assertEquals(40, arkail.getHealth());
        assertEquals("Leather", arkail.getArmour().getName());
        assertEquals("axe", arkail.getWeapon().getName());
    }
}
