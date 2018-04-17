
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
    Operaattori raattori;
    
    @Test    
    public void operaatiotNimet() {
        assertEquals(raattori.KERTO.toString(), "*");
        assertEquals(raattori.JAKO.toString(), "\u00F7");
        assertEquals(raattori.LISAYS.toString(), "+");
        assertEquals(raattori.VAHENNYS.toString(), "-");
    }
    
    @Test
    public void laskeeOikein() {
        assertThat(raattori.JAKO.laske(4.0, 2.0), is(2.0));
        assertThat(raattori.KERTO.laske(2.0, 2.0), is(4.0));
        assertThat(raattori.LISAYS.laske(2.0, 1.0), is(3.0));
        assertThat(raattori.VAHENNYS.laske(3.0, 2.0), is(1.0));
    }
    
   
    
}
