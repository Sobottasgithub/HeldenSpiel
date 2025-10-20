package ps.edu.heldenspiel.hero;

import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import ps.edu.heldenspiel.Controller;
import ps.edu.heldenspiel.utils.Dice;
import ps.edu.heldenspiel.weapons.Fist;
import ps.edu.heldenspiel.weapons.Weapon;

public class Priest extends Hero {
  private static final Logger LOGGER = Logger.getLogger(Priest.class.getName());
  Dice d100 = new Dice(0, 100, "d100");

  public Priest() {
    super("Priest", 20, 15, new Fist());
  }

  public Priest(String name, int health, int strength, Weapon weapon) {
    super(name, health, strength, weapon);
  }

  public int getAttackDamage() {
    LOGGER.log(Level.INFO, "DivinusInterventu!");
    if (d100.rollDice() == 100) {
      return 10000;
    }
    return 0;
  }

  @Override
  public URL getImagePath() {
    return Controller.class.getResource("images/priest.png");
  }
}
