package ps.edu.heldenspiel.hero;

import java.net.URL;
import ps.edu.heldenspiel.Controller;
import ps.edu.heldenspiel.utils.Dice;
import ps.edu.heldenspiel.weapons.Dagger;
import ps.edu.heldenspiel.weapons.Weapon;

public class Archer extends Hero {
  private final Dice d100 = new Dice(0, 100, "d100");

  public Archer() {
    super("Archer", 20, 2, new Dagger());
  }

  public Archer(String name, int health, int strength, Weapon weapon) {
    super(name, health, strength, weapon);
  }

  @Override
  public int getAttackDamage() {
    // uses f(x) = 3.75X+25 as a function
    if (d100.rollDice() <= (int) 3.75 * getStrength() + 25) {
      return getWeapon().getAttackDamage() * 2;
    }
    return 0;
  }

  public URL getImagePath() {
    return Controller.class.getResource("images/archer.png");
  }
}
