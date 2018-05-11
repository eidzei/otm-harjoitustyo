
package funktiolaskin.ui;

import funktiolaskin.laskin.Functions;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

/**
 * Luokka luo funktionäppäinten asettelun ja toiminnot 
 * @author eidzey
 */
public class FunctionButtons {
    
    private static GridPane functionLayout;
    
    private Functions functionNow;
    
    /**
     * Funktionappine asettelu ja toiminnot 
     */
    public FunctionButtons() {
        functionLayout = new GridPane();
        functionLayout.setPadding(new Insets(10, 10, 5, 0));
        functionLayout.setHgap(5);
        functionLayout.setVgap(5);
        
        int column = 0;
        int row = 0;
        for (Functions funk: Functions.values()) {
            if (row == 2) {
                row = 0;
                column++;
            }
            String symbol = funk.toString();
            Button funcButton = new Button(symbol);
            funcButton.setMinSize(50, 50);
            funcButton.setStyle("-fx-color: gray");
            funcButton.setOnAction(e-> {
                if (Display.getSecondary().getText().isEmpty() && !Display.getMain().getText().isEmpty()) {
                    //apuNaytto.setText(funk+ "(" + naytto.getText() + ")");
                    functionNow = funk;
                    Display.setMain(Interface.getCalculator().calculateFunction(functionNow, Display.getMain()));
                    Display.setResultDisplayed(true);
                }
            });
            functionLayout.add(funcButton, row, column); 
            row++;
        }
        
        
    }
    
    /**
     * Metodi palauttaa funktionapit
     * 
     * @return funktionapit
     */
    public static GridPane getFunctions() {
        return functionLayout;
    }
    
    

}
