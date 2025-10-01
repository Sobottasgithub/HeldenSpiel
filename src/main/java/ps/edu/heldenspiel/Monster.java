package ps.edu.heldenspiel;

import java.util.Random;

public class Monster {
  int attackDamage;
  int health;

  public Monster() {
    Random random = new Random();

    this.attackDamage = random.nextInt(5,  14);
    this.health = random.nextInt(10, 40);
  }

  public Monster(int attackDamage, int health) {
    this.attackDamage = attackDamage;
    this.health = health;
  }

  public int getAttackDamage() {
    return attackDamage;
  }

  public int getHealth() {
    return health;
  }

  public void setHealth(int health) {
    this.health = health;
  }
}
