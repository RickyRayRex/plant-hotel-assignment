package planthotel;

import javax.swing.JOptionPane;
import java.util.Locale;

public class Main {
  
  private static final String DIALOG_TITLE =
      "Växthotellet Greenest";
  
  private static final String QUESTION =
      "Vilken växt ska få vätska?";
  
  private static final String CANCEL_MESSAGE =
      "Du avbröt programmet.";
  
  private static final String EMPTY_INPUT_MESSAGE =
      "Du måste ange ett växtnamn.";
  
  private static final String INVALID_NAME_MESSAGE =
      "Ange ett namn som innehåller minst en bokstav.";
  
  private static final String NOT_FOUND_MESSAGE =
      "Det finns ingen växt med det namnet.";
  
  private static final String RESULT_FORMAT =
      "%s behöver %s liter %s per dag.";
  
  private static final String AMOUNT_FORMAT = "%.2f";
  private static final String SWEDISH_LOCALE = "sv-SE";
  
  static void main(String[] args) {
    
    PlantHotel hotel = new PlantHotel();
    
    // Visar en dialogruta där användaren anger växtens namn.
    String plantName = JOptionPane.showInputDialog(
        null,
        QUESTION,
        DIALOG_TITLE,
        JOptionPane.QUESTION_MESSAGE
                                                  );
    
    // Hanterar om användaren trycker på Avbryt.
    if (plantName == null) {
      showMessage(CANCEL_MESSAGE);
      return;
    }
    
    plantName = plantName.trim();
    
    // Kontrollerar om inmatningen är tom.
    if (plantName.isEmpty()) {
      showMessage(EMPTY_INPUT_MESSAGE);
      return;
    }
    
    // Kontrollerar att inmatningen innehåller minst en bokstav.
    if (!containsLetter(plantName)) {
      showMessage(INVALID_NAME_MESSAGE);
      return;
    }
    
    // Söker efter växten på hotellet.
    Plant selectedPlant = hotel.findPlant(plantName);
    
    if (selectedPlant == null) {
      showMessage(NOT_FOUND_MESSAGE);
      return;
    }
    
    /*
     * POLYMORFISM:
     * Rätt beräkningsformel väljs beroende på växtens typ.
     */
    double waterNeed = selectedPlant.calculateWaterNeed();
    LiquidType liquidType = selectedPlant.getLiquidType();
    
    // Formaterar mängden enligt svensk talformatering.
    String formattedAmount = String.format(
        Locale.forLanguageTag(SWEDISH_LOCALE),
        AMOUNT_FORMAT,
        waterNeed
                                          );
    
    // Visar resultatet i en meddelanderuta.
    showMessage(
        String.format(
            RESULT_FORMAT,
            selectedPlant.getName(),
            formattedAmount,
            liquidType.getDisplayName()
                     )
               );
  }
  
  // Kontrollerar om texten innehåller minst en bokstav.
  private static boolean containsLetter(String input) {
    
    for (char character : input.toCharArray()) {
      if (Character.isLetter(character)) {
        return true;
      }
    }
    
    return false;
  }
  
  // Visar ett meddelande i en dialogruta.
  private static void showMessage(String message) {
    JOptionPane.showMessageDialog(
        null,
        message,
        DIALOG_TITLE,
        JOptionPane.INFORMATION_MESSAGE
                                 );
  }
}