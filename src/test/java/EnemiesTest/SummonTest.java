package EnemiesTest;

import Enemies.Summon;
import Resources.Armour;
import Resources.Weapon;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class SummonTest {
    Weapon claw;
    Armour hide;
    Summon imp;

    @Before
    public void before(){
        claw = new Weapon("Claw", 5, 0);
        hide = new Armour("Hide", 5, 0);
        imp = new Summon("Imp", 10, claw, hide);
    }

    @Test
    public void hasBasicInfo(){
        assertEquals("Imp", imp.getName());
        assertEquals(claw, imp.getWeapon());
        assertEquals(10, imp.getHealth());
        assertEquals(hide, imp.getArmour());
    }
}
