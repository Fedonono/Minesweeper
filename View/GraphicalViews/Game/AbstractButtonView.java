/*
 * Minesweeper Project
 * by Group3 : Arnaud BABOL, Guillaume SIMMONEAU
 */
package View.GraphicalViews.Game;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JLabel;

/**
 *
 * @author nono
 */
public abstract class AbstractButtonView extends JButton implements MouseListener {

    JLabel cellLabel;

    /**
     *
     * @param text
     */
    public AbstractButtonView(String text) {
        super();
        cellLabel = new JLabel(text);
        cellLabel.setAlignmentX(0.5f);
        this.add(cellLabel);
    }

    
    /**
     *
     * @param me
     */
    @Override
    public void mouseClicked(MouseEvent me) {    
    }    

    /**
     *
     * @param me
     */
    @Override
    public void mousePressed(MouseEvent me) {    
    }

    /**
     *
     * @param me
     */
    @Override
    public void mouseReleased(MouseEvent me) {        
    }

    /**
     *
     * @param me
     */
    @Override
    public void mouseEntered(MouseEvent me) {       
    }

    /**
     *
     * @param me
     */
    @Override
    public void mouseExited(MouseEvent me) {       
    }
}
