package Enemies;

public abstract class Enemy {

    private String name;
    private int health;

    public Enemy(String name, int health) {
        this.name = name;
        this.health = health;
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

    public abstract void hit(int damage);

    public void wound(){
        this.health -= 1;
    };

    public abstract int attack();

}
