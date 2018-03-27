/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.unicafe;

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
public class KassapaateTest {
    
    Kassapaate kassa;
    Maksukortti kortti;
    
    
    @Before
    public void setUp() {
        kassa = new Kassapaate();
        kortti = new Maksukortti(2000);
    }
    
    @Test
    public void luodunPaatteenRahamaaraOikein(){
        int raha = kassa.kassassaRahaa();
        assertEquals(1000, raha);
    }
    
    @Test
    public void myydytEdullisetAlussa(){
        int edulliset = kassa.edullisiaLounaitaMyyty();
        assertEquals(0, edulliset);
    }
    
    @Test
    public void myydytMaukkaatAlussa(){
        int maukkaat = kassa.maukkaitaLounaitaMyyty();
        assertEquals(0, maukkaat);           
    }
    
    @Test
    public void josMaksuRiittavaKassaKasvaaOikein(){
        int kassassaAlussa=kassa.kassassaRahaa();
        kassa.syoEdullisesti(250);
        kassa.syoMaukkaasti(410);
        assertEquals(kassassaAlussa + 240 + 400, kassa.kassassaRahaa());
    }
    
    @Test 
    public void josMaksuRiittavaVaihtorahaOikein(){
        int palautusEdullinen=kassa.syoEdullisesti(250);
        int palautusMaukas = kassa.syoMaukkaasti(410);
        assertEquals(10, palautusEdullinen);
        assertEquals(10, palautusMaukas);
        
    }
    
    @Test
    public void josMaksuRiittavaMyytyjenLounaidenMaaraKasvaaOikein(){
        int myydytEdulliset = kassa.edullisiaLounaitaMyyty();
        kassa.syoEdullisesti(250);
        int myydytMaukkaat = kassa.maukkaitaLounaitaMyyty();
        kassa.syoMaukkaasti(410);
        assertEquals(myydytEdulliset + 1, kassa.edullisiaLounaitaMyyty());
        assertEquals(myydytMaukkaat + 1, kassa.maukkaitaLounaitaMyyty());
    }
    
    @Test
    public void josMaksuEiRiitaRahamaaraKassassaEiMuutu(){
        int myytyjenEdullistenMaara= kassa.edullisiaLounaitaMyyty();
        int myytyjenMaukkaidenMaara = kassa.maukkaitaLounaitaMyyty();
        kassa.syoEdullisesti(230);
        kassa.syoMaukkaasti(390);
        assertEquals(myytyjenEdullistenMaara, kassa.edullisiaLounaitaMyyty());
        assertEquals(myytyjenMaukkaidenMaara, kassa.maukkaitaLounaitaMyyty());
    }
    
    @Test
    public void josMaksuEiRiitaKaikkiRahatPalautetaan(){
        int palautusEdullinen = kassa.syoEdullisesti(230);
        int palautusMaukas = kassa.syoMaukkaasti(390);
        assertEquals(palautusEdullinen, 230);
        assertEquals(palautusMaukas, 390);
    }
    
    @Test
    public void josMaksuEiRiitaMyytyjenLounaidenMaaraEiMuutu(){
        int maukkaitaAlussa = kassa.maukkaitaLounaitaMyyty();
        int edullisiaAlussa = kassa.edullisiaLounaitaMyyty();
        kassa.syoEdullisesti(230);
        kassa.syoMaukkaasti(390);
        assertEquals(maukkaitaAlussa, kassa.maukkaitaLounaitaMyyty());
        assertEquals(edullisiaAlussa, kassa.edullisiaLounaitaMyyty());
        
    }
    
    @Test
    public void josKortillaRiittavastiRahaaVeloitetaanEdullinenJaTrue(){
        int saldo = kortti.saldo();
        kassa.syoEdullisesti(kortti);
        assertEquals(saldo - 240, kortti.saldo());
    }
    
    @Test
    public void josKortillaRiittavastiTrueEdullisesti(){
        assertTrue(kassa.syoEdullisesti(kortti));
    }
    
    @Test
    public void josKortillaRiittavastiRahaaMyytyjenMaaraKasvaaEdullinen(){
        int myytyjenMaara = kassa.edullisiaLounaitaMyyty();
        kassa.syoEdullisesti(kortti);
        assertEquals(myytyjenMaara +1, kassa.edullisiaLounaitaMyyty());
    }
    
    @Test
    public void josKortillaRiittavastiRahaaVeloitetaanMaukkaasti(){
        int saldo = kortti.saldo();
        kassa.syoMaukkaasti(kortti);
        assertEquals(saldo - 400, kortti.saldo());
    }
    
    @Test
    public void josKortillaRiittavastiTrueMaukkaasti(){
        assertTrue(kassa.syoMaukkaasti(kortti));
    }
    
    @Test
    public void josKortillaRiittavastiRahaaMyytyjenMaaraKasvaaMaukkaasti(){
        int myytyjenMaara = kassa.maukkaitaLounaitaMyyty();
        kassa.syoMaukkaasti(kortti);
        assertEquals(myytyjenMaara +1, kassa.maukkaitaLounaitaMyyty());
    }
    
    @Test
    public void eiRiittavastiRahaaKortillaEdullinen(){
        kassa.syoMaukkaasti(kortti);
        kassa.syoMaukkaasti(kortti);
        //kortin saldo 2 euroa
        int myytyjenMaara = kassa.edullisiaLounaitaMyyty();
        int saldo = kortti.saldo();
        boolean eiRiittavasti = kassa.syoEdullisesti(kortti);
        assertEquals(eiRiittavasti, false);
        assertEquals(myytyjenMaara, kassa.edullisiaLounaitaMyyty());
        assertEquals(saldo, kortti.saldo());
        
    }
    
    @Test
    public void eiRiittavastiRahaaKortillaMaukkaasti(){
        kassa.syoMaukkaasti(kortti);
        kassa.syoMaukkaasti(kortti);
        //kortin saldo 2 euroa
        int myytyjenMaara = kassa.maukkaitaLounaitaMyyty();
        int saldo = kortti.saldo();
        boolean eiRiittavasti = kassa.syoMaukkaasti(kortti);
        assertEquals(eiRiittavasti, false);
        assertEquals(myytyjenMaara, kassa.maukkaitaLounaitaMyyty());
        assertEquals(saldo, kortti.saldo());
        
    }
    
    @Test
    public void kassassaOlevaRahamaaraEiMuutuKortillaOstettaessa(){
        int rahamaara = kassa.kassassaRahaa();
        kassa.syoEdullisesti(kortti);
        kassa.syoMaukkaasti(kortti);
        assertEquals(rahamaara, kassa.kassassaRahaa());
    }
    
    @Test
    public void kortinLataus(){
        int kortinSaldo = kortti.saldo();
        int kassanSaldo = kassa.kassassaRahaa();
        kassa.lataaRahaaKortille(kortti, 30);
        assertEquals(kortinSaldo + 30, kortti.saldo());
        assertEquals(kassanSaldo + 30, kassa.kassassaRahaa());
    }
    
    @Test
    public void negatiivinenKortinLataus(){
        int kortinSaldo = kortti.saldo();
        kassa.lataaRahaaKortille(kortti, -1);
        assertEquals(kortinSaldo, kortti.saldo());
    }
  
}
