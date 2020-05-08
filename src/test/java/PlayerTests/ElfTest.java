package PlayerTests;

import Players.Elf;
import Resources.Armour;
import Resources.Spell;
import Resources.Weapon;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ElfTest {

    private Elf legolas;
    private Weapon bow;
    private Spell heal;
    private Armour armour;

    @Before
    public void before() {
        bow = new Weapon("Bow", 30, 10);
        heal = new Spell("Heal", 0, 20, 1);
        armour = new Armour("Chain mail", 10, 20);
        legolas = new Elf("Legolas", 40, armour, bow);
    }

    @Test
    public void basicTests() {
        assertEquals("Legolas", legolas.getName());
        assertEquals(40, legolas.getHealth());
        assertEquals("Chain mail", legolas.getArmour().getName());
        assertEquals("Bow", legolas.getWeapon().getName());
    }

    @Test
    public void addSpell() {
        legolas.addSpell(heal);
        assertEquals(1, legolas.getSpells().size());
    }
}
