package ps.edu.heldenspiel.weapons;

public class Dagger extends Weapon {
    public Dagger() {
        healthBuff = 1;
        attackDamage = 19;
        strength = 12;
    }

    @Override
    public void makeSound() {
        System.out.println("Ding");
    }
}
