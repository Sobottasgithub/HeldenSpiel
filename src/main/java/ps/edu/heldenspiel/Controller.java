package ps.edu.heldenspiel;

import ps.edu.heldenspiel.Weapon;

import java.io.IOException;

public class Controller {

    public Controller() throws IOException {
        CombatRule combatRule = new CombatRule();
        Weapon weapon = new Weapon("wooden sword");
        Hero atherion = new Hero("atherion", 23, 12, weapon);
        Monster monster = new Monster(12, 46);

        combatRule.fight(atherion, monster);
    }
}