package PlayerTests;

import Enemies.Summon;
import Players.Wizard;
import Resources.Armour;
import Resources.Spell;
import Resources.Staff;
import Resources.Weapon;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class WizardTest {

    private Wizard merlin;
    private Spell attack;
    private Spell heal;
    private Staff staff;
    private Summon imp;
    private Weapon claw;
    private Armour hide;


    @Before
    public void before() {
        staff = new Staff("Sidhe", 30, 10);
        attack = new Spell("attack", 30, 0);
        heal = new Spell("heal", 0, 20);
        merlin = new Wizard("Merlin", 30, staff);
        claw = new Weapon("Claw", 5);
        hide = new Armour("Hide", 5);
        imp = new Summon("Imp", 10, claw, hide);
    }

    @Test
    public void addSpell() {
        merlin.addSpell(attack);
        assertEquals(1, merlin.getSpellsSize());
        merlin.addSpell(heal);
        assertEquals(2, merlin.getSpellsSize());
    }

    @Test
    public void basicTest() {
        assertEquals("Merlin", merlin.getName());
        assertEquals(30, merlin.getHealth());
        assertEquals("Sidhe", merlin.getStaff().getName());
    }

    @Test
    public void canSummon(){

        merlin.setSummon(imp);
        Summon summonReturn = merlin.getSummon();
        assertEquals("Imp", summonReturn.getName());
        assertTrue(summonReturn.isSummoned());
    }


}
