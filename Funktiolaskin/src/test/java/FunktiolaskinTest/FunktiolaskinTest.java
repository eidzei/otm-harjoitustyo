
package FunktiolaskinTest;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import funktiolaskin.laskin.*;
import funktiolaskin.ui.*;


public class FunktiolaskinTest {
    
    Funktiolaskin laskin;
    GuiMain gui;
    
    @Before
    public void setUp() {
        laskin = new Funktiolaskin();
        gui = new GuiMain();
        gui.naytto();
    }
    
    
    
}
