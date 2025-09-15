package ps.edu.heldenspiel.weapons;

public class Broadsword extends Weapon {
    public Broadsword() {
        healthBuff = 2;
        attackDamage = 20;
        strength = 14;
    }

    @Override
    public void makeSound() {
        System.out.println("Krach");
    }
}
