package Players;

import Resources.Armour;
import Resources.Weapon;

public class Dwarf extends Player {

    private Weapon weapon;
    private Armour armour;

    public Dwarf(String name, int health, Weapon weapon, Armour armour) {
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
}
