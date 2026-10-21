package planthotel;

public class Cactus extends Plant {
  
  // Kaktusen behöver 2 cl, alltså 0,02 liter per dag.
  private static final double LITERS_PER_DAY = 0.02;
  
  public Cactus(String name, double height) {
    super(name, height);
  }
  
  /*
   * ARV: Cactus ärver från Plant.
   *
   * POLYMORFISM: Kaktusen har sin egen implementation.
   * Vätskebehovet påverkas inte av höjden.
   */
  @Override
  public double calculateWaterNeed() {
    return LITERS_PER_DAY;
  }
  
  @Override
  public LiquidType getLiquidType() {
    return LiquidType.MINERAL_WATER;
  }
}