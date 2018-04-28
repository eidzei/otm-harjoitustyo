
package funktiolaskin.ui;


import javafx.scene.layout.VBox;
import javafx.scene.control.TextField;

public class Display extends VBox{

    
    private static VBox display;
    private static TextField secondary;
    private static TextField main;
    private static boolean resultDisplayed;
    
    public Display() {
        display = new VBox();
        
        secondary = new TextField();
        secondary.setStyle("-fx-font-size: 10; -fx-text-fill: gray");
        secondary.setMaxWidth(615);
        secondary.setEditable(false);
        
        //tähän kirjoitetaan
        main = new TextField();
        main.setStyle("-fx-font-size: 20");
        main.setMaxWidth(615);
        main.setEditable(false);
        
        display.getChildren().addAll(secondary, main);

    }

    public static VBox getDisplay(){
        return display;
    }
    
    public static TextField getSecondary(){
        return secondary;
    }
    
    public static TextField getMain(){
        return main;
    }
    
    public static boolean getDisplayed(){
        return resultDisplayed;
    }
    
    public static void setMain(String value){
        main.setText(value);
    }
    
    public static void setSecondary(String value){
        secondary.setText(value);
    }
    
    public static void setResultDisplayed(boolean boo){
        resultDisplayed = boo;
    }
    
   

}
