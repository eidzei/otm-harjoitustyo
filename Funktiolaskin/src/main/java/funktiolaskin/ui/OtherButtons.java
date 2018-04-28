
package funktiolaskin.ui;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

public class OtherButtons {
    
    public static GridPane othorsLayout;
    
    private final Button scnd;
    private final Button e;
    private final Button pii;
    private final Button random;
    private static boolean secondButton;
    
    public OtherButtons() {
        othorsLayout  = new GridPane();
        othorsLayout.setPadding(new Insets(10, 10, 0, 0));
        othorsLayout.setHgap(5);
        othorsLayout.setVgap(5);
        
        scnd = secondButton();
        othorsLayout.add(scnd, 0, 0);
        
        //neperin luku
        e = e();
        othorsLayout.add(e, 0, 1);
        
        //pi nappi
        pii = pi();
        othorsLayout.add(pii, 0, 2);
        
        //rand nappi
        random = rand();
        othorsLayout.add(random, 0, 3);
        
    }
    
    //second nappi
    public static Button secondButton() {
        Button second = new Button("2nd");
        second.setMinSize(50, 50);
        second.setStyle("-fx-color: gray");
        second.setOnAction(e -> {
            if (!secondButton) {
                second.setStyle("-fx-color: white");
                secondButton = true;
                Interface.getWindow().setCenter(Interface.getSecond());
            } else {
                second.setStyle("-fx-color: gray");
                secondButton = false;
                Interface.getWindow().setCenter(Interface.getFunction());
            }
        });
        return second;
    }
    
    //e nappi
    private static Button e() {
        Button ee = new Button("e");
        ee.setMinSize(50, 50);
        ee.setStyle("-fx-color: gray");
        ee.setOnAction(e -> {
            if (Display.getMain().getText().isEmpty() && !Display.getDisplayed()) {
                Display.getMain().setText(String.valueOf(Math.E));
              
            } else if (NumberButtons.getChosenOperator()) {
                Display.getMain().setText(String.valueOf(Math.E));
            } else if (Display.getMain().getText().isEmpty()) {
                Display.getMain().setText(String.valueOf(Math.E));
            }
                
            
            NumberButtons.setChosenOperator(false);
        });
        return ee;
    }
    
    //pi nappi
    private static Button pi() {
        Button pi = new Button("\u03C0");
        pi.setMinSize(50, 50);
        pi.setStyle("-fx-color: gray");
        pi.setOnAction(e -> {
            if (Display.getMain().getText().isEmpty() && !Display.getDisplayed()) {
                Display.getMain().setText(String.valueOf(Math.PI));
              
            } else if (NumberButtons.getChosenOperator()) {
                Display.getMain().setText(String.valueOf(Math.PI));
            } else if (Display.getMain().getText().isEmpty()) {
                Display.getMain().setText(String.valueOf(Math.PI));
            }
            
            NumberButtons.setChosenOperator(false);
        });
        return pi;
    }
    
    //random luku
    private static Button rand() {
        Button rand = new Button("rand");
        rand.setMinSize(50, 50);
        rand.setStyle("-fx-color: gray");
        rand.setOnAction(e -> {
            if (Display.getMain().getText().isEmpty() && !Display.getDisplayed()) {
                Display.getMain().setText(String.valueOf(Math.random()));
              
            } else if (NumberButtons.getChosenOperator()) {
                Display.getMain().setText(String.valueOf(Math.random()));
            } else if (Display.getMain().getText().isEmpty()) {
                Display.getMain().setText(String.valueOf(Math.random()));
            }
            
            NumberButtons.setChosenOperator(false);
        });
        return rand;
    }
    
    public static GridPane getButtons() {
        return othorsLayout;
    }
}
