package ps.edu.heldenspiel;

import ps.edu.heldenspiel.hero.Hero;

public class CombatRule {
    public CombatRule() {

    }

    public void fight(Hero hero, Monster monster) {
        Dice diceHero = selectDice();
        Dice diceMonster = selectDice();

        int numberHero = diceHero.rollDice();
        int numberMonster = diceMonster.rollDice();

        System.out.println(hero.getName() + " hat " + numberHero + " gewürfelt mit " + diceHero.getName());
        System.out.println("Das Monster hat " + numberMonster + " gewürfelt mit " + diceMonster.getName());

        if (numberHero > numberMonster) {
            monster.setHealth(monster.getHealth() - 1);
            System.out.println("Monster verliert");
        } else if (numberHero < numberMonster) {
            hero.setHealth(hero.getHealth() - 1);
            System.out.println(hero.getName() + " verliert");
        } else {
            System.out.println("Nichts passiert");
        }

    }

    public Dice selectDice() {
        Dice d2 = new Dice(1, 2, "d2");
        Dice d6 = new Dice(1, 6, "d6");
        Dice d10 = new Dice(1, 10, "d10");
        if (d2.rollDice() == 1) {
            return d10;
        } else {
            return d6;
        }
    }
}
