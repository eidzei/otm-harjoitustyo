
package funktiolaskin.laskin;

import javafx.scene.control.TextField;

/**
 * Luokka laskimen perustoimintoja
 */
public class Calculator {
   
    /**
     * Metodi selvittää annetun String muuttujan arvon
     * liukuluku, poistaen ylimääräiset nollat
     * 
     * @param value Selvitettävä String
     * 
     * @return String liukulukuna nollat poistettuna
     */
    public String findValue(String value) {
        double result = Double.parseDouble(value);
        return toFunktiolaskinString(result);
    }
    
    /**
     * Poistaa liukulukujen perään jäävät ylimääräiset nollat
     * 
     * @param d annettu liukuluku
     * @return nollat poistettu liukuluku
     */
    public String fmt(double d) {
        if (d == (long) d) {
            return String.format("%d", (long) d);
        } else {
            return String.format("%s", d);
        }
    }
    
    /**
     * Metodi muuttaa doublen Stringiksi ja poistaa ylimääräiset nollat
     * @param input annettu double
     *
     * @return double Stringinä
     */
    public String toFunktiolaskinString(double input) {
        return input == (int) input ? 
            Integer.toString((int) input) : fmt(input);
    }
    
    /**
     * Metodi laskee operaation 
     * @param op operaatio
     * @param main tekstikenttä, jossa toinen luku
     * @param secondary tekstikenttä, jossa ensimmäinen luku
     * @return laskuoperaation tulos
     */
    public String calculateOperation(Operators op, TextField main, TextField secondary) {
        double arvo1 = Double.parseDouble(secondary.getText().replaceAll("[^\\.0-9]", ""));
        double arvo2 = Double.parseDouble(main.getText());

        if (arvo2 == 0 && op == Operators.DIVIDE) {
            return "Nollalla ei voi jakaa";
        }

        double result = op.laske(arvo1, arvo2);
        return toFunktiolaskinString(result);
    }
    
    /**
     * Metodi laskee funktion
     * @param funk valittu funktio
     * @param main teksti kenttä, josta luetaan funktion syöte
     * @return funktion tulos
     */
    public String calculateFunction(Functions funk, TextField main) {
        double value = Double.parseDouble(main.getText());
        
        if (value == 0 && funk == Functions.ONEPERX) {
            return "Nollalla ei voi jakaa";
        }
        double result = funk.laske(value);
        return toFunktiolaskinString(result);
    }
    
    /**
     * Metodi laskee second funktion
     * @param sec valittu funktio
     * @param main teksti kenttä, josta luetaan funktion syöte
     * @return funktion tulos
     */
    public String calculateSecondFunction(SecondFunctions sec, TextField main) {
        double value = Double.parseDouble(main.getText());
        double result = sec.laske(value);
        return toFunktiolaskinString(result);
    }
}
