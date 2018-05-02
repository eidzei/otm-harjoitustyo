
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
    public void acosToString() {
        assertEquals(funk.ACOS.toString(), "cos\u207B\u00B9");
    }
    
    @Test
    public void asinToString() {
        assertEquals(funk.ASIN.toString(), "sin\u207B\u00B9");
    }
    
    @Test
    public void atanToString() {
        assertEquals(funk.ATAN.toString(), "tan\u207B\u00B9");
    }
    
    @Test
    public void etoxToString() {
        assertEquals(funk.ETOX.toString(), "e\u02E3");
    }
    
    @Test
    public void etoxmyksToString() {
        assertEquals(funk.EXPM1.toString(), "e\u02E3-1");
    }
    
    @Test
    public void tentoxToString() {
        assertEquals(funk.TENTOX.toString(), "10\u02E3");
    }
    
    @Test
    public void twotoxToString() {
        assertEquals(funk.TWOTOX.toString(), "2\u02E3");
    }
    
    @Test
    public void coshToString() {
        assertEquals(funk.COSH.toString(), "cosh");
    }
    
    @Test
    public void sinhToString() {
        assertEquals(funk.SINH.toString(), "sinh");
    }
    
    @Test
    public void tanhToString() {
        assertEquals(funk.TANH.toString(), "tanh");
    }
    
    
    @Test
    public void acosOikein() {
        assertThat(funk.ACOS.laske(1.0), is(0.0));
    }
    
    @Test
    public void asinOikein() {
        assertThat(funk.ASIN.laske(0.0), is(0.0));
    }
    
    @Test
    public void atanOikein() {
        assertThat(funk.ATAN.laske(0.0), is (0.0));
    }
    
    @Test
    public void etoxOikein() {
        assertThat(funk.ETOX.laske(0.0), is(1.0));
    }
    
    @Test
    public void etoxmyksOikein() {
        assertThat(funk.EXPM1.laske(0.0), is(0.0));
    }
    
    @Test
    public void tentoxOikein() {
        assertThat(funk.TENTOX.laske(1.0), is(10.0));
    }
    
    @Test
    public void twotoxOikein() {
        assertThat(funk.TWOTOX.laske(3.0), is(8.0));
    }
    
    @Test
    public void coshOikein() {
        assertThat(funk.COSH.laske(0.0), is(1.0));
    }
    
    @Test
    public void sinhOikein() {
        assertThat(funk.SINH.laske(0.0), is(0.0));
    }
    
    @Test
    public void tanhOikein() {
        assertThat(funk.TANH.laske(20.0), is(1.0));
    }
    
    
    
}
