package ps.edu.heldenspiel;

public class Controller {

    public Controller() {
        CombatRule combatRule = new CombatRule();
        Weapon woodSword = new Weapon("sword", WeaponMaterial.WOOD);
        Hero atherion = new Hero("atherion", 23, 12, woodSword);
        Monster monster = new Monster(12, 46);

        while (atherion.getHealth() > 0 && monster.getHealth() > 0) {
            combatRule.fight(atherion, monster);
            try {
                Thread.sleep(1000); // Sleep for 2 seconds
            } catch (InterruptedException e) {
            }
        }
        if (atherion.getHealth() == 0) {
            System.out.println("Hero loses!");
        } else {
            System.out.println("Monster loses!");
        }
    }

    public static void main(String[] args) {
        new Controller();
    }
}