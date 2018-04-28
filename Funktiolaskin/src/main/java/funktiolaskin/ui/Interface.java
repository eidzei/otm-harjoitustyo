
package funktiolaskin.ui;

import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import funktiolaskin.laskin.*;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;


public class Interface {
    
    private static BorderPane window;
    
    private static Calculator calc;
    
    private static GridPane second;
    
    private static GridPane functions;
    
    
    
    
    public static Stage getInterface() {
        //luodaan ja sommiotellaan asettelu
        Stage stage = new Stage();
        calc = new Calculator();
        window = new BorderPane();
        
        Display display = new Display();
        OtherButtons otherButtons = new OtherButtons();
        FunctionButtons functionButtons = new FunctionButtons();
        functions = functionButtons.getFunctions();
        NumberButtons numberButtons = new NumberButtons();
        SecondaryFunctionButtons secondary  = new SecondaryFunctionButtons();
        second = secondary.getFunctions();
        
        window.setTop(display.getDisplay());
        window.setAlignment(display.getDisplay(), Pos.TOP_CENTER);
        window.setLeft(otherButtons.getButtons());
        window.setAlignment(otherButtons.getButtons(), Pos.CENTER_LEFT);
        window.setCenter(functions);
        window.setAlignment(functions, Pos.CENTER);
        window.setRight(numberButtons.getNumberButtons());
        window.setAlignment(numberButtons.getNumberButtons(), Pos.CENTER_RIGHT);
        

        Scene scene = new Scene(window);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.sizeToScene();
        stage.setTitle("Funktiolaskin");
        return stage;
    }
    
    public static BorderPane getWindow(){
        return window;
    }
    
    public static Calculator getCalculator(){
        return calc;
    }
    
    public static GridPane getSecond(){
        return second;
    }
    
    public static GridPane getFunction(){
        return functions;
    }

}
