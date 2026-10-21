package planthotel;
public interface PlantInterface {
  
  // Alla växter måste kunna beräkna sitt vätskebehov.
  double calculateWaterNeed();
  
  // Alla växter måste kunna ange sin vätsketyp.
  LiquidType getLiquidType();
}