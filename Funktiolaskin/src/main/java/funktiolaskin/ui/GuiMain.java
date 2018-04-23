
package funktiolaskin.ui;


import funktiolaskin.laskin.Funktiolaskin;
import funktiolaskin.laskin.Funktiot;
import funktiolaskin.laskin.Operaattori;
import funktiolaskin.laskin.SecondFunktiot;
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
    //mikä second funktio valittu
    static SecondFunktiot secondNyt;
    //onko operaatio valittu
    static boolean valittuOperaattori;
    //onko tulos naytetty
    static boolean tulosNaytetty;
    //secondnappi valittu
    static boolean secondNappi;
    
    BorderPane layout;
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
        layout = new BorderPane();
        
        tulosTaulu = naytto();
        
        layout.setTop(tulosTaulu);
       
        layout.setLeft(muutNapit());
        
        layout.setRight(numeroNapit());
        
        layout.setCenter(funktioNapit());
        
        
        Scene scene = new Scene(layout);
        
        ikkuna.setScene(scene);
        ikkuna.setResizable(false);
        ikkuna.sizeToScene();
        ikkuna.setTitle("Funktiolaskin");
        ikkuna.show();
       
        
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
    
    
    //Luodaan funktionappaimet, toiminnot lisataan myohemmin
    public GridPane funktioNapit() {
        GridPane funktioLayout = new GridPane();
        funktioLayout.setPadding(new Insets(10, 10, 0, 0));
        funktioLayout.setHgap(5);
        funktioLayout.setVgap(5);
        
        int column = 0;
        int row = 0;
        for (Funktiot funk: Funktiot.values()) {
            if (row == 2) {
                row = 0;
                column++;
            }
            String symboli = funk.toString();
            Button funkNappi = new Button(symboli);
            funkNappi.setMinSize(100, 100);
            funkNappi.setStyle("-fx-color: gray");
            funkNappi.setOnAction(e-> {
                if (apuNaytto.getText().isEmpty() && !naytto.getText().isEmpty()) {
                    funktioNyt = funk;
                    naytto.setText(laskin.laskeFunktio(funktioNyt, naytto));
                    tulosNaytetty = true;
                }
            });
            funktioLayout.add(funkNappi, row, column); 
            row++;
        }
        
        return funktioLayout;
    }
    
    public GridPane secondFunktioNapit() {
        GridPane secondLayout = new GridPane();
        secondLayout.setPadding(new Insets(10, 10, 0, 0));
        secondLayout.setHgap(5);
        secondLayout.setVgap(5);
        
        int column = 0;
        int row = 0;
        for (SecondFunktiot funk: SecondFunktiot.values()) {
            if (row == 2) {
                row = 0;
                column++;
            }
            String symboli = funk.toString();
            Button funkNappi = new Button(symboli);
            funkNappi.setMinSize(100, 100);
            funkNappi.setStyle("-fx-color: gray");
            funkNappi.setOnAction(e-> {
                if (apuNaytto.getText().isEmpty() && !naytto.getText().isEmpty()) {
                    secondNyt = funk;
                    naytto.setText(laskin.laskeSecondFunktio(secondNyt, naytto));
                    tulosNaytetty = true;
                }
            });
            secondLayout.add(funkNappi, row, column); 
            row++;
        }
        
        return secondLayout;
    }
    
    public GridPane muutNapit() {
        GridPane muutLayout  = new GridPane();
        muutLayout.setPadding(new Insets(10, 10, 0, 0));
        muutLayout.setHgap(5);
        muutLayout.setVgap(5);
        
        //second nappi
        Button second = new Button("2nd");
        second.setMinSize(100, 100);
        second.setStyle("-fx-color: gray");
        second.setOnAction(e -> {
            if (!secondNappi) {
                second.setStyle("-fx-color: white");
                secondNappi = true;
                layout.setCenter(secondFunktioNapit());
            } else {
                second.setStyle("-fx-color: gray");
                secondNappi = false;
                layout.setCenter(funktioNapit());
            }
        });
        muutLayout.add(second, 0, 0);
        
        //neperin luku
        Button ee = new Button("e");
        ee.setMinSize(100, 100);
        ee.setStyle("-fx-color: gray");
        ee.setOnAction(e -> {
            if (naytto.getText().isEmpty() && !tulosNaytetty) {
                naytto.setText(String.valueOf(Math.E));
              
            } else if (valittuOperaattori) {
                naytto.setText(String.valueOf(Math.E));
            } else if (naytto.getText().isEmpty()) {
                naytto.setText(String.valueOf(Math.E));
            }
                
            
            valittuOperaattori = false;
        });
        muutLayout.add(ee, 0, 1);
        
        //pi nappi
        Button pi = new Button("\u03C0");
        pi.setMinSize(100, 100);
        pi.setStyle("-fx-color: gray");
        pi.setOnAction(e -> {
            if (naytto.getText().isEmpty() && !tulosNaytetty) {
                naytto.setText(String.valueOf(Math.PI));
              
            } else if (valittuOperaattori) {
                naytto.setText(String.valueOf(Math.PI));
            } else if (naytto.getText().isEmpty()) {
                naytto.setText(String.valueOf(Math.PI));
            }
            
            valittuOperaattori = false;
        });
        muutLayout.add(pi, 0, 2);
        
        //rand nappi
        Button rand = new Button("rand");
        rand.setMinSize(100, 100);
        rand.setStyle("-fx-color: gray");
        rand.setOnAction(e -> {
            if (naytto.getText().isEmpty() && !tulosNaytetty) {
                naytto.setText(String.valueOf(Math.random()));
              
            } else if (valittuOperaattori) {
                naytto.setText(String.valueOf(Math.random()));
            } else if (naytto.getText().isEmpty()) {
                naytto.setText(String.valueOf(Math.random()));
            }
            
            valittuOperaattori = false;
        });
        muutLayout.add(rand, 0, 3);
        
        return muutLayout;
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
        numeroNappi[0].setOnAction(e -> {
                    if (tulosNaytetty) {
                        naytto.setText("0");
                        tulosNaytetty = false;
                    } else {
                        naytto.appendText("0");
                    }
                    valittuOperaattori = false;
                });
        GridPane.setColumnSpan(numeroNappi[0], 2);
        nappiLayout.add(numeroNappi[0], 0, 4);
               
        //desimaalipiste
        Button desimaali = new Button(",");
        desimaali.setMinSize(100, 100);
        desimaali.setOnAction(e-> {
            if (!naytto.getText().isEmpty() && tulosNaytetty == false) {
                naytto.appendText(".");
                valittuOperaattori = false;
            }
        });
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
    

