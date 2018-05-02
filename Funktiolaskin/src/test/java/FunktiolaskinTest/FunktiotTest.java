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
    public void nelioToString() {
        assertEquals(funk.SQUERE.toString(), "x\u00B2");
    }
    
    @Test
    public void kuutioToString() {
        assertEquals(funk.CUBE.toString(), "x\u00B3");
    }
    
    @Test
    public void yksperxToString() {
        assertEquals(funk.ONEPERX.toString(), "1/x");
    }
    
    @Test
    public void lnxToString() {
        assertEquals(funk.LNX.toString(), "ln");
    }
    
    @Test
    public void logtenToString() {
        assertEquals(funk.LOGTEN.toString(), "log\u2081\u2080");
    }
    
    @Test
    public void neliojuuriToString() {
        assertEquals(funk.SQUEROROOT.toString(), "\u221A");
    }
    
    @Test
    public void kuutiojuuriToString() {
        assertEquals(funk.CUBICROOT.toString(), "\u221B");
    }
    
    @Test
    public void sinToString() {
        assertEquals(funk.SIN.toString(), "sin");
    }
    
    @Test
    public void cosToString() {
        assertEquals(funk.COS.toString(), "cos");
    }
    
    @Test
    public void tanToString() {
        assertEquals(funk.TAN.toString(), "tan");
    }
    
    
    @Test
    public void nelioOikein() {
        assertThat(funk.SQUERE.laske(3.0), is(9.0));
    }
    
    @Test
    public void kuutioOikein() {
        assertThat(funk.CUBE.laske(3.0), is(27.0));
    }
    
    @Test
    public void yksperxOikein() {
        assertThat(funk.ONEPERX.laske(2.0), is (0.5));
    }
    
    @Test
    public void neliojuuriOikein() {
        assertThat(funk.SQUEROROOT.laske(49.0), is(7.0));
    }
    
    @Test
    public void lnxOikein() {
        assertThat(funk.LNX.laske(1.0), is(0.0));
    }
    
    @Test
    public void logtenOikein() {
        assertThat(funk.LOGTEN.laske(10.0), is(1.0));
    }
    
    @Test
    public void sinOikein() {
        assertThat(funk.SIN.laske(Math.PI/2.0), is(0.9999999999999999999));
    }
    
    @Test
    public void cosOikein() {
        assertThat(funk.COS.laske(Math.PI), is(-1.0));
    }
    
    @Test
    public void tanOikein() {
        //assertThat(funk.TAN.laske(Math.PI/4.0), is(0.9999999999999999999));
    }
    
    @Test
    public void kuutiojuuriOikein() {
        assertThat(funk.CUBICROOT.laske(8.0), is(2.0));
    }
    
}
