
package funktiolaskin.laskin;

import javafx.scene.control.TextField;


public class Calculator {
   //Selsvittää stringin arvon
    public String findValue(String value) {
        double result = Double.parseDouble(value);
        return toFunktiolaskinString(result);
    }
    
    //poistaa ylimääräiset nollat, ei ehkä kaunein mahdollinen ratkaisu
    public String fmt(double d) {
        if (d == (long) d) {
            return String.format("%d", (long) d);
        } else {
            return String.format("%s", d);
        }
    }
    
    //muuttaa doublen stringiksi ja postaa ylimääräiset nollat
    public String toFunktiolaskinString(double input) {
        return input == (int) input ? 
            Integer.toString((int) input) : fmt(input);
    }
    
    //laskee operaation 
    public String calculateOperation(Operators op, TextField main, TextField secondary) {
        double arvo1 = Double.parseDouble(secondary.getText().replaceAll("[^\\.0-9]", ""));
        double arvo2 = Double.parseDouble(main.getText());

        if (arvo2 == 0 && op == Operators.DIVIDE) {
            return "Nollalla ei voi jakaa";
        }

        double result = op.laske(arvo1, arvo2);
        return toFunktiolaskinString(result);
    }
    
    //laskee funktion
    public String calculateFunction(Functions funk, TextField main) {
        double value = Double.parseDouble(main.getText());
        
        if (value == 0 && funk == Functions.ONEPERX) {
            return "Nollalla ei voi jakaa";
        }
        double result = funk.laske(value);
        return toFunktiolaskinString(result);
    }
    
    //laskee second funktiot
    public String calculateSecondFunction(SecondFunctions sec, TextField main) {
        double value = Double.parseDouble(main.getText());
        double result = sec.laske(value);
        return toFunktiolaskinString(result);
    }
}
