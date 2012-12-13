/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package View.GraphicalViews;

import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;

/**
 *
 * @author nono
 */
public enum Img {
    STOIC("stoic.gif"),
    WIN("win.png"),
    LOSE("lose.png"),
    MINE("mine.png"),
    FLAG("flag.gif"),
    TEMPFLAG("tempflag.png");

    private Image image;

    private Img(String path)
    {
        URL url = getClass().getResource("Resources/"+path);
        image = Toolkit.getDefaultToolkit().getImage(url);
    }

    public Image getImage() {
        return image;
    }
    
    
}
