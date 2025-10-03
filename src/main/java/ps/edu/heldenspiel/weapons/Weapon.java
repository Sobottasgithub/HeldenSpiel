package ps.edu.heldenspiel.weapons;

public abstract class Weapon {
    protected String name = "";
    protected int attackDamage = 0;

    public String getName() {
        return name;
    }

    public int getAttackDamage() {
        return attackDamage;
    }
}
