
package funktiolaskin;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.Scene;


public class GuiMain extends Application {
    //mikä operaatio valittu
    static Operaattori operaattoriNyt;
    //onko operaatio valittu
    static boolean valittuOperaattori;
    //onko tulos naytetty
    static boolean tulosNaytetty;
    
    private TextField apuNaytto;
    private TextField naytto;
    
    @Override
    public void start(Stage ikkuna) {
        //Luodaan Layout ja sommitellaan asettelu
        BorderPane layout = new BorderPane();
        
        VBox tulosTaulu = naytto();
        
        layout.setTop(tulosTaulu);
        
        layout.setRight(numeroNapit(tulosTaulu));
        
        layout.setLeft(funktioNapit(tulosTaulu));
        
        Scene scene = new Scene(layout);
        
        ikkuna.setScene(scene);
        ikkuna.setResizable(false);
        ikkuna.sizeToScene();
        ikkuna.setTitle("Funktiolaskin");
        ikkuna.show();
       
        
    }
    //Luodaan funktionappaimet, toiminnot lisataan myohemmin
    public GridPane funktioNapit(VBox tulos){
        GridPane funktioLayout = new GridPane();
        funktioLayout.setPadding(new Insets(10,0,0,0));
        funktioLayout.setHgap(5);
        funktioLayout.setVgap(2);
        
        //
        Button squered= new Button("x^2");
        squered.setMinSize(100, 100);
        funktioLayout.add(squered, 0, 0);
        
        Button cubed= new Button("x^3");
        squered.setMinSize(100, 100);
        funktioLayout.add(squered, 1, 0);
        
        Button onePerX= new Button("1/x");
        squered.setMinSize(100, 100);
        funktioLayout.add(squered, 0, 1);
        
        Button sqrt= new Button("sqrt");
        squered.setMinSize(100, 100);
        funktioLayout.add(squered, 1, 1);
        
        Button lnx= new Button("ln x");
        squered.setMinSize(100, 100);
        funktioLayout.add(squered, 0, 2);
        
        Button logTen= new Button("log 10");
        squered.setMinSize(100, 100);
        funktioLayout.add(squered, 1, 2);
        
        Button sin= new Button("sin");
        squered.setMinSize(100, 100);
        funktioLayout.add(squered, 0, 3);
        
        Button cos= new Button("cos");
        squered.setMinSize(100, 100);
        funktioLayout.add(squered, 1, 3);
        
        Button tan= new Button("tan");
        squered.setMinSize(100, 100);
        funktioLayout.add(squered, 0, 4);
        
        Button pi= new Button("pi");
        squered.setMinSize(100, 100);
        funktioLayout.add(squered, 1, 4);
        
        return funktioLayout;
    }
    
    //nayton asettelu
    public VBox naytto(){
        //näyttää edellisen tuloksen
        apuNaytto = new TextField();
        apuNaytto.setStyle("-fx-font-size: 15; -fx-text-fill: gray");
        apuNaytto.setMaxWidth(615);
        apuNaytto.setEditable(false);
        
        //tähän kirjoitetaan
        naytto = new TextField();
        naytto.setStyle("-fx-font-size: 40");
        naytto.setMaxWidth(615);
        naytto.setEditable(false);
        
        //asettelu
        VBox nayttoLayout = new VBox();
        nayttoLayout.getChildren().addAll(apuNaytto, naytto);
        
        return nayttoLayout;
    }
    
    //numeronappaimisto
    public GridPane numeroNapit(VBox tulos){
        GridPane nappiLayout = new GridPane();
        nappiLayout.setPadding(new Insets(10,0,0,0));
        nappiLayout.setHgap(5);
        nappiLayout.setVgap(5);
        
        //clear
        Button clear = new Button("clear");
        clear.setMinSize(200, 100);
        GridPane.setColumnSpan(clear, 2);
        nappiLayout.add(clear, 0, 0);
        
        //backspace
        Button takaisin = new Button("\u2190");
        takaisin.setMinSize(100, 100);
        nappiLayout.add(takaisin, 2, 0);
        
        //luodaan numeronapit
        Button[] numeroNappi = new Button[10];
        for(int i=3, kohde=1; i>=1; i--){
            for(int j=0; j<=2; j++){
                String numero = Integer.toString(kohde);
                
                numeroNappi[kohde]= new Button(numero);
                numeroNappi[kohde].setMinSize(100, 100);
                numeroNappi[kohde].setOnAction(e -> {
                    if(tulosNaytetty){
                        naytto.setText(numero);
                        tulosNaytetty = false;
                    }
                    else{
                        naytto.appendText(numero);
                    }
                    valittuOperaattori = false;
                });
                nappiLayout.add(numeroNappi[kohde++], j, i);
            }
        }
        
        //nolla
        numeroNappi[0] = new Button ("0");
        numeroNappi[0].setMinSize(200,100);
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
            nappi.setOnAction(e ->{
                if(apuNaytto.getText().isEmpty()){
                    apuNaytto.setText(naytto.getText().isEmpty() ? "0": selvitaArvo(naytto.getText()));
                    apuNaytto.appendText(" " + symboli);
                    operaattoriNyt = op;
                    tulosNaytetty = true;
                    valittuOperaattori = true;
                }
                else if (valittuOperaattori){
                    operaattoriNyt = op;
                    int loppu = apuNaytto.getText().length();
                    apuNaytto.replaceText(loppu - 1, loppu, symboli);
                    
                }
                else{
                    apuNaytto.setText(laske(operaattoriNyt, naytto, apuNaytto) + " " + symboli);
                    naytto.clear();
                    operaattoriNyt = op;
                    tulosNaytetty = true;
                    valittuOperaattori = true;
                }
            });
        }

        
        
        return nappiLayout;
    }
    
    //
    private static String selvitaArvo(String arvo){
        double tulos = Double.parseDouble(arvo);
        return toFunktiolaskinString(tulos);
    }
    
    //
    private static String toFunktiolaskinString(double input) {
        return input == (int)input ? 
            Integer.toString((int)input) : poistaDesimaaliaSeuraavatNollat(String.format("%.6f", input));
    }
    
    //
    private static String poistaDesimaaliaSeuraavatNollat(String s) {
        return !s.contains(".") ? s : s.replaceAll("0*$", "").replaceAll("\\.$", "");
    }
    
    //
    private static String laske(Operaattori op, TextField main, TextField apu) {
        double arvo1 = Double.parseDouble(apu.getText().replaceAll("[^\\.0-9]", ""));
        double arvo2 = Double.parseDouble(main.getText());

        if (arvo2 == 0 && op == Operaattori.JAKO) {
            return "Nollalla ei voi jakaa";
        }

        double tulos = op.laske(arvo1, arvo2);
        return toFunktiolaskinString(tulos);
    }

    

   
    public static void main(String[] args) {
        launch(args);
    }
    
}
