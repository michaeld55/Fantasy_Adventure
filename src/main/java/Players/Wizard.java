package Players;


import Enemies.Summon;
import Resources.Spell;
import Resources.Staff;

import java.util.ArrayList;

public class Wizard extends Player {

    private Staff staff;
    private ArrayList<Spell> spells;
    private Summon summon;


    public Wizard(String name, int health, Staff staff) {
        super(name, health);
        this.staff = staff;
        this.spells = new ArrayList<Spell>();
    }

    public Staff getStaff() {
        return staff;
    }

    public ArrayList<Spell> getSpells() {
        return spells;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public void addSpell(Spell spell){
        this.spells.add(spell);
    }

    public Summon getSummon() {
        this.summon.setSummoned(true);
        return summon;
    }

    public void setSummon(Summon summon) {

        this.summon = summon;

    }

    public int getSpellsSize() {

        return this.spells.size();

    }
}
