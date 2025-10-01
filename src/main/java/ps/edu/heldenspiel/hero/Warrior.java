package ps.edu.heldenspiel.hero;

import ps.edu.heldenspiel.Weapon;
import java.net.URL;

public class Warrior extends Hero {
  private int endurance = 2;
  protected URL imagePath = getClass().getResource("images/standartHero.png");

  public Warrior(String name, int health, int strength, Weapon weapon) {
    super(name, health, strength, weapon);
  }

  @Override
  public int getAttackDamage() {
    return super.weapon.getDamage(this.strength + this.endurance);
  }

  @Override
  public int getEndurance() {
    return endurance;
  }
}
