package rooms;

import Enemies.Enemy;
import Enemies.Orc;
import Players.Barbarian;
import Players.Player;
import Resources.ITreasure;
import com.sun.org.apache.xpath.internal.objects.XNull;
import quest.Quest;

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

    public ITreasure getTreasure() {
        return treasure;
    }

    public void addEnemy(Enemy enemy) {
        this.enemy = enemy;
    }

    public void addTreasure(ITreasure treasure) {
        this.treasure = treasure;
    }

    public void encounter(Player player) {

        if(enemy != null) {
            if (player.getHealth() > 0) {
                System.out.println(player.getName() + " You have Encountered An Enemy " + enemy.getName());
                int damage = 0;
                while (enemy.getHealth() > 0 && player.getHealth() > 0) {
                    damage = player.attack();
                    enemy.hit(damage);
                    System.out.println("You Hit The Enemy " + enemy.getName() + " for " + damage + " Damage! It has " + enemy.getHealth() +
                            " Health Left");
                    if (enemy.getHealth() <= 0) break;
                    damage = enemy.attack();
                    player.hit(damage);
                    System.out.println("You Were Hit By The Enemy " + enemy.getName() + " for " + damage + " Damage! You have " + player.getHealth() +
                            " Health Left");
                }
            }

        }
        if (enemy != null){
            if(this.enemy.getHealth() == 0 && treasure == null) {
             this.enemy = null;
             this.complete = true;
            }
        }

        if(player.getHealth() > 0 && treasure != null){
            this.enemy = null;
            System.out.println("You Found A " + treasure.getName());
            player.loot(treasure);

            this.treasure = null;
            this.complete = true;
        }


    }

    public boolean isComplete() {
        return complete;
    }

    public void create() {
        int random = (int)(Math.random() * 2 + 1 );


        if(random == 1){
            Enemy enemy = Quest.createNewEnemy();
            this.addEnemy(enemy);
        }else{
            ITreasure treasure = Quest.createNewTreasure();
            this.addTreasure(treasure);

        }
    }
}
