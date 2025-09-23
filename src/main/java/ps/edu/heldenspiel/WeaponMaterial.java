package ps.edu.heldenspiel;

public enum WeaponMaterial {
  WOOD("wood", 12),
  STONE("stone", 24),
  IRON("iron", 26),
  VANADIUM("vanadium", 1000),
  ;

  private String name;
  private int magic;

  WeaponMaterial(String name, int magic) {
    this.name = name;
    this.magic = magic;
  }

  public int getMagic() {
    return magic;
  }

  public String getName() {
    return name;
  }
}
