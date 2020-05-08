package Players;

import Resources.Armour;
import Resources.ITreasure;
import Resources.Weapon;

public class Barbarian extends Player {

    private Weapon weapon;
    private Armour armour;

    public Barbarian(String name, int health, Weapon weapon, Armour armour) {
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

    public void loot(ITreasure treasure) {
        if(treasure instanceof Weapon){
            this.checkWeaponStats((Weapon) treasure);
        }else if(treasure instanceof Armour){
            this.checkArmourStats((Armour) treasure);
        }else {
            this.sellItem(treasure);
        }
    }

    private void checkArmourStats(Armour newArmour) {
        if(this.armour.getArmourPoint() < newArmour.getArmourPoint()){
            this.setArmour(newArmour);
        }else{
            this.sellItem(newArmour);
        }
    }

    public void checkWeaponStats(Weapon newWeapon){
        if(this.weapon.getDamage() < newWeapon.getDamage()){
            this.setWeapon(newWeapon);
        }else{
            this.sellItem(newWeapon);
        }
    }
}
