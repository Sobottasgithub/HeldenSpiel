package ps.edu.heldenspiel.hero;

import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import ps.edu.heldenspiel.Controller;
import ps.edu.heldenspiel.weapons.Weapon;

public class Hero {
  private static final Logger LOGGER = Logger.getLogger(Hero.class.getName());

  private final String name;
  private final int strength;
  private int health;
  private final int maxHealth;
  private final int endurance;
  private Weapon weapon;

  public Hero(String name, int health, int strength, Weapon weapon) {
    this(name, health, strength, 0, weapon);
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
    return strength + weapon.getAttackDamage();
  }

  public void setWeapon(Weapon weapon) {
    this.weapon = weapon;
  }

  public Weapon getWeapon() {
    return weapon;
  }

  public String getName() {
    return name;
  }

  public int getHealth() {
    return health;
  }

  public int getStrength() {
    return strength;
  }

  public void setHealth(int health) {
    // Prevent health dropping below 0
    this.health = (health >= 0) ? health : 0;
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
