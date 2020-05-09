package Players;

import Resources.Armour;
import Resources.ITreasure;
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

    public void loot(ITreasure treasure) {
        if(treasure instanceof Weapon){
            this.checkWeaponStats((Weapon) treasure);
        }else if(treasure instanceof Armour) {
            this.checkArmourStats((Armour) treasure);
        }else if(treasure instanceof Spell){
            this.checkSpellStats((Spell) treasure);
        }else {
            this.sellItem(treasure);
        }
    }

    private void checkSpellStats(Spell newSpell) {
        if(this.spells.size() < 2){
            spells.add(newSpell);
        }else{
            this.askToRemoveSpell(newSpell);

        }
    }

    private void askToRemoveSpell(Spell newSpell) {

        String input = "";
        System.out.println("Replace A Spell with" + newSpell.getName() +
                " it does: " + newSpell.getAttackPoints() + " damage. " +
                " It also Heals: " + newSpell.getHealPoints() + " Hit Points. " +
                "Please enter: Yes or No");

        java.util.Scanner scanner = new java.util.Scanner(System.in);
        input = scanner.next();
        input.toLowerCase();
        boolean valid = false;
        while(valid = false){
            if(input.equals("yes") || input.equals("no")){
                valid = true;
            }else {
                System.out.println(input + " is a not a valid response please only enter Yes or No");
            }
        }
        System.out.println("You chose: " + input);
        if (input.equals("no")){
            System.out.println("You Have Not Learned" + newSpell.getName());
        }else{
            this.replaceSpell(newSpell);
        }
    }

    private void replaceSpell(Spell newSpell) {
        String input = "";
        System.out.println("Choose a Spell To Replace ");
        int counter = 1;
        for (Spell spell : spells) {
            System.out.println("Spell " + counter + ": Name" + spell.getName() +
                    " it does: " + newSpell.getAttackPoints() + " damage. " +
                    " It also Heals: " + newSpell.getHealPoints() + " Hit Points. ");
            counter++;
        }
        System.out.println("To Replace a Spell Enter its Number. To Cancel Enter No");
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        input = scanner.next();

        boolean valid = false;

        while (valid = false) {
            if (input.equals("no")) {
                valid = true;
                System.out.println("Cancelled Spell Replacement You Have Not Learned" + newSpell.getName());
            } else if (input.equals("1") || input.equals("2")) {
                int index;
                try {
                    index = Integer.parseInt(input);
                } catch (NumberFormatException e) {
                    index = 0;
                    System.out.println(input + " is a not a valid response please only enter A Valid Number Or No");
                }
                index -= 1;
                Spell removedSpell = this.spells.get(index);
                if( removedSpell == null){
                    System.out.println(input + " is a not a valid response please only enter A Valid Number Or No");
                }else {
                    spells.remove(removedSpell);
                    spells.add(newSpell);
                    System.out.println("You Replaced " + removedSpell.getName() + " With " + newSpell.getName());
                    valid = true;
                }
            } else {
                System.out.println(input + " is a not a valid response please only enter A Valid Number Or No");
            }
        }
    }

    private void checkArmourStats(Armour newArmour) {
        if(this.armour.getArmourPoint() < newArmour.getArmourPoint()){
            this.sellItem(armour);
            this.setArmour(newArmour);

        }else{
            this.sellItem(newArmour);
        }
    }

    public void checkWeaponStats(Weapon newWeapon){
        if(this.weapon.getDamage() < newWeapon.getDamage()){
            this.sellItem(weapon);
            this.setWeapon(newWeapon);
        }else{
            this.sellItem(newWeapon);
        }
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
