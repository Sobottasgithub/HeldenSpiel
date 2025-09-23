package ps.edu.heldenspiel;

public class Monster {
  int attackDamage;
  int health;

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
