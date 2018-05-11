
package funktiolaskin.snapshot;

import funktiolaskin.ui.PrintButton;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.Scene;
import javafx.scene.image.WritableImage;
import javax.imageio.ImageIO;


public class Snapshot {
    public static boolean takeSnapShot(Scene scene) {
        WritableImage writableImage = 
                new WritableImage((int)scene.getWidth(), (int)scene.getHeight());
        scene.snapshot(writableImage);
        
        File file = new File("funktiolaskin_snapshot.png");
        try {
            ImageIO.write(SwingFXUtils.fromFXImage(writableImage, null), "png", file);
            return true;
        } catch (IOException ex) {
            Logger.getLogger(PrintButton.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
