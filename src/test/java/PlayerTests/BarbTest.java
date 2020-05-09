package PlayerTests;

import Players.Barbarian;
import Resources.Armour;
import Resources.Weapon;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BarbTest {

    private Barbarian conan;
    private Weapon sword;
    private Weapon axe;
    private Armour basic;
    private Armour chain;

    @Before
    public void before() {
        sword = new Weapon("Father's Sword", 10, 7);
        axe = new Weapon("Battle axe", 20, 14);
        basic = new Armour("leather", 2, 5);
        chain = new Armour("Chain mail", 4, 10);
        conan = new Barbarian("Conan",50, sword, basic);
    }

    @Test
    public void basicTests() {
        assertEquals("Conan", conan.getName());
        assertEquals(50, conan.getHealth());
        assertEquals("Father's Sword", conan.getWeapon().getName());
        assertEquals(0, conan.getPouch());
        assertEquals("leather",conan.getArmour().getName() );

    }

    @Test
    public void canChangeWeapon() {
        conan.setWeapon(axe);
        assertEquals("Battle axe", conan.getWeapon().getName());
    }

    @Test
    public void canChangeArmour() {
        conan.setArmour(chain);
        assertEquals("Chain mail", conan.getArmour().getName());
    }


}
