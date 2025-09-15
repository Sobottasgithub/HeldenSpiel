package ps.edu.heldenspiel;

import ps.edu.heldenspiel.weapons.Broadsword;

import java.io.IOException;

public class Controller {

    public Controller() throws IOException {
        CombatRule combatRule = new CombatRule();
        Broadsword broadsword = new Broadsword();

        Hero atherion = new Hero("Atherion", 23, broadsword);
        Hero atherion2 = new Hero();
        Monster monster = new Monster(12, 46);

        combatRule.fight(atherion, monster);
    }
}