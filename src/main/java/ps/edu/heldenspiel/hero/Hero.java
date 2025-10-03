package ps.edu.heldenspiel.hero;

import ps.edu.heldenspiel.CombatRule;
import ps.edu.heldenspiel.Controller;
import ps.edu.heldenspiel.Weapon;

import java.net.URL;

public class Hero {
  private String name;
  protected int strength;
  protected int health;
  protected int maxHealth;
  protected int endurance = 0;

  Weapon weapon;
  CombatRule combatRule = new CombatRule();

  public Hero(String name, int health, int strength, Weapon weapon) {
    this.name = name;
    this.strength = strength;
    this.health = health;
    this.weapon = weapon;
    this.maxHealth = health;
  }

  public Hero(String name, int health, int strength, int endurance, Weapon weapon) {
    this.name = name;
    this.strength = strength;
    this.health = health;
    this.endurance = endurance;
    this.weapon = weapon;
    this.maxHealth = health;
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

  public int getMaxHealth() {
    return maxHealth;
  }

  public int getEndurance() {
    return endurance;
  }

  public URL getImagePath() {
    return Controller.class.getResource("images/standartHero.png");
  }
}
