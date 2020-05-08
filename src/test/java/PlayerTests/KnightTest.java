package PlayerTests;

import Players.Knight;
import Resources.Armour;
import Resources.Weapon;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class KnightTest {

    private Knight arthur;
    private Weapon sword;
    private Armour plate;

    @Before
    public void before() {
        sword = new Weapon("Excalibur", 20, 50);
        plate = new Armour("Plated", 7, 50);
        arthur = new Knight("Sir Arthur", 60, sword, plate);
    }

    @Test
    public void basicTests() {
        assertEquals("Sir Arthur", arthur.getName());
        assertEquals(60, arthur.getHealth());
        assertEquals("Excalibur", arthur.getWeapon().getName());
        assertEquals("Plated", arthur.getArmour().getName());
    }
}
