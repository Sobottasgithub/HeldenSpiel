package ps.edu.heldenspiel;

import java.util.Random;

public class Dice {
    private int start;
    private int end;
    private String name;
    Random dice = new Random();

    public Dice() {
    }

    public Dice(int start, int end, String name) {
        this.name = name;
        setSides(start, end);
    }

    public void setSides(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int rollDice() {
        return this.dice.nextInt(start, end);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
