package ps.edu.heldenspiel.hero;

import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

import ps.edu.heldenspiel.Controller;
import ps.edu.heldenspiel.utils.Dice;
import ps.edu.heldenspiel.weapons.Dagger;
import ps.edu.heldenspiel.weapons.Weapon;

public class Archer extends Hero {
    Dice d100 = new Dice(0, 100, "d100");

    public Archer() {
        super("Archer", 20, 10, new Dagger());
    }

    public Archer(String name, int health, int strength, Weapon weapon) {
        super(name, health, strength, weapon);
    }

    @Override
    public int getAttackDamage() {
        int damage = weapon.getAttackDamage();
        int hitPercentage = (int) 3.75 * strength + 25; // uses f(x) = 3.75X+25 as a function
        if (d100.rollDice() <= hitPercentage) {
            return damage * 2;
        }
        return 0;
    }

    public URL getImagePath() {
        return Controller.class.getResource("images/archer.png");
    }
}