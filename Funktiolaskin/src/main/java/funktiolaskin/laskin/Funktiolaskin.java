
package funktiolaskin.laskin;

import javafx.scene.control.TextField;


public class Funktiolaskin {
   //Selsvittää stringin arvon
    public static String selvitaArvo(String arvo) {
        double tulos = Double.parseDouble(arvo);
        return toFunktiolaskinString(tulos);
    }
    
    //muuttaa doublen stringiksi ja postaa ylimääräiset nollat
    public static String toFunktiolaskinString(double input) {
        return input == (int) input ? 
            Integer.toString((int) input) : poistaDesimaaliaSeuraavatNollat(String.format("%.6f", input));
    }
    
    //poistaa ylimääräiset nollat
    public static String poistaDesimaaliaSeuraavatNollat(String s) {
        return !s.contains(".") ? s : s.replaceAll("0*$", "").replaceAll("\\.$", "");
    }
    
    //laskee operaation 
    public static String laskeOperaatio(Operaattori op, TextField main, TextField apu) {
        double arvo1 = Double.parseDouble(apu.getText().replaceAll("[^\\.0-9]", ""));
        double arvo2 = Double.parseDouble(main.getText());

        if (arvo2 == 0 && op == Operaattori.JAKO) {
            return "Nollalla ei voi jakaa";
        }

        double tulos = op.laske(arvo1, arvo2);
        return toFunktiolaskinString(tulos);
    }
    
    //laskee funktion
    public static String laskeFunktio(Funktiot funk, TextField main) {
        double arvo = Double.parseDouble(main.getText());
        double tulos = funk.laske(arvo);
        return toFunktiolaskinString(tulos);
    }
}
