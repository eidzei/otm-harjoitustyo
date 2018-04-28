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
import funktiolaskin.laskin.Functions;
import static org.hamcrest.CoreMatchers.*;


public class FunktiotTest {
    
    Functions funk;
    
    @Test
    public void funktiotToStringToimii() {
        assertEquals(funk.SQUERE.toString(), "x\u00B2");
        assertEquals(funk.CUBE.toString(), "x\u00B3");
        assertEquals(funk.ONEPERX.toString(), "1/x");
        assertEquals(funk.LNX.toString(), "ln");
        assertEquals(funk.LOGTEN.toString(), "log\u2081\u2080");
        assertEquals(funk.SQUEROROOT.toString(), "\u221A");
        assertEquals(funk.CUBICROOT.toString(), "\u221B");
        assertEquals(funk.SIN.toString(), "sin");
        assertEquals(funk.COS.toString(), "cos");
        assertEquals(funk.TAN.toString(), "tan");
    }
    
    @Test
    public void laskeeOikein() {
        assertThat(funk.SQUERE.laske(3.0), is(9.0));
        assertThat(funk.CUBE.laske(3.0), is(27.0));
        assertThat(funk.ONEPERX.laske(2.0), is (0.5));
        assertThat(funk.SQUEROROOT.laske(49.0), is(7.0));
        assertThat(funk.LNX.laske(1.0), is(0.0));
        assertThat(funk.LOGTEN.laske(10.0), is(1.0));
        assertThat(funk.SIN.laske(Math.PI/2.0), is(0.9999999999999999999));
        assertThat(funk.COS.laske(Math.PI), is(-1.0));
        assertThat(funk.CUBICROOT.laske(8.0), is(2.0));
        //assertThat(funk.TAN.laske(Math.PI/4.0), is(0.9999999999999999999));
    }
    
}
