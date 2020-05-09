package Players;

import Resources.ITreasure;
import Resources.Potion;
import Resources.Spell;
import Resources.Staff;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Cleric extends Player{

    private ArrayList<Potion> potions;
    private ArrayList<Spell> spells;

    public Cleric(String name, int health) {
        super(name, health);
        this.potions = new ArrayList<Potion>();
        this.spells = new ArrayList<Spell>();
    }

    public void hit(int damage) {
        while (this.getHealth() > 0 && damage > 0){
            this.wound();
            damage -= 1;
        }
    }

    public ArrayList<Potion> getPotions() {
        return potions;
    }

    public ArrayList<Spell> getSpells() {
        return spells;
    }

    public void addSpell(Spell spell){
        this.spells.add(spell);
    }

    public void addPotion(Potion potion){
        this.potions.add(potion);
    }

    public int attack() {
        Collections.shuffle(spells);
        Spell spell = spells.get(0);
        return spell.getAttackPoints();
    }

    public void loot(ITreasure treasure) {
        if(treasure instanceof Spell){
            this.checkSpellStats((Spell) treasure);
        }else if(treasure instanceof Potion){
            this.checkPotionStats((Potion) treasure);
        }else{
            this.sellItem(treasure);
        }
    }

    private void checkPotionStats(Potion newPotion) {

        if (this.potions.size() < 2){
            this.addPotion(newPotion);
        }else {
            this.removeWorstPotion(newPotion);
        }

    }

    private void removeWorstPotion(Potion newPotion) {
        Potion potionOne = potions.get(0);
        Potion potionTwo = potions.get(1);
        Potion removedPotion = newPotion;

       if(newPotion.getHealPoints() > potionOne.getHealPoints()){
           removedPotion = potionOne;
           this.potions.remove(removedPotion);
           this.potions.add(newPotion);
       }else if(newPotion.getHealPoints() > potionTwo.getHealPoints()){
           removedPotion = potionTwo;
           this.potions.remove(removedPotion);
           this.potions.add(newPotion);
       }

        String input = "";
        System.out.println("Use " +removedPotion.getName() +" Potion or Sell" +removedPotion.getName() +
                " Potion. Please enter: Use or Sell");

        java.util.Scanner scanner = new java.util.Scanner(System.in);
        input = scanner.next();
        input.toLowerCase();
        boolean valid = false;
        while(valid = false){
            if(input.equals("use") || input.equals("sell")){
                valid = true;
            }else {
                System.out.println(input + " is a not a valid response please only enter Use or Sell");
            }
        }
        System.out.println("You chose: " + input);
        if (input.equals("Sell")){
            System.out.println("You Have sold " + removedPotion.getName() + " for " + removedPotion.getValue() +" Gold");
            this.sellItem(removedPotion);
        }else{
            System.out.println("You Have Used " + removedPotion.getName() + " for " + removedPotion.getHealPoints() +" Health");
            this.heal(removedPotion.getHealPoints());
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

}
