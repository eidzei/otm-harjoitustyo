
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
    public void operaatiotNimet() {
        assertEquals(raattori.MULTIPLY.toString(), "*");
        assertEquals(raattori.DIVIDE.toString(), "\u00F7");
        assertEquals(raattori.ADD.toString(), "+");
        assertEquals(raattori.SUBTRACT.toString(), "-");
    }
    
    @Test
    public void laskeeOikein() {
        assertThat(raattori.ADD.laske(4.0, 2.0), is(6.0));
        assertThat(raattori.MULTIPLY.laske(2.0, 2.0), is(4.0));
        assertThat(raattori.DIVIDE.laske(2.0, 1.0), is(2.0));
        assertThat(raattori.SUBTRACT.laske(3.0, 2.0), is(1.0));
    }
    
   
    
}
