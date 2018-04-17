
package funktiolaskin.ui;


import funktiolaskin.laskin.Funktiolaskin;
import funktiolaskin.laskin.Funktiot;
import funktiolaskin.laskin.Operaattori;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.Scene;


public class GuiMain extends Application {
    //mikä operaatio valittu
    static Operaattori operaattoriNyt;
    //mikä funtio valittu
    static Funktiot funktioNyt; 
    //onko operaatio valittu
    static boolean valittuOperaattori;
    //onko tulos naytetty
    static boolean tulosNaytetty;
    
    private VBox tulosTaulu;
    private TextField apuNaytto;
    private TextField naytto;
    private static Funktiolaskin laskin;
    
    public static void main(String[] args) {
        laskin = new Funktiolaskin();
        launch(args);
    }
    
    @Override
    public void start(Stage ikkuna) {
        //Luodaan Layout ja sommitellaan asettelu
        BorderPane layout = new BorderPane();
        
        tulosTaulu = naytto();
        
        layout.setTop(tulosTaulu);
        
        layout.setRight(numeroNapit());
        
        layout.setLeft(funktioNapit());
        
        Scene scene = new Scene(layout);
        
        ikkuna.setScene(scene);
        ikkuna.setResizable(false);
        ikkuna.sizeToScene();
        ikkuna.setTitle("Funktiolaskin");
        ikkuna.show();
       
        
    }
    //Luodaan funktionappaimet, toiminnot lisataan myohemmin
    public GridPane funktioNapit() {
        GridPane funktioLayout = new GridPane();
        funktioLayout.setPadding(new Insets(10, 10, 0, 0));
        funktioLayout.setHgap(5);
        funktioLayout.setVgap(5);
        
        //for(Funktiot funk: Funktiot.values()){
        //    String symboli = funk.toString();
            
            
        //}
        Button squered = new Button("x^2");
        squered.setMinSize(100, 100);
        squered.setStyle("-fx-color: gray");
        funktioLayout.add(squered, 0, 0);
        
        Button cubed = new Button("x^3");
        cubed.setMinSize(100, 100);
        cubed.setStyle("-fx-color: gray");
        funktioLayout.add(cubed, 1, 0);
        
        Button onePerX = new Button("1/x");
        onePerX.setMinSize(100, 100);
        onePerX.setStyle("-fx-color: gray");
        funktioLayout.add(onePerX, 0, 1);
        
        Button sqrt = new Button("sqrt");
        sqrt.setMinSize(100, 100);
        sqrt.setStyle("-fx-color: gray");
        funktioLayout.add(sqrt, 1, 1);
        
        Button lnx = new Button("ln x");
        lnx.setMinSize(100, 100);
        lnx.setStyle("-fx-color: gray");
        funktioLayout.add(lnx, 0, 2);
        
        Button logTen = new Button("log 10");
        logTen.setMinSize(100, 100);
        logTen.setStyle("-fx-color: gray");
        funktioLayout.add(logTen, 1, 2);
        
        Button sin = new Button("sin");
        sin.setMinSize(100, 100);
        sin.setStyle("-fx-color: gray");
        funktioLayout.add(sin, 0, 3);
        
        Button cos = new Button("cos");
        cos.setMinSize(100, 100);
        cos.setStyle("-fx-color: gray");
        funktioLayout.add(cos, 1, 3);
        
        Button tan = new Button("tan");
        tan.setMinSize(100, 100);
        tan.setStyle("-fx-color: gray");
        funktioLayout.add(tan, 0, 4);
        
        Button pi = new Button("pi");
        pi.setMinSize(100, 100);
        pi.setStyle("-fx-color: gray");
        pi.setOnAction(e -> {
            
        });
        funktioLayout.add(pi, 1, 4);
        
        return funktioLayout;
    }
    
    //nayton asettelu
    public VBox naytto() {
        //näyttää ennen operaatiota tai funktiota kirjoitetun tuloksen
        apuNaytto = new TextField();
        apuNaytto.setStyle("-fx-font-size: 15; -fx-text-fill: gray");
        apuNaytto.setMaxWidth(815);
        apuNaytto.setEditable(false);
        
        //tähän kirjoitetaan
        naytto = new TextField();
        naytto.setStyle("-fx-font-size: 40");
        naytto.setMaxWidth(815);
        naytto.setEditable(false);
        
        //asettelu
        VBox nayttoLayout = new VBox();
        nayttoLayout.getChildren().addAll(apuNaytto, naytto);
        
        return nayttoLayout;
    }
    
