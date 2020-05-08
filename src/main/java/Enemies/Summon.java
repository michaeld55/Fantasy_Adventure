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
}
