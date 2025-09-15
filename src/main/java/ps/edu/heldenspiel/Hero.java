package ps.edu.heldenspiel;

public class Hero {
    String name;
    int strength;
    int attackDamage;
    int health;

    Weapon weapon;
    CombatRule combatRule = new CombatRule();

    public Hero() {
        this.name = "Atherion";
        this.strength = 11;
        this.health = 23;
        Weapon weapon = new Weapon("wooden sword");
        this.attackDamage = weapon.calcBonus(this.strength);
    }

    public Hero(String name, int health, int strength, Weapon weapon) {
        this.name = name;
        this.strength = strength;
        this.health = health;
        this.attackDamage = weapon.calcBonus(this.strength);
    }

    public int getAttackDamage() {
        return this.attackDamage;
    }

    public void setAttackDamage(int attackDamage) {
        this.attackDamage = attackDamage;
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
