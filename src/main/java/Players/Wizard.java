package Players;


import Enemies.Summon;
import Resources.Spell;
import Resources.Staff;

import java.util.ArrayList;
import java.util.Collections;

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

    public int attack() {
        int damage = staff.getAttackPoints();
        Collections.shuffle(spells);
        Spell spell = spells.get(0);
        damage += spell.getAttackPoints();
        return damage;
    }

    public void hit(int damage) {
        while (summon.getHealth() > 0 && damage > 0){
            summon.wound();
            damage -= 1;


        }
        while (this.getHealth() > 0 && damage > 0){
            this.wound();
            damage -= 1;
        }
    }
}
