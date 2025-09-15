package ps.edu.heldenspiel.weapons;

public abstract class Weapon {
    int healthBuff;
    int attackDamage;
    int strength;

    public int getHealthBuff() {
        return healthBuff;
    }

    public int getAttackDamage() {
        return attackDamage;
    }

    public int getStrength() {
        return strength;
    }

    abstract public void makeSound();

    public void hit(Weapon w2) {
        makeSound();
        w2.makeSound();
    }
}
