package planthotel;
public abstract class Plant implements PlantInterface {
  
  private static final double MINIMUM_HEIGHT = 0.0;
  
  private static final String EMPTY_NAME_ERROR = "Plant name cannot be empty.";
  private static final String INVALID_HEIGHT_ERROR = "Plant height must be positive and finite.";
  
  /*
   * INKAPSLING:
   * Attributen är private och final.
   * De kan inte ändras direkt från andra klasser.
   */
  private final String name;
  private final double height;
  
  public Plant(String name, double height) {
    
    if (name == null || name.isBlank()) {
      throw new IllegalArgumentException(EMPTY_NAME_ERROR);
    }
    
    if (!Double.isFinite(height) || height <= MINIMUM_HEIGHT) {
      throw new IllegalArgumentException(INVALID_HEIGHT_ERROR);
    }
    
    this.name = name.trim();
    this.height = height;
  }
  
  public String getName() {
    return name;
  }
  
  public double getHeight() {
    return height;
  }
}
