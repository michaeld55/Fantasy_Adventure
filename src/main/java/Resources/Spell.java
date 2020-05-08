package Resources;

public class Spell extends Item{

    private int attackPoints;
    private int healPoints;

    public Spell(String name, int attackPoints, int healPoints) {
        super(name);
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
