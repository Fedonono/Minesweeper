/*
 * Minesweeper Project
 * by Group3 : Arnaud BABOL, Guillaume Simmoneau
 */
package View.GraphicalViews.Game;

import Controler.Minesweeper;
import Model.Events.ChronometerEvent;
import Model.Events.EndGameEvent;
import Model.Events.LocalGameRefreshEvent;
import Model.Events.RefreshEvent;
import Model.Events.ResizeEvent;
import Model.Events.TotalGameRefreshEvent;
import View.GraphicalViews.Img;
import View.GraphicalViews.MainPanel;
import View.View;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author nono
 */
public class GraphicalGameView extends View {

    public static final Icon winImg = new ImageIcon(Img.WIN.getImage());
    public static final Icon loseImg = new ImageIcon(Img.LOSE.getImage());
    public static final Icon stoicImg = new ImageIcon(Img.STOIC.getImage());
    /**
     *
     */
    public static final String appName = "MineSweeper";
    /**
     *
     */
    public static final int caseH = 55;
    /**
     *
     */
    public static final int caseW = 55;
    private MainPanel mainPanel;
    

    /**
     *
     * @param width
     * @param height
     * @param bombNumber
     * @param isThorique
     * @param remainingMines
     * @param mod
     */
    public GraphicalGameView(int width, int height, int bombNumber, boolean isThorique, String remainingMines) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(GraphicalGameView.class.getName()).log(Level.SEVERE, null, ex);
        }

        mainPanel = new MainPanel(this, width, height, remainingMines);
        
    }

    /**
     *
     * @param event
     */
    @Override
    public void refresh(RefreshEvent event) {
        Class eventClass = event.getClass();

        if (eventClass == LocalGameRefreshEvent.class) {
            mainPanel.refreshGrid(event);
        } else if (eventClass == TotalGameRefreshEvent.class) {
            mainPanel.refreshRemainingMines(event);
        } else if (eventClass == ChronometerEvent.class) {
            mainPanel.refreshTime(event);
        } else if (eventClass == ResizeEvent.class) {
            Minesweeper.getInstance().resize(event);
            mainPanel.resize(event);
            mainPanel.refreshRemainingMines(event);
            mainPanel.refreshImg(event);
        } else if (eventClass == EndGameEvent.class) {
            mainPanel.refreshRemainingMines(event);
            mainPanel.refreshImg(event);           
        }
    }

    public JPanel getPanel() {
        return this.mainPanel;
    }
}
