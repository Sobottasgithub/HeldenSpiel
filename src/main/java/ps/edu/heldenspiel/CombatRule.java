package ps.edu.heldenspiel;

public class CombatRule {
    public CombatRule() {

    }

    public void fight(Hero hero, Monster monster) {
        if(hero.getAttackDamage() > monster.getAttackDamage()) {
            monster.setHealth(monster.getHealth()-1);
            System.out.println("Monster losese Health: " + monster.getHealth());
        } else {
            hero.setHealth(hero.getHealth()-1);
            System.out.println("Hero losese Health: " + hero.getHealth());
        }
    }
}
