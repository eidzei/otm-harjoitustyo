package com.mycompany.unicafe;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class MaksukorttiTest {

    Maksukortti kortti;

    @Before
    public void setUp() {
        kortti = new Maksukortti(10);
    }

    @Test
    public void luotuKorttiOlemassa() {
        assertTrue(kortti!=null);      
    }
    
    @Test
    public void kortinSaldoAlussaOikein(){
        int raha = kortti.saldo();
        assertEquals(raha, kortti.saldo());
    }
    
    @Test
    public void rahanLataaminenKasvattaaSaldoaOikein(){
        kortti.lataaRahaa(3);
        assertEquals("saldo: 13.0", kortti.toString());
        
    }
    
    @Test
    public void rahaaTarpeeksiVaheneeOikein(){
        kortti.otaRahaa(5);
        //saldo 5 euroa
        assertEquals("saldo: 5.0", kortti.toString());
    }
    
    @Test
    public void saldoEiMuutuJosRahaaEiTarpeeksi(){
        kortti.otaRahaa(11);
        assertEquals("saldo: 10.0", kortti.toString());
    }
    
    @Test
    public void trueJosRahatRiittavat(){
        boolean otto = kortti.otaRahaa(5);
        assertTrue(otto==true);
    }
    
    @Test
    public void falseJosRahatEivatRiita(){
        boolean otto = kortti.otaRahaa(11);
        assertTrue(otto == false);
    }
}
