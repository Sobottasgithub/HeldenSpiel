package ps.edu.heldenspiel;

public class Weapon {
    private String name;
    private int magic;

    public Weapon(String name) {
        this.name = name;

        if(name == "wooden sword") {
            this.magic = 12;
        } else if(name == "stone sword") {
            this.magic = 24;
        } else if(name == "iron sword") {
            this.magic = 26;
        } else {
            magic = 1;
        }
    }

    public int calcBonus(int strength) {
        return magic+strength;
    }

    public String getName() {
        return this.name;
    }

    public int getMagic() {
        return this.magic;
    }
}
