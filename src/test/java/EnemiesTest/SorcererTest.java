package EnemiesTest;

import Players.Wizard;
import Resources.Spell;
import Resources.Staff;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SorcererTest {

    private Wizard thulsa;
    private Spell attack;
    private Staff staff;


    @Before
    public void before() {
        staff = new Staff("Wooden Staff", 30, 10, 10);
        attack = new Spell("attack", 30, 0, 1);
        thulsa = new Wizard("Thulsa", 30, staff);
    }

    @Test
    public void basicTests() {
        assertEquals("Thulsa", thulsa.getName());
        assertEquals(30, thulsa.getHealth());
        assertEquals("Wooden Staff", thulsa.getStaff().getName());
    }

    @Test
    public void addSpell() {
        thulsa.addSpell(attack);
        assertEquals(1, thulsa.getSpells().size());
    }
}
