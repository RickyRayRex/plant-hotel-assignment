package planthotel;

public class Palm extends Plant {
  
  private static final double LITERS_PER_METER = 0.5;
  
  public Palm(String name, double height) {
    super(name, height);
  }
  
  /*
   * ARV: Palm ärver från Plant.
   *
   * POLYMORFISM: Klassen implementerar sin egen formel.
   */
  @Override
  public double calculateWaterNeed() {
    return LITERS_PER_METER * getHeight();
  }
  
  @Override
  public LiquidType getLiquidType() {
    return LiquidType.TAP_WATER;
  }
}
