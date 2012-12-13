/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package View.GraphicalViews;

import Model.Events.RefreshEvent;
import View.GraphicalViews.Game.GamePanel;
import View.GraphicalViews.Game.GraphicalGameView;
import java.awt.BorderLayout;
import javax.swing.JPanel;

/**
 *
 * @author simonneau
 */
public class MainPanel extends JPanel{
    private GamePanel gp;
    private MenuBar menu;

    /**
     *
     * @param master
     * @param width
     * @param height
     * @param remainingMines
     */
    public MainPanel(GraphicalGameView master, int width, int height, String remainingMines) {
        super(new BorderLayout());
        gp = new GamePanel(width, height, remainingMines);
        menu = new MenuBar();
        
        this.add(menu, BorderLayout.NORTH);
        this.add(gp, BorderLayout.CENTER);
    }
    
    /**
     *
     * @param ev
     */
    public void refreshGrid(RefreshEvent ev) {
        this.gp.refreshGrid(ev);
    }
    
    /**
     *
     * @param ev
     */
    public void refreshRemainingMines (RefreshEvent ev) {
        this.gp.refreshRemainingMines(ev);
    }
    /**
     *
     * @param ev
     */
    public void refreshTime(RefreshEvent ev) {
        this.gp.refreshTime(ev);
    }
    /**
     *
     * @param event
     */
    public void resize(RefreshEvent event){
        this.gp.resize(event);
    }
    /**
     *
     * @param event
     */
    public void refreshImg(RefreshEvent event) {
        this.gp.refreshImg(event);
    }
}
