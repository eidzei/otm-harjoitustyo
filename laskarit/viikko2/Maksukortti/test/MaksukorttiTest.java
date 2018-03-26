/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author eidzey
 */
public class MaksukorttiTest {
    
    Maksukortti kortti;
    
    @Before
    public void setUp() {
        kortti = new Maksukortti(10);
    }
    
     @Test
     public void hello() {}
     
     @Test
     public void konstruktoriAsettaaSaldonOikein() {
         assertEquals("Kortilla on rahaa 10.0 euroa", kortti.toString());
    }
     
    @Test
    public void syoEdullisesti() {
        kortti.syoEdullisesti();
        
        assertEquals("Kortilla on rahaa 7.5 euroa", kortti.toString());
    }
    
    @Test
    public void syoMaukkaastiVahentaaSaldoaOikein(){
        kortti.syoMaukkaasti();
        
        assertEquals("Kortilla on rahaa 6.0 euroa", kortti.toString());
    }
    
    @Test
    public void syoEdullisestiEiVieSaldoaNegatiiviseksi(){
        kortti.syoMaukkaasti();
        kortti.syoMaukkaasti();
        //nyt kortin saldo on 2
        kortti.syoEdullisesti();
        
        assertEquals("Kortilla on rahaa 2.0 euroa", kortti.toString());
    }
    
    @Test
    public void kortilleVoiLadataRahaa(){
        kortti.lataaRahaa(25);
        assertEquals("Kortilla on rahaa 35.0 euroa", kortti.toString());
    }
    
    @Test 
    public void kortinSaldoEiVoiYlittaaMaksimiarvoa(){
        kortti.lataaRahaa(200);
        assertEquals("Kortilla on rahaa 150.0 euroa", kortti.toString());
    }
    
    @Test
    public void syoMaukkaastiEiVieSaldoaNegatiiviseksi(){
        kortti.syoMaukkaasti();
        kortti.syoEdullisesti();
        //kortilla on rahaa 3.5 euroa
        kortti.syoMaukkaasti();
        
        assertEquals("Kortilla on rahaa 3.5 euroa", kortti.toString());
    }
    
    @Test
    public void negatiivisenSummanLataaminenEiMuutaSaldoa(){
        kortti.lataaRahaa(-5);
        assertEquals("Kortilla on rahaa 10.0 euroa", kortti.toString());
    }
    
    @Test
    public void voiOstaaEdullisenLounaanKunKortillaTasaraha(){
        kortti.syoEdullisesti();
        kortti.syoEdullisesti();
        kortti.syoEdullisesti();
        //kortilla rahaa 2.5 euroa
        kortti.syoEdullisesti();
        assertEquals("Kortilla on rahaa 0.0 euroa", kortti.toString());
    }
    
    @Test
    public void voiOstaaMaukkaanLounaanKunKortillaTasaraha(){
        kortti.lataaRahaa(2.0);
        kortti.syoMaukkaasti();
        kortti.syoMaukkaasti();
        //kortilla rahaa 4.0 euroa
        kortti.syoMaukkaasti();
        kortti.syoMaukkaasti();
        
        assertEquals("Kortilla on rahaa 0.0 euroa", kortti.toString());
    }
}
