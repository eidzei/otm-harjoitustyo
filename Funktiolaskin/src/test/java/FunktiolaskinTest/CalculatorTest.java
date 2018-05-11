
package FunktiolaskinTest;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import funktiolaskin.laskin.*;
import funktiolaskin.ui.Interface;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.junit.After;
import org.testfx.api.FxToolkit;
import org.testfx.framework.junit.ApplicationTest;


public class CalculatorTest extends ApplicationTest {
    
    Calculator laskin;
    TextField main;
    TextField secondary; 
    
    @Before
    public void setUp() {
        laskin = new Calculator(); 
        main = new TextField("5");
        secondary = new TextField("2");
    }
    
    
    
    //funktioiden testausta
    @Test
    public void nelioiOikein() {
        assertTrue(laskin.calculateFunction(Functions.SQUERE, main).equals("25"));
    }
    
    @Test
    public void kuutioiOikein() {
        assertTrue(laskin.calculateFunction(Functions.CUBE, main).equals("125"));
    }
    
    @Test
    public void neliojuuriOikein() {
        assertTrue(laskin.calculateFunction(Functions.SQUEROROOT, main).equals("2.23606797749979"));
    }
    
    @Test
    public void cosOikein() {
        assertTrue(laskin.calculateFunction(Functions.COS, main).equals("0.28366218546322625"));
    }
    
    @Test
    public void sinOikein() {
        assertTrue(laskin.calculateFunction(Functions.SIN, main).equals("-0.9589242746631385"));
    }
    
    @Test
    public void tanOikein() {
        assertTrue(laskin.calculateFunction(Functions.TAN, main).equals("-3.380515006246586"));
    }
    
    @Test
    public void yksPerxOikein() {
        assertTrue(laskin.calculateFunction(Functions.ONEPERX, main).equals("0.2"));
    }
    
    @Test
    public void cubicrootOikein() {
        assertTrue(laskin.calculateFunction(Functions.CUBICROOT, main).equals("1.709975946676697"));
    }
    
    @Test
    public void lnxOikein() {
        assertTrue(laskin.calculateFunction(Functions.LNX, main).equals("1.6094379124341003"));
    }
    
    @Test
    public void yksPerNollaOikein() {
        main.setText("0");
        String lasku = laskin.calculateFunction(Functions.ONEPERX, main);
        String vastaus = "Nollalla ei voi jakaa";
        assertEquals(lasku, vastaus);
        main.setText("5");
    }
    
    @Test
    public void yksPerNolla() {
        main.setText("0");
        assertTrue(laskin.calculateFunction(Functions.ONEPERX, main).equals("Nollalla ei voi jakaa"));
        main.setText("5");
    }
    
    //secondfunktioita
    @Test
    public void exOikein() {
        assertTrue(laskin.calculateSecondFunction(SecondFunctions.ETOX, main).equals("148.41315910257657"));
    }
    
    @Test
    public void tentoxOikein() {
        assertTrue(laskin.calculateSecondFunction(SecondFunctions.TENTOX, main).equals("100000"));
    }
    
    @Test
    public void twotoxOikein() {
        assertTrue(laskin.calculateSecondFunction(SecondFunctions.TWOTOX, main).equals("32"));
    }
    
    @Test
    public void expmyksOikein() {
        assertTrue(laskin.calculateSecondFunction(SecondFunctions.EXPM1, main).equals("147.4131591025766"));
    }
    
    @Test
    public void acosOikein() {
        main.setText("0");
        assertTrue(laskin.calculateSecondFunction(SecondFunctions.ACOS, main).equals("1.5707963267948966"));
    }
    
    @Test
    public void asinOikein() {
        main.setText("0");
        assertTrue(laskin.calculateSecondFunction(SecondFunctions.ASIN, main).equals("0"));
    }
    
    @Test
    public void atanOikein() {
        main.setText("2");
        assertTrue(laskin.calculateSecondFunction(SecondFunctions.ATAN, main).equals("1.1071487177940904"));
    }
    
    @Test
    public void sinhOikein() {
        main.setText("2");
        assertTrue(laskin.calculateSecondFunction(SecondFunctions.SINH, main).equals("3.626860407847019"));
    }
    
    @Test
    public void coshOikein() {
        main.setText("2");
        assertTrue(laskin.calculateSecondFunction(SecondFunctions.COSH, main).equals("3.7621956910836314"));
    }
    
    @Test
    public void tanhOikein() {
        main.setText("2");
        assertTrue(laskin.calculateSecondFunction(SecondFunctions.TANH, main).equals("0.9640275800758169"));
    }
    
    //Operaatioit toimii oikein
    @Test
    public void plussaOikein() {
        main.setText("2");
        assertTrue(laskin.calculateOperation(Operators.ADD, main, secondary).equals("4"));
    }
    
    @Test
    public void miinusOikein() {
        main.setText("2");
        assertTrue(laskin.calculateOperation(Operators.SUBTRACT, main, secondary).equals("0"));
    }
    
    @Test
    public void kertoOikein() {
        main.setText("2");
        assertTrue(laskin.calculateOperation(Operators.MULTIPLY, main, secondary).equals("4"));
    }
    
    @Test
    public void jakoOikein() {
        secondary.setText("4");
        main.setText("2");
        assertTrue(laskin.calculateOperation(Operators.DIVIDE, main, secondary).equals("2"));
    }
    
    @Test
    public void jakoNollaOikein() {
        secondary.setText("1");
        main.setText("0");
        String lasku = laskin.calculateOperation(Operators.DIVIDE, main, secondary);
        String vastaus = "Nollalla ei voi jakaa";
        assertEquals(lasku, vastaus);
        main.setText("5");
    }
    
    
    
    @Test
    public void noillienPoisto() {
        long pitka = 3;
        assertTrue(laskin.fmt(3.3000).equals("3.3"));
        assertTrue(laskin.fmt(pitka).equals("3"));
    }
    
    @Test
    public void toFunktiolaskinStringTesti() {
        long pitka = 3;
        assertTrue(laskin.toFunktiolaskinString(3.3).equals("3.3"));
        assertTrue(laskin.toFunktiolaskinString(pitka).equals("3"));
    }
    
    @Test
    public void selvitaArvoToimiiOikein() {
        assertTrue(laskin.findValue("3.3").equals("3.3"));
    }
    
    
    
    
}
