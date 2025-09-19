package ps.edu.heldenspiel.hero;

import ps.edu.heldenspiel.CombatRule;
import ps.edu.heldenspiel.Weapon;

public abstract class Hero {
    private String name;
    private int strength;
    private int health;

    Weapon weapon;
    CombatRule combatRule = new CombatRule();

    public Hero(String name, int health, int strength, Weapon weapon) {
        this.name = name;
        this.strength = strength;
        this.health = health;
        this.weapon = weapon;
    }

    public int getAttackDamage() {
        return weapon.getDamage(this.strength);
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public String getName() {
        return this.name;
    }

    public int getHealth() {
        return this.health;
    }

    public int getStrength() {
        return this.strength;
    }

    public void setHealth(int health) {
        this.health = health;
    }
}
