package ps.edu.heldenspiel.utils;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Monster {
  private static final Logger LOGGER = Logger.getLogger(Monster.class.getName());

  int attackDamage;
  int health;
  int maxHealth;

  public Monster() {
    LOGGER.log(Level.INFO, "Init Monster...");
    Random random = new Random();

    this.attackDamage = random.nextInt(1, 6);
    this.health = random.nextInt(10, 40);
    this.maxHealth = this.health;
  }

  public Monster(int attackDamage, int health) {
    LOGGER.log(Level.INFO, "Init Monster...");
    this.attackDamage = attackDamage;
    this.health = health;
    this.maxHealth = this.health;
  }

  public int getAttackDamage() {
    return attackDamage;
  }

  public int getHealth() {
    return health;
  }

  public void setHealth(int health) {
    if (health >= 0) {
      this.health = health;
    } else {
      this.health = 0;
    }
  }

  public int getMaxHealth() {
    return this.maxHealth;
  }
}
