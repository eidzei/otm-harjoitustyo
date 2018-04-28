
package funktiolaskin.main;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.stage.Stage;
import funktiolaskin.ui.*;


public class Main extends Application {
    
    
    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage = Interface.getInterface();
        primaryStage.show();
    }

    
    public static void main(String[] args) {
        launch(Main.class);
    }
    
}
