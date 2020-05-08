package Resources;

public class Potion {
    private String name;
    private int healPoints;

    public Potion(String name, int healPoints) {
        this.name = name;
        this.healPoints = healPoints;
    }

    public String getName() {
        return name;
    }

    public int getHealPoints() {
        return healPoints;
    }
}
