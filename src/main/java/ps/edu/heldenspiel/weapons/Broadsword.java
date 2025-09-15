package ps.edu.heldenspiel.weapons;

import ps.edu.heldenspiel.Hero;

public class Broadsword implements Weapon{
    private int healthBuff = 2;
    private int attackDamage = 20;
    private int strength = 14;

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
