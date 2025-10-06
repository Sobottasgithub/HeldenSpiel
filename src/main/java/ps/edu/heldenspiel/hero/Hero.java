package ps.edu.heldenspiel.hero;

import ps.edu.heldenspiel.Application;
import ps.edu.heldenspiel.Controller;
import ps.edu.heldenspiel.weapons.Weapon;

import java.net.URL;

import java.util.logging.Logger;
import java.util.logging.Level;

public class Hero {
  private static final Logger LOGGER = Logger.getLogger(Hero.class.getName());

  private String name;
  protected int strength;
  protected int health;
  protected int maxHealth;
  protected int endurance = 0;
  Weapon weapon;

  public Hero(String name, int health, int strength, Weapon weapon) {
    LOGGER.log(Level.INFO, "Init hero...");
    this.name = name;
    this.strength = strength;
    this.health = health;
    this.weapon = weapon;
    this.maxHealth = health;
  }

  public Hero(String name, int health, int strength, int endurance, Weapon weapon) {
    LOGGER.log(Level.INFO, "Init hero...");
    this.name = name;
    this.strength = strength;
    this.health = health;
    this.endurance = endurance;
    this.weapon = weapon;
    this.maxHealth = health;
  }

  public int getAttackDamage() {
    return this.strength + weapon.getAttackDamage();
  }

  public void setWeapon(Weapon weapon) {
    this.weapon = weapon;
  }

  public Weapon getWeapon() {
    return weapon;
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
    // Prevent health dropping below 0
    if (health >= 0) {
      this.health = health;
    } else {
      this.health = 0;
    }
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
