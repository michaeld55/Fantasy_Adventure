package Players;

import Resources.ITreasure;

public abstract class Player {

    private String name;
    private int health;
    private int pouch;

    public Player(String name, int health) {
        this.name = name;
        this.health = health;
        this.pouch = 0;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getPouch() {
        return pouch;
    }

    public void setPouch(int pouch) {
        this.pouch = pouch;
    }

    public abstract void hit(int damage);

    public void wound(){
        this.health -= 1;
    };

    public abstract int attack();

    public abstract void loot(ITreasure treasure);

    public void sellItem(ITreasure treasure){
        this.pouch += treasure.getValue();
    };
}
