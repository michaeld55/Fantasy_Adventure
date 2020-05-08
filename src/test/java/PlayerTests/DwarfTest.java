package PlayerTests;

import Players.Dwarf;
import Resources.Armour;
import Resources.Weapon;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class DwarfTest {

        private Dwarf gimli;
        private Armour basic;
        private Weapon axe;

    @Before
        public void before() {
            axe = new Weapon("Double Blade", 10);
            basic = new Armour("leather", 2);
            gimli = new Dwarf("Gimli",50, axe, basic);
        }

        @Test
        public void basicTests() {
            assertEquals("Gimli", gimli.getName());
            assertEquals(50, gimli.getHealth());
            assertEquals("Double Blade", gimli.getWeapon().getName());
            assertEquals(0, gimli.getPouch());
            assertEquals("leather",gimli.getArmour().getName());
            assertEquals(2, gimli.getArmour().getArmourPoint());

        }
    }

