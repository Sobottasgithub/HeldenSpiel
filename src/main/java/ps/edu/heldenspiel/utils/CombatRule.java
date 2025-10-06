package ps.edu.heldenspiel.utils;

import ps.edu.heldenspiel.hero.Hero;

public class CombatRule {
  int heroDiceRoll;
  int monsterDiceRoll;

  public CombatRule() {}

  public EntityType fight() {
    Dice diceHero = selectDice();
    Dice diceMonster = selectDice();

    this.heroDiceRoll = diceHero.rollDice();
    this.monsterDiceRoll = diceMonster.rollDice();

    if (this.heroDiceRoll > this.monsterDiceRoll) {
      // Hero wins
      return EntityType.HERO;
    } else if (this.heroDiceRoll < this.monsterDiceRoll) {
      // Monster wins
      return EntityType.MONSTER;
    } else {
      // No winner
      return EntityType.NONE;
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

  public int getHeroDiceResult() {
    return this.heroDiceRoll;
  }

  public int getMonsterDiceRoll() {
    return this.monsterDiceRoll;
  }
}
