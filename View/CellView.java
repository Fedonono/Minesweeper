/*
 * Minesweeper Project
 * by Group3 : Arnaud BABOL, Guillaume SIMMONEAU
 */
package View;

import Controler.Listeners.ViewListener;
import Model.Events.RefreshEvent;
import View.Events.CellEvent;
import View.GraphicalViews.Img;
import java.awt.Color;
import java.awt.Font;
import java.util.EventObject;
import java.util.LinkedList;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author simonneau
 */
public class CellView extends View {
    public static final String HOLLOW_FLAG = "#";
    public static final String MINE_FLAG = "!";
    public static final String TEMP_FLAG = "?";
    public static final String MINE_SYMBOL = "x";
    public static final String EMPTY_CELL_SYMBOL = "-";
    public static final Color[] neighborColor = {Color.blue, Color.green, Color.orange, Color.pink, Color.magenta, Color.red, Color.darkGray, Color.black};
    
    public static final Icon mineImg = new ImageIcon(Img.MINE.getImage());
    public static final Icon flagImg = new ImageIcon(Img.FLAG.getImage());
    public static final Icon tempFlagImg = new ImageIcon(Img.TEMPFLAG.getImage());
    
    /**
     * Font apply to the Neighbors Numbers
     */
    public static final Font StyleComic = new Font("Comic Sans Ms", Font.BOLD, 20);

    /**
     *
     */
    public CellView(){
        this.listeners = new LinkedList<>();
    }
    
    /**
     *
     * @param event
     */
    @Override
    public void refresh(RefreshEvent event) {
        // do nothing. Allow instanciation to decorate graphicalCellView.
    }

    /**
     *
     * @param aEv
     */
    public void notifyListeners(EventObject aEv) {
        for (ViewListener l : this.listeners) {
            l.catchViewEvent(new CellEvent(this, aEv));
        }
    }
}
