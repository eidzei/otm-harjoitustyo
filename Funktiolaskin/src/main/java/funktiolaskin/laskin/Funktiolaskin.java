
package funktiolaskin.laskin;

import javafx.scene.control.TextField;


public class Funktiolaskin {
   //Selsvittää stringin arvon
    public static String selvitaArvo(String arvo) {
        double tulos = Double.parseDouble(arvo);
        return toFunktiolaskinString(tulos);
    }
    
    //poistaa ylimääräiset nollat, ei ehkä kaunein mahdollinen ratkaisu
    public static String fmt(double d) {
        if (d == (long) d) {
            return String.format("%d", (long) d);
        } else {
            return String.format("%s", d);
        }
    }
    
    //muuttaa doublen stringiksi ja postaa ylimääräiset nollat
    public static String toFunktiolaskinString(double input) {
        return input == (int) input ? 
            Integer.toString((int) input) : fmt(input);
    }
    
    //laskee operaation 
    public String laskeOperaatio(Operaattori op, TextField main, TextField apu) {
        double arvo1 = Double.parseDouble(apu.getText().replaceAll("[^\\.0-9]", ""));
        double arvo2 = Double.parseDouble(main.getText());

        if (arvo2 == 0 && op == Operaattori.JAKO) {
            return "Nollalla ei voi jakaa";
        }

        double tulos = op.laske(arvo1, arvo2);
        return toFunktiolaskinString(tulos);
    }
    
    //laskee funktion
    public String laskeFunktio(Funktiot funk, TextField main) {
        double arvo = Double.parseDouble(main.getText());
        
        if (arvo == 0 && funk == Funktiot.YKSPERX) {
            return "Nollalla ei voi jakaa";
        }
        double tulos = funk.laske(arvo);
        return toFunktiolaskinString(tulos);
    }
    
    //laskee second funktiot
    public String laskeSecondFunktio(SecondFunktiot sec, TextField main) {
        double arvo = Double.parseDouble(main.getText());
        double tulos = sec.laske(arvo);
        return toFunktiolaskinString(tulos);
    }
}
