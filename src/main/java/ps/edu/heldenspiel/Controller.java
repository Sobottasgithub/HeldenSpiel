package ps.edu.heldenspiel;

<<<<<<< HEAD
import ps.edu.heldenspiel.Weapon;

import java.io.IOException;

=======
>>>>>>> cfd776e (Changed Weapon material structure)
public class Controller {

    public Controller() {
        CombatRule combatRule = new CombatRule();
        Weapon woodSword = new Weapon("sword", WeaponMaterial.WOOD);
        Hero atherion = new Hero("atherion", 23, 12, woodSword);
        Monster monster = new Monster(12, 46);

        combatRule.fight(atherion, monster);
    }

    public static void main(String[] args) {
        new Controller();
    }
}