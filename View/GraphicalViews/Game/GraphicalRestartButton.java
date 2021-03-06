/*
 * Minesweeper Project
 * by Group3 : Arnaud BABOL, Guillaume SIMMONEAU
 */
package View.GraphicalViews.Game;

import Controler.Minesweeper;
import java.awt.event.MouseEvent;
import javax.swing.Icon;

/**
 *
 * @author nono
 */
public class GraphicalRestartButton extends AbstractButtonView {

    /**
     *
     */
    public GraphicalRestartButton() {
        super("");
    }

    /**
     *
     * @param img
     */
    public final void setImg(Icon img) {
        cellLabel.setIcon(img);
    }

    /**
     *
     * @param e
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getButton() == 1) {
            Minesweeper.getInstance().restart();
        }
    }
}
