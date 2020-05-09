import Enemies.Summon;
import Players.*;
import Resources.*;
import quest.Quest;
import rooms.Room;

import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class Runner {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Room room = new Room();
        Quest quest = new Quest();
        Player player;
        Dwarf dwarf;
        Wizard wizard;
        Knight knight;
        Elf elf;
        Barbarian barbarian;
        Cleric cleric;

        System.out.println("Welcome to Quest Lab !");
        System.out.println("How many players would you like play?");

        String input = scanner.next();
        int players = parseInt(input);

        Weapon wBlank = new Weapon("", 0,0);
        Armour aBlank = new Armour("", 0,0);
        player = new Dwarf("",0, wBlank, aBlank);

        for(int i = 0; i < players; i++) {

            String prompt = String.format("Player %s, Pick a Pre-made Character: Dwarf, Wizard, " +
                    "Knight, Elf, Barbarian, Cleric", (i + 1));
            System.out.println(prompt);
            String character = scanner.next();
            character.toLowerCase();
            boolean valid = false;
            while (valid == false) {
                if (character.equals("dwarf") || character.equals("wizard") || character.equals("knight") || character.equals("elf") || character.equals("barbarian") || character.equals("cleric")) {
                    valid = true;
                } else {
                    System.out.println(character + " is a not a valid response please only enter a Pre-made Character: Dwarf, Wizard, " +
                            "Knight, Elf, Barbarian, Cleric");
                    character = scanner.next();
                    character.toLowerCase();
                }
            }

            System.out.println("You Picked " + character);
            prompt = String.format("Player %s, enter your " + character + "'s name: ", (i + 1));
            System.out.println(prompt);
            String playerName = scanner.next();
            if (character.equals("dwarf")) {

                Weapon axe = new Weapon("Basic Axe", 10, 5);
                Armour chain = new Armour("Chain mail", 20, 10);
                dwarf = new Dwarf(playerName, 20, axe, chain);
                player = dwarf;

            } else if (character.equals("wizard")) {

                Staff staff = new Staff("Sidhe", 30, 10, 10);
                Spell attack = new Spell("Attack", 30, 0, 1);
                Spell heal = new Spell("Heal", 0, 20, 1);

                Weapon claw = new Weapon("Claw", 5, 0);
                Armour hide = new Armour("Hide", 5, 0);
                Summon imp = new Summon("Imp", 10, claw, hide);

                player = new Wizard(playerName, 15, staff);
                ((Wizard) player).addSpell(attack);
                ((Wizard) player).addSpell(heal);
                ((Wizard) player).setSummon(imp);

            } else if (character.equals("knight")){

                Weapon sword = new Weapon("Excalibur", 20, 50);
                Armour plate = new Armour("Plated", 7, 50);
                player = new Knight(playerName, 60, sword, plate);

            } else if (character.equals("elf")){

                Weapon bow = new Weapon("Bow", 30, 10);
                Spell attack = new Spell("Attack", 30, 0, 1);
                Spell heal = new Spell("Heal", 0, 20, 1);
                Armour armour = new Armour("Chain mail", 10, 20);

                player = new Elf("Legolas", 40, armour, bow);

                ((Elf) player).addSpell(attack);
                ((Elf) player).addSpell(heal);

            } else if (character.equals("barbarian")){

                Weapon sword = new Weapon("Sword", 10, 7);
                Armour leather = new Armour("leather", 2, 5);
                player = new Barbarian("Conan",50, sword, leather);

            } else if (character.equals("cleric")){

                Spell heal = new Spell("Heal", 0, 20, 1);
                Potion healPotion = new Potion("Heal Potion",  5, 5);
                player = new Cleric("Wynne", 50);

                ((Cleric) player).addPotion(healPotion);
                ((Cleric) player).addSpell(heal);

            }

            quest.addPlayer(player);
        }


            System.out.println("How many rooms should the quest have?");
            int noOfRooms = parseInt(scanner.next());

            quest.start(noOfRooms);

            int counter = 0;
            for (Player partyMember : quest.getPlayers()) {
                for (Room questRoom : quest.getRooms()) {
                    if(partyMember.getHealth() > 0) {
                        questRoom.encounter(partyMember);
                        counter++;
                    }
                }
            }

            if (quest.lost()) {
                System.out.println("You Lost! On Room " + counter);

                for (Room questRoom : quest.getRooms()) {
                    if(!questRoom.isComplete()){
                        room = questRoom;
                    }
                }
                System.out.println("The Enemy " + room.getEnemy().getName() +" had " + room.getEnemy().getHealth() + " Health Left");
            } else {
                System.out.println("You Won! You Completed " + counter + " Rooms! And Made " + player.getPouch() + " Gold!");
            }
        }
}

