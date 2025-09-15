package ps.edu.heldenspiel;

public class CombatRule {
    public CombatRule() {

    }

    public void fight(Hero hero, Monster monster) {
        if(hero.getAttackDamage() > monster.getAttackDamage()) {
            monster.setHealth(monster.getHealth()-hero.getAttackDamage());
            System.out.println("Monster losese Health: " + monster.getHealth());
        } else {
            hero.setHealth(hero.getHealth()-monster.getAttackDamage());
            System.out.println("Hero losese Health: " + hero.getHealth());
        }
    }
}
