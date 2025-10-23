package ps.edu.heldenspiel.utils;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Monster {
  private static final Logger LOGGER = Logger.getLogger(Monster.class.getName());

  private final int attackDamage;
  private int health;
  private final int maxHealth;

  private static final Random random = new Random();

  public Monster() {
    this(random.nextInt(1, 6), random.nextInt(10, 40));
  }

  public Monster(int attackDamage, int health) {
    LOGGER.log(Level.INFO, "Init Monster...");
    this.attackDamage = attackDamage;
    this.health = maxHealth = health;
  }

  public int getAttackDamage() {
    return attackDamage;
  }

  public int getHealth() {
    return health;
  }

  public int getMaxHealth() {
    return maxHealth;
  }

  public void setHealth(int health) {
    this.health = (health >= 0) ? health : 0;
  }
}
