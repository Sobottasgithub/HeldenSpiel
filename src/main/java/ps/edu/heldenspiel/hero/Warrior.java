package ps.edu.heldenspiel.hero;

import ps.edu.heldenspiel.Controller;
import ps.edu.heldenspiel.weapons.Weapon;
import ps.edu.heldenspiel.weapons.Fist;

import java.net.URL;

public class Warrior extends Hero {
  private int endurance = 2;

  public Warrior() {
    super("warrior", 16, 14, new Fist());
  }

  public Warrior(String name, int health, int strength, Weapon weapon) {
    super(name, health, strength, weapon);
  }

  @Override
  public int getAttackDamage() {
    return this.strength + this.endurance + this.weapon.getAttackDamage();
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
