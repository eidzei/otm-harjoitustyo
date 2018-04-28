
package funktiolaskin.ui;

import funktiolaskin.laskin.*;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;


public class NumberButtons {
    
    private static GridPane buttonLayout;
    
    private final Button clear;
    private final Button backspace;
    private final Button[] numbers;
    private final Button dot;
    private final Button equals;
    
    private static Operators operatorNow;
    
    private static boolean chosenOperator;
    
    public NumberButtons() {
        buttonLayout = new GridPane();
        buttonLayout.setPadding(new Insets(10, 0, 0, 0));
        buttonLayout.setHgap(5);
        buttonLayout.setVgap(5);
        
        //clear
        clear = clear();
        GridPane.setColumnSpan(clear, 2);
        buttonLayout.add(clear, 0, 0);
        
        //backspace
        backspace = backspace();
        buttonLayout.add(backspace, 2, 0);
        
        //luodaan numeronapit
        numbers = numbers();
              
        //desimaalipiste
        dot = decimal();
        
        //operaationapit
        operations();
        
        //on yhta kuin nappi
        equals = equals();

    }
    
    //clear
    private Button clear() {
        Button clr = new Button("clear");
        clr.setMinSize(105, 50);
        clr.setOnAction(e -> {
            Display.getMain().clear();
            Display.getSecondary().clear();
            chosenOperator = false;
        });
        
        return clr;
    }
    
    //takaisin
    private Button backspace() {
        Button bckspc = new Button("\u2190");
        bckspc.setMinSize(50, 50);
        bckspc.setOnAction(e-> {
            String teksti = Display.getMain().getText();
            if (!teksti.isEmpty() && !Display.getDisplayed()) {
                Display.getMain().setText(teksti.substring(0, teksti.length() - 1));
            }
        });
        
        return bckspc;
    }
    
    private Button[] numbers() {
        //numerotnäppäimet
        Button[] numeroNappi = new Button[10];
        for (int i = 3, kohde = 1; i >= 1; i--) {
            for (int j = 0; j <= 2; j++) {
                String numero = Integer.toString(kohde);
                
                numeroNappi[kohde] = new Button(numero);
                numeroNappi[kohde].setMinSize(50, 50);
                numeroNappi[kohde].setOnAction(e -> {
                    if (Display.getDisplayed()) {
                        Display.getMain().setText(numero);
                        Display.setResultDisplayed(false);
                    } else {
                        Display.getMain().appendText(numero);
                    }
                    chosenOperator = false;
                });
                buttonLayout.add(numeroNappi[kohde++], j, i);
            }
        }
        
        //nolla
        numeroNappi[0] = new Button("0");
        numeroNappi[0].setMinSize(105, 50);
        numeroNappi[0].setOnAction(e -> {
            if (Display.getDisplayed()) {
                Display.getMain().setText("0");
                Display.setResultDisplayed(false);
            } else {
                Display.getMain().setText("0");
            }
            chosenOperator = false;
        });
        GridPane.setColumnSpan(numeroNappi[0], 2);
        buttonLayout.add(numeroNappi[0], 0, 4);
        
        return numeroNappi;
    }
    
    //desimaalipiste
    private Button decimal() {
        Button decimal = new Button(".");
        decimal.setMinSize(50, 50);
        decimal.setOnAction(e-> {
            if (!Display.getMain().getText().isEmpty() && Display.getDisplayed() == false) {
                Display.getMain().appendText(".");
                chosenOperator = false;
            }
        });
        buttonLayout.add(decimal, 2, 4);
        return decimal;
    }
    
    //operaatiot
    private void operations() {
        for (Operators op: Operators.values()) {
            String symboli = op.toString();
            
            Button nappi = new Button(symboli);
            nappi.setMinSize(50, 50);
            nappi.setStyle("-fx-color: orange");
            nappi.setOnAction(e -> {
                if (Display.getSecondary().getText().isEmpty()) {
                    Display.getSecondary().setText(Display.getMain().getText().isEmpty() ? "0" : Interface.getCalculator().findValue(Display.getMain().getText()));
                    Display.getSecondary().appendText(" " + symboli);
                    operatorNow = op;
                    Display.setResultDisplayed(true);
                    chosenOperator = true;
                } else if (chosenOperator) {
                    operatorNow = op;
                    int loppu = Display.getSecondary().getText().length();
                    Display.getSecondary().replaceText(loppu - 1, loppu, symboli);
                    
                } else {
                    Display.getSecondary().setText(Interface.getCalculator().calculateOperation(operatorNow, Display.getMain(), Display.getSecondary()) + " " + symboli);
                    Display.getMain().clear();
                    operatorNow = op;
                    Display.setResultDisplayed(true);
                    chosenOperator = true;
                }
            });
            buttonLayout.addColumn(3, nappi);
        }
    }
    
    //on yhtä kuin
    private Button equals() {
        Button solve = new Button("=");
        solve.setStyle("-fx-color: orange");
        solve.setMinSize(50, 50);
        solve.setOnAction(e-> {
            if (!Display.getSecondary().getText().isEmpty()) {
                Display.getMain().setText(Interface.getCalculator().calculateOperation(operatorNow, Display.getMain(), Display.getSecondary()));
                Display.setResultDisplayed(true);
                chosenOperator = false;
                Display.getSecondary().clear();
            }
            
        });
        buttonLayout.addColumn(3, solve);
        solve.setDefaultButton(true);
        return solve;
    }
    
    public static Operators getOperatorNow() {
        return operatorNow;
    }
    
    public static boolean getChosenOperator() {
        return chosenOperator;
    }
    
    public static GridPane getNumberButtons() {
        return buttonLayout;
    }
    
    public static void setChosenOperator(boolean value) {
        chosenOperator = value;
    }

}
