package ps.edu.heldenspiel;

public class Hero {
    String name;
    int strength;
    int attackDamage;
    int health;

    CombatRule combatRule = new CombatRule();

    public Hero() {
        this.name = "Atherion";
        this.strength = 11;
        this.attackDamage = 17;
        this.health = 23;
    }

    public Hero(String name, int strength, int attackStrength, int health) {
        this.name = name;
        this.strength = strength;
        this.attackDamage = attackStrength;
        this.health = health;
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
