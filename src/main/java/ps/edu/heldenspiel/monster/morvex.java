package ps.edu.heldenspiel.monster;

public class Morvex {
    int attackDamage;
    int health;

    public Morvex(int attackDamage, int health) {
        this.attackDamage = attackDamage;
        this.health = health;
    }

    public int getAttackDamage() {
        return attackDamage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }
}
