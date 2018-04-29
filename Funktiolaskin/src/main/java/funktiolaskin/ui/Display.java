
package funktiolaskin.ui;


import javafx.scene.layout.VBox;
import javafx.scene.control.TextField;

/**
 * Luokka luo laskimen näytön ja kaksi tekstikenttää
 */
public class Display extends VBox {

    
    private static VBox display;
    private static TextField secondary;
    private static TextField main;
    private static boolean resultDisplayed;
    
    /**
     * Näyton asettelu
     */
    public Display() {
        display = new VBox();
        
        secondary = new TextField();
        secondary.setStyle("-fx-font-size: 10; -fx-text-fill: gray");
        secondary.setMaxWidth(615);
        secondary.setEditable(false);
        
        //tähän kirjoitetaan
        main = new TextField();
        main.setStyle("-fx-font-size: 20");
        main.setMaxWidth(615);
        main.setEditable(false);
        
        display.getChildren().addAll(secondary, main);

    }

    /**
     * Metodi palauttaa näyton VBoxin
     * 
     * @return palauttaa näytön VBoxin
     */
    public static VBox getDisplay() {
        return display;
    }
    
    /**
     * Palauttaa ylemmän teksitikentän, 
     * jossa näkyy edellinen luku ja operaattori
     * 
     * @return näytön ylempi tekstikenttä
     */
    public static TextField getSecondary() {
        return secondary;
    }
    
    /**
     * Palauttaa alemman tekstikentän, jossa aktiivinen luku
     * 
     * @return näytön alempi tekstikenttä 
     */
    public static TextField getMain() {
        return main;
    }
    /**
     * Metodi kertoo, onko tulos näytetty 
     * 
     * @return tulos näytetty 
     */
    public static boolean getDisplayed() {
        return resultDisplayed;
    }
    
    /**
     * Metodi asettaa alemman tekstikentän tekstiksi annetun syötteen 
     *
     * @param   value   asetettava teksti
     * 
     */
    public static void setMain(String value) {
        main.setText(value);
    }
    
    /**
     * Metodi asettaa ylemmän tekstikentän tekstiksi annetun syötteen
     *
     * @param value asetettava teksti
     */
    public static void setSecondary(String value) {
        secondary.setText(value);
    }
    
    /**
     * Metodi muuttaa tietoa, onko tulos näytetty
     * 
     * @param boo tulos näytetty
     */
    public static void setResultDisplayed(boolean boo) {
        resultDisplayed = boo;
    }
    
   

}
