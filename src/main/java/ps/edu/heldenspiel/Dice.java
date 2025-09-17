package ps.edu.heldenspiel;

import java.util.Random;

public class Dice {
    private int start;
    private int end;
    Random dice = new Random();

    public Dice() {
    }

    public Dice(int start, int end) {
        setSides(start, end);
    }

    public void setSides(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int rollDice() {
        return this.dice.nextInt(start, end);
    }
}
