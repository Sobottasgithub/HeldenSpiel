package ps.edu.heldenspiel.hero;

import ps.edu.heldenspiel.Weapon;

public class Magician extends Hero {
    public Magician(String name, int health, int strength, Weapon weapon) {
        super(name, health, strength, weapon);
    }

    public void healFriendly(Hero friendlyToHeal) {
        friendlyToHeal.setHealth(friendlyToHeal.getHealth() + weapon.getMagic());
    }
}
