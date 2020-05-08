package Resources;

public class Potion extends Item{

    private int healPoints;

    public Potion(String name, int healPoints) {
        super(name);
        this.healPoints = healPoints;
    }

    public int getHealPoints() {
        return healPoints;
    }
}
