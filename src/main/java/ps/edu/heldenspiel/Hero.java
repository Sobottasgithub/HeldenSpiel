package ps.edu.heldenspiel;

import ps.edu.heldenspiel.weapons.Fist;
import ps.edu.heldenspiel.weapons.Weapon;

public class Hero {
    String name;
    int strength;
    int attackDamage;
    int health;

    Weapon weapon;
    CombatRule combatRule = new CombatRule();

    public Hero() {
        this.weapon = new Fist();
        this.name = "Atherion";
        this.strength = weapon.getStrength();
        this.attackDamage = weapon.getAttackDamage();
        this.health = 23 - weapon.getHealthBuff();

        System.out.println("Weapon " + this.weapon +" \n Strength" + this.strength +" \n Damage" + this.attackDamage +" \n Health " + this.health);
    }

    public Hero(String name, int health, Weapon weapon) {
        this.weapon = weapon;
        this.name = name;
        this.strength = this.weapon.getStrength();
        this.attackDamage = this.weapon.getAttackDamage();
        this.health = health - this.weapon.getHealthBuff();

        System.out.println("Weapon " + this.weapon +" \n Strength" + this.strength +" \n Damage" + this.attackDamage +" \n Health " + this.health);
    }

    public int getAttackDamage() {
        return this.attackDamage;
    }

    public String getName() {
        return this.name;
    }

    public int getHealth() {
        return this.health;
    }

    public void setHealth(int health) {
        this.health = health;
    }
}
