
package funktiolaskin.ui;

import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

/**
 * Luokka luo muut näppäimet kuten second ja x
 * 
 * @author eidzey
 */
public class OtherButtons {
    
    public static GridPane othorsLayout;
    
    private final Button scnd;
    private final Button e;
    private final Button pii;
    private final Button random;
    private static Button varX;
    private static boolean secondButton;
    private static double ex = 0.0;
    
    /**
     * Näppäinten asettelu
     */
    public OtherButtons() {
        othorsLayout  = new GridPane();
        othorsLayout.setPadding(new Insets(10, 10, 5, 0));
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
        
        //x nappi
        varX = x();
        othorsLayout.add(varX, 0, 4);
        
    }
    
    //second nappi
    private static Button secondButton() {
        Button second = new Button("2nd");
        second.setMinSize(50, 50);
        second.setStyle("-fx-color: gray");
        second.setOnAction((ActionEvent e1) -> {
            if (!secondButton) {
                second.setStyle("-fx-color: white");
                secondButton = true;
                Interface.getWindow().setCenter(Interface.getSecond());
                varX.setText("x=?");
                
            } else {
                second.setStyle("-fx-color: gray");
                secondButton = false;
                Interface.getWindow().setCenter(Interface.getFunction());
                varX.setText("x");
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
    
    //x 
    private static Button x() {
        Button x = new Button("x");
        x.setMinSize(50, 50);
        x.setStyle("-fx-color: gray");
        x.setOnAction(e -> {
            if (secondButton) {
                ex = Double.valueOf(Display.getMain().getText());
                Display.getMain().clear();    
            } else if (Display.getMain().getText().isEmpty() && !Display.getDisplayed()) {
                Display.getMain().setText(String.valueOf(ex));
            } else if (NumberButtons.getChosenOperator()) {
                Display.getMain().setText(String.valueOf(ex));
            } else if (Display.getMain().getText().isEmpty()) {
                Display.getMain().setText(String.valueOf(ex));
            }
            
            NumberButtons.setChosenOperator(false);
        });
        
        return x;
    }
  
    
    /**
     * Palauttaa muiden näppäinten GridPanen
     * 
     * @return muiden asettelu
     */
    public static GridPane getButtons() {
        return othorsLayout;
    }
}
