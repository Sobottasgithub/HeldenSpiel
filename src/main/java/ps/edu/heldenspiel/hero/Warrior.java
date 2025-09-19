package ps.edu.heldenspiel.hero;

import ps.edu.heldenspiel.Weapon;

public class Warrior extends Hero{
    private int endurance = 2;

    public Warrior(String name, int health, int strength, Weapon weapon) {
        super(name, health, strength, weapon);
    }

    @Override
    public int getAttackDamage() {
        return super.weapon.getDamage(this.strength + this.endurance);
    }
}
