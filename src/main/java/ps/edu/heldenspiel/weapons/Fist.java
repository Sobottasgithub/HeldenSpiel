package ps.edu.heldenspiel.weapons;

public class Fist implements Weapon {
  private int healthBuff = 0;
  private int attackDamage = 17;
  private int strength = 11;

  @Override
  public int getHealthBuff() {
    return healthBuff;
  }

  @Override
  public int getAttackDamage() {
    return attackDamage;
  }

  @Override
  public int getStrength() {
    return strength;
  }
}
