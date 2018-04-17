/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunktiolaskinTest;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import java.lang.Math.*;
import static org.junit.Assert.*;
import funktiolaskin.laskin.Funktiot;
import static org.hamcrest.CoreMatchers.*;


public class FunktiotTest {
    
    Funktiot funk;
    
    @Test
    public void funktiotToStringToimii() {
        assertEquals(funk.NELIO.toString(), "x^2");
        assertEquals(funk.KUUTIO.toString(), "x^3");
        assertEquals(funk.YKSPERX.toString(), "1/x");
        assertEquals(funk.LNX.toString(), "ln x");
        assertEquals(funk.LOGTEN.toString(), "log10");
        assertEquals(funk.NELIOJUURI.toString(), "\u221A");
        assertEquals(funk.SIN.toString(), "sin");
        assertEquals(funk.COS.toString(), "cos");
        assertEquals(funk.TAN.toString(), "tan");
    }
    
    @Test
    public void laskeeOikein() {
        assertThat(funk.NELIO.laske(3.0), is(9.0));
        assertThat(funk.KUUTIO.laske(3.0), is(27.0));
        assertThat(funk.YKSPERX.laske(2.0), is (0.5));
        assertThat(funk.NELIOJUURI.laske(49.0), is(7.0));
        assertThat(funk.LNX.laske(1.0), is(0.0));
        assertThat(funk.LOGTEN.laske(10.0), is(1.0));
        assertThat(funk.SIN.laske(Math.PI/2.0), is(0.9999999999999999999));
        assertThat(funk.COS.laske(Math.PI), is(-1.0));
        //assertThat(funk.TAN.laske(Math.PI/4.0), is(0.9999999999999999999));
    }
    
}
