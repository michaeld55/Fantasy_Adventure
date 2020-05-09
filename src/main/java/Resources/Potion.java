package Resources;

public class Potion extends Item {

    private int healPoints;

    public Potion(String name, int healPoints, int value) {
        super(name, value);
        this.healPoints = healPoints;
    }

    public int getHealPoints() {
        return healPoints;
    }
}
