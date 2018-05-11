
package FunktiolaskinTest;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import funktiolaskin.laskin.*;
import static org.hamcrest.CoreMatchers.*;
import funktiolaskin.ui.*;


public class OperaattoriTest {
    Operators raattori;
    
    @Test    
    public void jakaaNimi() {
        assertEquals(raattori.DIVIDE.toString(), "\u00F7");
    }
    
    @Test 
    public void kertooNimi(){
        assertEquals(raattori.MULTIPLY.toString(), "*");
    }
    
    @Test 
    public void lisaaNimi(){
        assertEquals(raattori.ADD.toString(), "+");
    }
    
    @Test
    public void vahentaaNimi(){
        assertEquals(raattori.SUBTRACT.toString(), "-");
    }
    
    
    @Test
    public void vahentaaOikein() {
        assertThat(raattori.SUBTRACT.laske(3.0, 2.0), is(1.0));
    }
    
    @Test
    public void lisaaOikein() {
        assertThat(raattori.ADD.laske(4.0, 2.0), is(6.0));
    }
    
   @Test
    public void kertooOikein() {
        assertThat(raattori.MULTIPLY.laske(2.0, 2.0), is(4.0));
    }
    
    @Test
    public void jakaaOikein() {
        assertThat(raattori.DIVIDE.laske(2.0, 1.0), is(2.0));
    }
    
    
   
    
}
