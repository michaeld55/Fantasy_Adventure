package Players;

import Resources.Potion;
import Resources.Spell;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Cleric extends Player{

    private ArrayList<Potion> potions;
    private ArrayList<Spell> spells;

    public Cleric(String name, int health) {
        super(name, health);
        this.potions = new ArrayList<Potion>();
        this.spells = new ArrayList<Spell>();
    }

    public void hit(int damage) {
        while (this.getHealth() > 0 && damage > 0){
            this.wound();
            damage -= 1;
        }
    }

    public ArrayList<Potion> getPotions() {
        return potions;
    }

    public ArrayList<Spell> getSpells() {
        return spells;
    }

    public void addSpell(Spell spell){
        this.spells.add(spell);
    }

    public void addPotion(Potion potion){
        this.potions.add(potion);
    }

    public int attack() {
        Collections.shuffle(spells);
        Spell spell = spells.get(0);
        return spell.getAttackPoints();
    }


}
