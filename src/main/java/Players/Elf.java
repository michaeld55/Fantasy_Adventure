package Players;

import Resources.Armour;
import Resources.Spell;
import Resources.Weapon;

import java.util.ArrayList;
import java.util.Collections;

public class Elf extends Player {

    private ArrayList<Spell> spells;
    private Armour armour;
    private Weapon weapon;

    public Elf(String name, int health, Armour armour, Weapon weapon) {
        super(name, health);
        this.armour = armour;
        this.weapon = weapon;
        this.spells = new ArrayList<Spell>();
    }

    public Armour getArmour() {
        return armour;
    }

    public ArrayList<Spell> getSpells() {
        return spells;
    }

    public void setArmour(Armour armour) {
        this.armour = armour;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void addSpell(Spell spell) {
        this.spells.add(spell);
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public int attack() {
        Collections.shuffle(spells);
        Spell spell = spells.get(0);
        int damage = spell.getAttackPoints();
        damage += weapon.getDamage();
        return damage;
    }

    public void hit(int damage) {
        while (armour.getArmourPoint() > 0 && damage > 0){
            armour.damage();
            damage -= 1;

        }
        while (this.getHealth() > 0 && damage > 0){
            this.wound();
            damage -= 1;
        }
    }

}
