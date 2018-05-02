
package FunktiolaskinTest;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import funktiolaskin.laskin.*;
import funktiolaskin.ui.*;
import javafx.stage.Stage;


public class CalculatorTest {
    
    Calculator laskin;
    
    
    @Before
    public void setUp() {
        laskin = new Calculator();
        
        
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
