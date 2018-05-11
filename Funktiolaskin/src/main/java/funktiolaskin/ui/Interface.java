
package funktiolaskin.ui;

import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import funktiolaskin.laskin.*;
import javafx.geometry.Pos;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

/**
 * Graafisen käyttöliittymän luova luokka
 * 
 * @author eidzey
 */
public class Interface {
    
    private static BorderPane window;
    
    private static Calculator calc;
    
    private static Display display;
    
    private static GridPane second;
    
    private static GridPane functions;
    
    private static Scene scene;
    

    /**
     * Metodi sommittelee graafisen käyttöliittymän
     * 
     * @return käyttöliittymä 
     */
    public static Stage getInterface() {
        //luodaan ja sommiotellaan asettelu
        
        Stage stage = new Stage();
        calc = new Calculator();
        window = new BorderPane();
        
        display = new Display();
        OtherButtons otherButtons = new OtherButtons();
        FunctionButtons functionButtons = new FunctionButtons();
        functions = functionButtons.getFunctions();
        NumberButtons numberButtons = new NumberButtons();
        SecondaryFunctionButtons secondary  = new SecondaryFunctionButtons();
        second = secondary.getFunctions();
        
        window.setTop(display.getDisplay());
        
        window.setLeft(otherButtons.getButtons());
       
        window.setCenter(functions);
        window.setAlignment(functions, Pos.CENTER);
        window.setRight(numberButtons.getNumberButtons());
        
        window.setBottom(PrintButton.printButton());

        

        scene = new Scene(window);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.sizeToScene();
        stage.setTitle("Funktiolaskin");
        return stage;
    }
    
    /**
     * Ikkunan asettelu
     * 
     * @return ikkuna
     */
    public static BorderPane getWindow() {
        return window;
    }
    
    /**
     * Laskimen logiikka
     * 
     * @return laskin
     */
    public static Calculator getCalculator() {
        return calc;
    }
    
    /**
     * Second napin taakse piilotettujen funktioiden asettelu
     * @return second funktiot
     */
    public static GridPane getSecond() {
        return second;
    }
    
    /**
     * Funktioiden asettelu
     * 
     * @return funktioit
     */
    public static GridPane getFunction() {
        return functions;
    }

    public static Scene getScene() {
        return scene;
    }
    
    
    public static TextField getSecondary() {
        return display.getSecondary();
    }
    
    public static TextField getMain() {
        return display.getMain();
    }
}
