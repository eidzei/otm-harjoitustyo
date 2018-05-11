
package funktiolaskin.main;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.stage.Stage;
import funktiolaskin.ui.*;

/**
 * Pääluokka käynnistää sovellukse
 * @author eidzey
 */
public class Main extends Application {
    
    
    /**
     * käynnistää UI:n
     * @param primaryStage
     * @throws Exception 
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage = Interface.getInterface();
        primaryStage.show();
    }

    /**
     * Käynnistää sovelluksen
     * @param args 
     */
    public static void main(String[] args) {
        launch(Main.class);
    }
    
}
