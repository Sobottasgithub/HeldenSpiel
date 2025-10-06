package ps.edu.heldenspiel.utils;

import ps.edu.heldenspiel.Application;

import java.util.Random;

import java.util.logging.Logger;
import java.util.logging.Level;

public class Dice {
  private static final Logger LOGGER = Logger.getLogger(Dice.class.getName());

  private int start;
  private int end;
  private String name;
  Random dice = new Random();

  public Dice() {}

  public Dice(int start, int end, String name) {
    LOGGER.log(Level.INFO, "Init dice...");
    this.name = name;
    setSides(start, end);
  }

  public void setSides(int start, int end) {
    LOGGER.log(Level.INFO, "Set sides...");
    this.start = start;
    this.end = end;
  }

  public int rollDice() {
    LOGGER.log(Level.INFO, "Roll dice...");
    return this.dice.nextInt(start, end + 1);
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
