package ps.edu.heldenspiel.utils;

import java.util.logging.Level;
import java.util.logging.Logger;

public class CombatRule {
  private static final Logger LOGGER = Logger.getLogger(CombatRule.class.getName());

  private int heroDiceRoll;
  private int monsterDiceRoll;
  private String diceHeroName;
  private String diceMonsterName;

  public CombatRule() {}

  public EntityType fight() {
    LOGGER.log(Level.INFO, "Fight triggered...");
    Dice diceHero = selectDice();
    Dice diceMonster = selectDice();

    diceHeroName = diceHero.getName();
    diceMonsterName = diceMonster.getName();

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
    LOGGER.log(Level.INFO, "Select dice...");
    Dice d2 = new Dice(1, 2, "2");
    Dice d6 = new Dice(1, 6, "6");
    Dice d10 = new Dice(1, 10, "10");
    if (d2.rollDice() == 1) {
      return d10;
    } else {
      return d6;
    }
  }

  public int getHeroDiceResult() {
    return heroDiceRoll;
  }

  public int getMonsterDiceRoll() {
    return monsterDiceRoll;
  }

  public String getDiceHeroName() {
    return diceHeroName;
  }

  public String getDiceMonsterName() {
    return diceMonsterName;
  }
}
