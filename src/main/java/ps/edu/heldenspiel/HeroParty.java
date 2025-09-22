package ps.edu.heldenspiel;

import ps.edu.heldenspiel.hero.Hero;
import ps.edu.heldenspiel.hero.Magician;
import ps.edu.heldenspiel.hero.Warrior;

public class HeroParty {
    public HeroParty() {
        Weapon woodSword = new Weapon("sword", WeaponMaterial.WOOD);
        Hero atherion = new Magician("atherion", 23, 12, woodSword);
        Hero magerion = new Warrior("magerion", 23, 12, woodSword);
        Hero kagerion = new Warrior("kagerion", 23, 12, woodSword);
        Hero wagerion = new Warrior("wagerion", 23, 12, woodSword);
    }
}
