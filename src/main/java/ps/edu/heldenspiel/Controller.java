package ps.edu.heldenspiel;

public class Controller {

    public Controller() {
        HeroParty heroParty = new HeroParty();

        Monster monster = new Monster(12, 46);

        CombatRule combatRule = new CombatRule();

        while (heroParty.getHealth() > 0 && monster.getHealth() > 0) { // TODO: FIX (NOT ENOUGH TIME)
            combatRule.fight(heroParty.get(0), monster);
            try {
                Thread.sleep(1000); // Sleep for 2 seconds
            } catch (InterruptedException e) {
            }
        }
        if (heroParty.getHealth() == 0) { // TODO: FIX (NOT ENOUGH TIME)
            System.out.println("Hero loses!");
        } else {
            System.out.println("Monster loses!");
        }
    }

    public static void main(String[] args) {
        new Controller();
    }
}