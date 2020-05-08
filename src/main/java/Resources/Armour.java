package Resources;

public class Armour extends Item implements ITreasure{


    private int armourPoint;

    public Armour(String name, int armourPoint, int value) {
        super(name, value);
        this.armourPoint = armourPoint;

    }


    public int getArmourPoint() {
        return armourPoint;
    }

    public Item giveItem(Item item) {
        return this;
    }

    public void damage() {
        this.armourPoint -= 1;
    }
}
