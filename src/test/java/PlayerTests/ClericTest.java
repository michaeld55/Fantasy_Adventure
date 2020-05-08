package PlayerTests;

import Players.Cleric;
import Resources.Potion;
import Resources.Spell;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ClericTest {

    private Spell healSpell;
    private Potion healPotion;
    private Cleric wynne;

    @Before
    public void before() {
        healSpell = new Spell("Heal", 0, 20, 1);
        healPotion = new Potion("Heal",  5, 5);
        wynne = new Cleric("Wynne", 50);

    }

    @Test
    public void basicTests() {
        assertEquals("Wynne",wynne.getName());
        assertEquals(50, wynne.getHealth());
    }

    @Test
    public void addPotion(){
        wynne.addPotion(healPotion);
        assertEquals(1, wynne.getPotions().size());
    }

    @Test
    public void AddSpell() {
        wynne.addSpell(healSpell);
        assertEquals(1, wynne.getSpells().size());
    }

}
