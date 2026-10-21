package planthotel;

public class CarnivorousPlant extends Plant {
  
  private static final double BASE_AMOUNT = 0.1;
  private static final double LITERS_PER_METER = 0.2;
  
  public CarnivorousPlant(String name, double height) {
    super(name, height);
  }
  
  /*
   * ARV: CarnivorousPlant ärver från Plant.
   *
   * POLYMORFISM: Klassen använder sin egen beräkningsformel.
   */
  @Override
  public double calculateWaterNeed() {
    return BASE_AMOUNT + LITERS_PER_METER * getHeight();
  }
  
  @Override
  public LiquidType getLiquidType() {
    return LiquidType.PROTEIN_DRINK;
  }
}