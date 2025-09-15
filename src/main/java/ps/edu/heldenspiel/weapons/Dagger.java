package ps.edu.heldenspiel.weapons;

import ps.edu.heldenspiel.Hero;

public class Dagger implements Weapon{
    private int healthBuff = 1;
    private int attackDamage = 19;
    private int strength = 12;

    @Override
    public int getHealthBuff() {
        return healthBuff;
    }

    @Override
    public int getAttackDamage() {
        return attackDamage;
    }

    @Override
    public int getStrength() {
        return strength;
    }
}
