package ps.edu.heldenspiel.hero;

import ps.edu.heldenspiel.Controller;
import ps.edu.heldenspiel.weapons.Fist;
import ps.edu.heldenspiel.weapons.Weapon;

import java.net.URL;

public class Magician extends Hero {
  public Magician() {
    super("magician", 12, 12, new Fist());
  }

  public Magician(String name, int health, int strength, Weapon weapon) {
    super(name, health, strength, weapon);
  }

  public void heal() {
    // Set health + weapon damage or set health to max health
    if (this.maxHealth >= this.health + weapon.getAttackDamage()) {
      setHealth(this.health + weapon.getAttackDamage());
    } else {
      setHealth(this.maxHealth);
    }
  }

  public URL getImagePath() {
    return Controller.class.getResource("images/magician.png");
  }
}
