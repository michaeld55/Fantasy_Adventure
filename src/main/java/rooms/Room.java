package rooms;

import Enemies.Enemy;
import Enemies.Orc;
import Players.Barbarian;
import Players.Player;
import Resources.Armour;
import Resources.ITreasure;

import java.util.ArrayList;

public class Room {

    private ArrayList<Exit> exits;
    private Enemy enemy;
    private ITreasure treasure;
    private boolean complete;

    public Room() {
        exits = new ArrayList<Exit>();
        complete = false;
    }

    public void addExit(Exit exit) {
        this.exits.add(exit);
    }

    public Exit getExit(Exit exit) {
        if(exits.contains(exit)) return exit;
        return null;
    }

    public Enemy getEnemy() {
        return enemy;
    }

    public void setEnemy(Enemy enemy) {
        this.enemy = enemy;
    }

    public ITreasure getTreasure() {
        return treasure;
    }

    public void setTreasure(ITreasure treasure) {
        this.treasure = treasure;
    }

    public void addEnemy(Enemy enemy) {
        this.enemy = enemy;
    }

    public void addTreasure(ITreasure treasure) {
        this.treasure = treasure;
    }

    public void encounter(Player player) {

        if(enemy != null) {
            int damage = 0;
            while (enemy.getHealth() > 0 || player.getHealth() > 0) {
                damage = player.attack();
                enemy.hit(damage);
                damage = enemy.attack();
                player.hit(damage);
            }
            if(player.getHealth() > 0 && treasure != null){

                player.loot(treasure);

            }
        }

    }
}
