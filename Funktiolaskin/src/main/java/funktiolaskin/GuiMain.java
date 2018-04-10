/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package funktiolaskin;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;


/**
 *
 * @author eidzey
 */
public class GuiMain extends Application {
    
    
    
    @Override
    public void start(Stage ikkuna) {
        
        BorderPane layout = new BorderPane();
        
        TextField apuNaytto = new TextField();
        apuNaytto.setStyle("-fx-font-size: 15; -fx-text-fill: gray");
        apuNaytto.setMaxWidth(415);
        apuNaytto.setEditable(false);
        
        TextField naytto = new TextField();
        naytto.setStyle("-fx-font-size: 40");
        naytto.setMaxWidth(415);
        naytto.setEditable(false);
        
        VBox nayttoLayout = new VBox();
        
        
        //funktiot
        Button vasenSulku = new Button("(");
        Button oikeaSulku= new Button(")");
        Button mc= new Button("mc");
        Button mPlus= new Button("m+");
        Button mMiinus= new Button("m-");
        Button mr= new Button("mr");
        Button second= new Button("2nd");
        Button squered= new Button("x^2");
        Button cubed= new Button("x^3");
        Button xToY= new Button("x^y");
        Button eToX= new Button("e^x");
        Button tenToX= new Button("10^x");
        Button onePerX= new Button("1/x");
        Button sqrt= new Button("sqrt");
        Button cbrt= new Button("x^(1/3)");
        Button yrtx= new Button("x^1/y");
        Button lnx= new Button("ln x");
        Button logTen= new Button("log 10");
        Button kertoma= new Button("x!");
        Button sin= new Button("sin");
        Button cos= new Button("cos");
        Button tan= new Button("tan");
        Button e= new Button("e");
        Button ee= new Button("EE");
        Button rad= new Button("rad");
        Button sinh= new Button("sinh");
        Button cosh= new Button("cosh");
        Button tanh= new Button("tanh");
        Button pi= new Button("pi");
        Button rand= new Button("rand");
        
        //numeronäppimistö
        Button acc= new Button("AC/C");
        Button plusMiinus= new Button("+/-");
        Button prosentti= new Button("%");
        Button jako= new Button("/");
        Button seiska= new Button("7");
        Button kasi= new Button("8");
        Button ysi= new Button("9");
        Button kerto= new Button("*");
        Button nelja= new Button("4");
        Button viisi= new Button("5");
        Button kuusi= new Button("6");
        Button miinus= new Button("-");
        Button yksi= new Button("1");
        Button kaksi= new Button("2");
        Button kolme= new Button("3");
        Button plus= new Button("+");
        Button nolla= new Button("0");
        Button piste= new Button(".");
        Button onYhtaKuin= new Button("=");
        
        GridPane asettelu = new GridPane();
        
        
        //btn.setText("Say 'Hello World'");
        //btn.setOnAction(new EventHandler<ActionEvent>() {
            
        //    @Override
        //    public void handle(ActionEvent event) {
        //        System.out.println("Hello World!");
        //    }
        //});
        
        StackPane root = new StackPane();
        root.getChildren().add(oikeaSulku);
        
        Scene scene = new Scene(root, 300, 250);
        
        ikkuna.setTitle("Funktiolaskin");
        ikkuna.setScene(scene);
        ikkuna.show();
    }

   
    public static void main(String[] args) {
        launch(args);
    }
    
}
