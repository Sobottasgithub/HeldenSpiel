package ps.edu.heldenspiel;

import java.io.IOException;

public class Controller {

    public Controller() throws IOException {
        CombatRule combatRule = new CombatRule();

        Hero atherion = new Hero("Atherion", 11, 11, 32);
        Monster monster = new Monster(12, 46);

        combatRule.fight(atherion, monster);
    }
}