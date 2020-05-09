package Resources;

public class Staff extends Item {


    private int attackPoints;
    private int healPoints;

    public Staff(String name, int attackPoints, int healPoints, int value) {
        super(name, value);
        this.attackPoints = attackPoints;
        this.healPoints = healPoints;
    }

    public int getAttackPoints() {
        return attackPoints;
    }

    public int getHealPoints() {
        return healPoints;
    }

}
