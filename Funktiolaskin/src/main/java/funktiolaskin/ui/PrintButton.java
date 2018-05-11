
package funktiolaskin.ui;


import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import funktiolaskin.snapshot.Snapshot;
import java.io.File;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;


public class PrintButton {
    
    private static File file;
    
    public static Button printButton() {
        
        
        Button print = new Button("Print a snapshot");
        print.setMinSize(390, 50);
        print.setStyle("-fx-color: black");
        print.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Boolean boo = Snapshot.takeSnapShot(Interface.getScene());
                if (boo) {
                    print.setText("Snapshot otettu");
                    print.setStyle("-fx-color: green");
                    Timeline timeline = new Timeline(
                        new KeyFrame(Duration.seconds(3), e -> {
                            print.setText("Print a snapshot");
                            print.setStyle("-fx-color: black");
                        })
                    );
                    timeline.play();
                } else {
                    print.setText("Snapshot epäonnistui");
                    print.setStyle("-fx-color: red");
                    Timeline timeline = new Timeline(
                        new KeyFrame(Duration.seconds(3), e -> {
                            print.setText("Print a snapshot");
                            print.setStyle("-fx-color: black");
                        })
                    );
                    timeline.play();
                }
            }
        });
        return print;
    }
    

}

