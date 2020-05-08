package Enemies;

import Resources.Armour;
import Resources.Weapon;

public class Orc extends Enemy {

    private Weapon weapon;
    private Armour armour;

    public Orc(String name, int health, Weapon weapon, Armour armour) {
        super(name, health);
        this.weapon = weapon;
        this.armour = armour;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public Armour getArmour() {
        return armour;
    }

    public void setArmour(Armour armour) {
        this.armour = armour;
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

    public int attack() {
        return this.weapon.getDamage();
    }
}
