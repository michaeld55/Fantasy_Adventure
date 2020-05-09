package Resources;

public class Armour extends Item {


    private int armourPoint;

    public Armour(String name, int armourPoint, int value) {
        super(name, value);
        this.armourPoint = armourPoint;

    }


    public int getArmourPoint() {
        return armourPoint;
    }

    public void damage() {
        this.armourPoint -= 1;
    }
}
