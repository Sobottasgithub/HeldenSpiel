package ps.edu.heldenspiel;

public class Weapon {
  private String name;
  private WeaponMaterial weaponMaterial;

  public Weapon(String name, WeaponMaterial weaponMaterial) {
    this.name = name;
    this.weaponMaterial = weaponMaterial;
  }

  public int getDamage(int strength) {
    return getMagic() + strength;
  }

  public String getName() {
    return name;
  }

  public int getMagic() {
    return weaponMaterial.getMagic();
  }

  public String getMaterial() {
    return weaponMaterial.getName();
  }
}
