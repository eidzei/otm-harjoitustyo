
package funktiolaskin.ui;

import funktiolaskin.laskin.SecondFunctions;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;


public class SecondaryFunctionButtons {
    
    private static GridPane secondaryFunctionLayout;
    
    private SecondFunctions functionNow;
    
    public SecondaryFunctionButtons() {
        secondaryFunctionLayout = new GridPane();
        secondaryFunctionLayout.setPadding(new Insets(10, 10, 0, 0));
        secondaryFunctionLayout.setHgap(5);
        secondaryFunctionLayout.setVgap(5);
        
        int column = 0;
        int row = 0;
        for (SecondFunctions funk: SecondFunctions.values()) {
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
                    Display.setMain(Interface.getCalculator().calculateSecondFunction(functionNow, Display.getMain()));
                    Display.setResultDisplayed(true);
                }
            });
            secondaryFunctionLayout.add(funcButton, row, column); 
            row++;
        }
        
        
    }
    
    public static GridPane getFunctions() {
        return secondaryFunctionLayout;
    }
    
    

}
