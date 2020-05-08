package Enemies;

import Resources.Armour;
import Resources.Weapon;

public class Summon extends Enemy{

    private boolean summoned;
    private Weapon weapon;
    private Armour armour;

    public Summon(String name, int health, Weapon weapon, Armour armour){
        super(name, health);
        summoned = false;
        this.weapon = weapon;
        this.armour = armour;
    }

    public boolean isSummoned() {
        return summoned;
    }

    public void setSummoned(boolean summoned) {
        this.summoned = summoned;
    }

    public void hit(int damage) {
        while (this.armour.getArmourPoint() > 0 && damage > 0){
            armour.damage();
            damage -= 1;


        }
        while (this.summoned && damage > 0){
            this.wound();
            this.checkStatus();
            damage -= 1;
        }
    }

    public int attack() {
        return this.weapon.getDamage();
    }

    public void checkStatus() {

        if (this.getHealth() == 0) {
            summoned = false;
        }
    }
}
