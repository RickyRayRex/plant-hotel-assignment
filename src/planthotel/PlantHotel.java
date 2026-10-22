package planthotel;

import java.util.ArrayList;
import java.util.List;

public class PlantHotel {
  
  private static final String LAURA_NAME = "Laura";
  private static final String OLOF_NAME = "Olof";
  private static final String IGGE_NAME = "Igge";
  private static final String MEATLOAF_NAME = "Meatloaf";
  
  private static final double LAURA_HEIGHT_METERS = 5.0;
  private static final double OLOF_HEIGHT_METERS = 1.0;
  private static final double IGGE_HEIGHT_CENTIMETERS = 20.0;
  private static final double MEATLOAF_HEIGHT_METERS = 0.7;
  
  private static final double CENTIMETERS_PER_METER = 100.0;
  
  /*
   * POLYMORFISM:
   * Listan innehåller Plant-objekt av olika undertyper.
   */
  private final List<Plant> plants = new ArrayList<>();
  
  public PlantHotel() {
    addPlants();
  }
  
  // Skapar och registrerar alla växter.
  private void addPlants() {
    
    plants.add(new Palm(LAURA_NAME, LAURA_HEIGHT_METERS));
    plants.add(new Palm(OLOF_NAME, OLOF_HEIGHT_METERS));
    plants.add(new CarnivorousPlant(MEATLOAF_NAME, MEATLOAF_HEIGHT_METERS));
    
    // Omvandlar Igges höjd från centimeter till meter.
    double iggeHeightMeters = IGGE_HEIGHT_CENTIMETERS / CENTIMETERS_PER_METER;
    
    plants.add(new Cactus(IGGE_NAME, iggeHeightMeters));
  }
  
  // Söker efter en växt med hjälp av dess namn.
  public Plant findPlant(String name) {
    
    if(name == null || name.isBlank()) {
      return null;
    }
    
    for(Plant plant : plants) {
      
      if(plant.getName().equalsIgnoreCase(name.trim())) {
        return plant;
      }
    }
    return null;
  }
}