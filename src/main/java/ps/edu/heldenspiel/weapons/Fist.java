package ps.edu.heldenspiel.weapons;

public class Fist extends Weapon {
    public Fist() {
        healthBuff = 0;
        attackDamage = 17;
        strength = 11;
    }

    @Override
    public void makeSound() {
        System.out.println("pow");
    }
}