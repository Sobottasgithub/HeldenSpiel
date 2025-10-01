package ps.edu.heldenspiel;

public class Controller {

  public Controller() {
    HeroParty heroParty = new HeroParty();
    Monster monster = new Monster();
    CombatRule combatRule = new CombatRule();
  }

  public static void main(String[] args) {
    new Controller();
  }
}
