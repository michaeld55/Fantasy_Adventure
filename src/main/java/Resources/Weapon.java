package Resources;

public class Weapon extends Item implements ITreasure{

    private int damage;

    public Weapon(String name, int damage, int value) {
        super(name, value);
        this.damage = damage;
    }

    public int getDamage() {
        return damage;
    }

}
