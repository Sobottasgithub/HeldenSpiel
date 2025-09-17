package ps.edu.heldenspiel;

public class CombatRule {
    public CombatRule() {

    }

    public void fight(Hero hero, Monster monster) {
        Dice diceHero = selectDice();
        Dice diceMonster = selectDice();

        int numberHero = diceHero.rollDice();
        int numberMonster = diceMonster.rollDice();

        System.out.println(hero.getName() + " hat " + numberHero + " gewürfelt mit " + diceHero);
        System.out.println("Das Monster hat " + numberMonster + " gewürfelt mit " + diceMonster);

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
        Dice d2 = new Dice(1, 2);
        Dice d6 = new Dice(1, 6);
        Dice d10 = new Dice(1, 10);
        if (d2.rollDice() == 1) {
            return d10;
        } else {
            return d6;
        }
    }
}
