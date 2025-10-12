package ps.edu.heldenspiel.hero;

import java.net.URL;
import ps.edu.heldenspiel.Controller;
import ps.edu.heldenspiel.weapons.Fist;
import ps.edu.heldenspiel.weapons.Weapon;

public class Warrior extends Hero {
  private int endurance = 2;

  public Warrior() {
    super("Warrior", 16, 14, new Fist());
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