    //numeronappaimisto
    public GridPane numeroNapit() {
        GridPane nappiLayout = new GridPane();
        nappiLayout.setPadding(new Insets(10, 0, 0, 0));
        nappiLayout.setHgap(5);
        nappiLayout.setVgap(5);
        
        //clear
        Button clear = new Button("clear");
        clear.setMinSize(200, 100);
        clear.setOnAction(e -> {
            naytto.clear();
            apuNaytto.clear();
            valittuOperaattori = false;
        });
        GridPane.setColumnSpan(clear, 2);
        nappiLayout.add(clear, 0, 0);
        
        //backspace
        Button takaisin = new Button("\u2190");
        takaisin.setMinSize(100, 100);
        takaisin.setOnAction(e-> {
            String teksti = naytto.getText();
            if (!teksti.isEmpty() && !tulosNaytetty) {
                naytto.setText(teksti.substring(0, teksti.length() - 1));
            }
        });
        nappiLayout.add(takaisin, 2, 0);
        
        //luodaan numeronapit
        Button[] numeroNappi = new Button[10];
        for (int i = 3, kohde = 1; i >= 1; i--) {
            for (int j = 0; j <= 2; j++) {
                String numero = Integer.toString(kohde);
                
                numeroNappi[kohde] = new Button(numero);
                numeroNappi[kohde].setMinSize(100, 100);
                numeroNappi[kohde].setOnAction(e -> {
                    if (tulosNaytetty) {
                        naytto.setText(numero);
                        tulosNaytetty = false;
                    } else {
                        naytto.appendText(numero);
                    }
                    valittuOperaattori = false;
                });
                nappiLayout.add(numeroNappi[kohde++], j, i);
            }
        }
        
        //nolla
        numeroNappi[0] = new Button("0");
        numeroNappi[0].setMinSize(200, 100);
        GridPane.setColumnSpan(numeroNappi[0], 2);
        nappiLayout.add(numeroNappi[0], 0, 4);
               
        //desimaalipiste
        Button desimaali = new Button(".");
        desimaali.setMinSize(100, 100);
        nappiLayout.add(desimaali, 2, 4);
        
        //operaationapit
        for (Operaattori op: Operaattori.values()) {
            String symboli = op.toString();
            
            Button nappi = new Button(symboli);
            nappi.setMinSize(100, 100);
            nappi.setStyle("-fx-color: orange");
            nappi.setOnAction(e -> {
                if (apuNaytto.getText().isEmpty()) {
                    apuNaytto.setText(naytto.getText().isEmpty() ? "0" : laskin.selvitaArvo(naytto.getText()));
                    apuNaytto.appendText(" " + symboli);
                    operaattoriNyt = op;
                    tulosNaytetty = true;
                    valittuOperaattori = true;
                } else if (valittuOperaattori) {
                    operaattoriNyt = op;
                    int loppu = apuNaytto.getText().length();
                    apuNaytto.replaceText(loppu - 1, loppu, symboli);
                    
                } else {
                    apuNaytto.setText(laskin.laskeOperaatio(operaattoriNyt, naytto, apuNaytto) + " " + symboli);
                    naytto.clear();
                    operaattoriNyt = op;
                    tulosNaytetty = true;
                    valittuOperaattori = true;
                }
            });
            nappiLayout.addColumn(3, nappi);
        }
        
        //on yhta kuin nappi
        Button onYhtaKuin = new Button("=");
        onYhtaKuin.setStyle("-fx-color: orange");
        onYhtaKuin.setMinSize(100, 100);
        onYhtaKuin.setOnAction(e-> {
            if (!apuNaytto.getText().isEmpty()) {
                naytto.setText(laskin.laskeOperaatio(operaattoriNyt, naytto, apuNaytto));
                tulosNaytetty = true;
                valittuOperaattori = false;
                apuNaytto.clear();
            }
            
        });
        nappiLayout.addColumn(3, onYhtaKuin);
        onYhtaKuin.setDefaultButton(true);

        return nappiLayout;
    }
    
}    
    

