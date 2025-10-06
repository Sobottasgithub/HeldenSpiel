package ps.edu.heldenspiel.utils;

import java.util.Random;

public class Monster {
  int attackDamage;
  int health;
  int maxHealth;

  public Monster() {
    Random random = new Random();

    this.attackDamage = random.nextInt(5,  14);
    this.health = random.nextInt(10, 40);
    this.maxHealth = this.health;
  }

  public Monster(int attackDamage, int health) {
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
