
package FunktiolaskinTest;

import funktiolaskin.laskin.SecondFunctions;
import static org.hamcrest.CoreMatchers.is;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class SecondFunktiotTest {
    
    SecondFunctions funk;
    
    @Test
    public void funktiotToStringToimii() {
        assertEquals(funk.ACOS.toString(), "cos\u207B\u00B9");
        assertEquals(funk.ASIN.toString(), "sin\u207B\u00B9");
        assertEquals(funk.ATAN.toString(), "tan\u207B\u00B9");
        assertEquals(funk.ETOX.toString(), "e\u02E3");
        assertEquals(funk.EXPM1.toString(), "e\u02E3-1");
        assertEquals(funk.TENTOX.toString(), "10\u02E3");
        assertEquals(funk.TWOTOX.toString(), "2\u02E3");
        assertEquals(funk.COSH.toString(), "cosh");
        assertEquals(funk.SINH.toString(), "sinh");
        assertEquals(funk.TANH.toString(), "tanh");
    }
    
    @Test
    public void laskeeOikein() {
        assertThat(funk.ACOS.laske(1.0), is(0.0));
        assertThat(funk.ASIN.laske(0.0), is(0.0));
        assertThat(funk.ATAN.laske(0.0), is (0.0));
        assertThat(funk.ETOX.laske(0.0), is(1.0));
        assertThat(funk.EXPM1.laske(0.0), is(0.0));
        assertThat(funk.TENTOX.laske(1.0), is(10.0));
        assertThat(funk.TWOTOX.laske(3.0), is(8.0));
        assertThat(funk.COSH.laske(0.0), is(1.0));
        assertThat(funk.SINH.laske(0.0), is(0.0));
        assertThat(funk.TANH.laske(20.0), is(1.0));
    }
    
}
