package quest;

import Enemies.*;
import Players.Player;
import Resources.*;
import rooms.Room;

import java.util.ArrayList;

public class Quest {

    private ArrayList<Player> players;
    private ArrayList<Room> rooms;

    public Quest() {
        rooms = new ArrayList<Room>();
        this.players = new ArrayList<Player>();
    }

    public static Enemy createNewEnemy() {
        Weapon wBlank = new Weapon("", 0,0);
        Armour aBlank = new Armour("", 0,0);
        Enemy enemy = new Summon("", 0, wBlank, aBlank );
        int result = (int)(Math.random() * 4 + 1);
        if ( result == 1){
            Weapon axe = new Weapon("Axe", 30, 20);
            Armour basic = new Armour("Leather", 5, 5);
            enemy = new Orc("Orc", 40, axe, basic);

        }else if( result == 2) {
            Weapon sword = new Weapon("Sword", 20, 10);
            Armour none = new Armour("None", 0, 0);
            enemy = new Goblin("Goblin", 30, sword, none);
        } else if( result == 3) {
            Weapon claw = new Weapon("Claw", 5, 0);
            Armour hide = new Armour("Hide", 5, 0);
            enemy = new Summon("Imp", 10, claw, hide);
        } else if( result == 4) {
            Staff staff = new Staff("Wooden Staff", 30, 10, 10);
            Spell attack = new Spell("Attack", 30, 0, 1);
            enemy = new Sorcerer("Sorcerer", 30, staff);
            Weapon claw = new Weapon("Claw", 5, 0);
            Armour hide = new Armour("Hide", 5, 0);
            Summon summon = new Summon("Imp", 10, claw, hide);
            ((Sorcerer) enemy).addSpell(attack);
            ((Sorcerer) enemy).setSummon(summon);
        }
        return enemy;
    }

    public static ITreasure createNewTreasure() {
        ITreasure treasure = new Weapon("", 0, 0);
        int result = (int)(Math.random() * 5 + 1);
        if ( result == 1){
            treasure = new Potion("Mega Heal Potion", 20, 30);
        }else if( result == 2) {
            treasure = new Armour("Plate", 40, 30);
        } else if( result == 3) {
            treasure = new Weapon("Mace", 40, 30);
        } else if( result == 4) {
            treasure = new Staff("Powerful Staff", 30, 30, 200);
        } else if (result == 5){
            treasure = new Spell("Great Spell", 30, 30, 5);
        }

        return treasure;

    }

    public void addPlayer(Player newPlayer){
        this.players.add(newPlayer);
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void start(int noOfRooms) {
        Room room;
        while (noOfRooms > 0){
            room = new Room();
            room.create();
            rooms.add(room);
            noOfRooms --;
        }
    }

    public boolean lost() {
        boolean lost = false;
        for (Room room : rooms)
            if (!room.isComplete()) {
                lost = true;
                break;
            }else {
                lost = false;
            }
        return lost;
    }

    public ArrayList<Room> getRooms() {
        return  this.rooms;
    }
}
