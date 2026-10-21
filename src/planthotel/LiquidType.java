package planthotel;
public enum LiquidType {
  
  TAP_WATER("kranvatten"),
  MINERAL_WATER("mineralvatten"),
  PROTEIN_DRINK("proteindryck");
  
  private final String displayName;
  
  // Sparar vätskans svenska visningsnamn.
  LiquidType(String displayName) {
    this.displayName = displayName;
  }
  
  // Hämtar vätskans visningsnamn.
  public String getDisplayName() {
    return displayName;
  }
}