package ps.edu.heldenspiel.hero;

import ps.edu.heldenspiel.Controller;
import ps.edu.heldenspiel.Weapon;
import java.net.URL;

public class Warrior extends Hero {
  private int endurance = 2;

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

  @Override
  public URL getImagePath() {
    return Controller.class.getResource("images/warrior.png");
  }
}
