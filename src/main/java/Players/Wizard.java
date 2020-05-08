package Players;


import Enemies.Summon;
import Resources.ITreasure;
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

    public void loot(ITreasure treasure) {
        if(treasure instanceof Spell){
            this.checkSpellStats((Spell) treasure);
        }else if(treasure instanceof Staff){
            this.checkStaffStats((Staff) treasure);
        }else{
            this.sellItem(treasure);
        }
    }

    private void checkStaffStats(Staff newStaff) {
        if((this.staff.getAttackPoints() > newStaff.getAttackPoints()) || (this.staff.getHealPoints() > newStaff.getHealPoints())){
            this.askToChangeStaff(newStaff);
        }else {
            this.sellItem(newStaff);
        }
    }

    private void checkSpellStats(Spell newSpell) {
        if(this.spells.size() <= 4){
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
            } else if (input.equals("1") || input.equals("2") || input.equals("3") || input.equals("4")) {
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
                    valid =true;
                }
            } else {
                System.out.println(input + " is a not a valid response please only enter A Valid Number Or No");
            }
        }
    }

    private void askToChangeStaff(Staff newStaff){
        String input = "";
        System.out.println("Replace Your Staff with" + newStaff.getName() +
                " it does: " + newStaff.getAttackPoints() + " Bonus damage. " +
                " It also Heals: " + newStaff.getHealPoints() + " Bonus Hit Points. " +
                " Your Current Staff " + staff.getName() + " does: " + staff.getAttackPoints() +
                " Bonus damage. It also Heals: " + staff.getHealPoints() +
                " Bonus Hit Points. Please enter: Yes or No");

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
            System.out.println("You Have Not Equipped" + newStaff.getName());
            this.sellItem(newStaff);
        }else{
            this.setStaff(newStaff);
        }
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
