package ps.edu.heldenspiel.hero;

import ps.edu.heldenspiel.Weapon;

public class Magician extends Hero {
    public Magician(String name, int health, int strength, Weapon weapon) {
        super(name, health, strength, weapon);
    }

    public void healFriendly(Hero friendlyToHeal) {
        if(friendlyToHeal.getMaxHealth() >= friendlyToHeal.getHealth() + weapon.getMagic()) {
        	friendlyToHeal.setHealth(friendlyToHeal.getHealth() + weapon.getMagic());
        } else {
            friendlyToHeal.setHealth(friendlyToHeal.getMaxHealth());
        }
    }
}
