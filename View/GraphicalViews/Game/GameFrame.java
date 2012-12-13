/*
 * Minesweeper Project
 * by Group3 : Arnaud BABOL, Guillaume Simmoneau
 */
package View.GraphicalViews.Game;

import Model.Events.RefreshEvent;
import Model.Events.ResizeEvent;
import javax.swing.JFrame;

/**
 *
 * @author nono
 */
public class GameFrame extends JFrame {

    /**
     *
     * @param width
     * @param height
     */
    public GameFrame(int width, int height) {
        super(GraphicalGameView.appName);
        
        /* Config JFrame */
        this.configFrame(width, height);
    }

    private void configFrame(int width, int height) {
        this.setSize(width*GraphicalGameView.caseW, height*GraphicalGameView.caseH);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    /**
     *
     * @param ev
     */
    public void resize(RefreshEvent ev){
        ResizeEvent event = (ResizeEvent)ev;
        int width = event.getWidth();
        int height = event.getHeight();
        this.setSize(width*GraphicalGameView.caseW, height*GraphicalGameView.caseH);
    }
}
