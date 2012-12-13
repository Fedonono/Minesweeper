/*
 * Minesweeper Project
 * by Group3 : Arnaud BABOL, Guillaume Simmoneau
 */
package View.GraphicalViews.Game;

import Model.Events.ChronometerEvent;
import Model.Events.RefreshEvent;
import Model.Game.WorldModel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author nono
 */
public class GamePanel extends JPanel {
    private GraphicalGridView gGV;
    private GraphicalRestartButton imgButton;
    private JLabel remainingMines;
    private JLabel timer = new JLabel("Time :  ");

    /**
     *
     * @param width
     * @param height
     * @param remaingMines
     */
    public GamePanel(int width, int height, String remaingMines) {
        this.setLayout(new BorderLayout());

        /* Image */
        this.imgButton = new GraphicalRestartButton();
        this.imgButton.setImg(GraphicalGameView.stoicImg);
        this.imgButton.addMouseListener(this.imgButton);
        JPanel panel = new JPanel();
        panel.add(this.imgButton);
        panel.add(this.timer);
        this.add(panel, BorderLayout.NORTH);
        
        /* Grid */
        this.gGV = new GraphicalGridView(width, height);
        this.add(gGV,BorderLayout.CENTER);
        
        /* Remaining Mines */
        remainingMines = new JLabel(remaingMines, JLabel.CENTER);
        this.add(remainingMines,BorderLayout.SOUTH);
    }

    /**
     *
     * @param ev
     */
    public void refreshGrid(RefreshEvent ev) {
        this.gGV.refreshCell(ev);
    }
    
    /**
     *
     * @param ev
     */
    public void refreshRemainingMines (RefreshEvent ev) {
        WorldModel wm = (WorldModel)ev.getSource();
        this.remainingMines.setText("");
        this.remainingMines.setText(wm.getMessage());
    }
    /**
     *
     * @param ev
     */
    public void refreshTime (RefreshEvent ev) {
        ChronometerEvent event = (ChronometerEvent) ev;
        this.timer.setText(event.getTime());
    }
    /**
     *
     * @param event
     */
    public void resize(RefreshEvent event){
        this.gGV.resize(event);
    }
    /**
     *
     * @param event
     */
    public void refreshImg(RefreshEvent event) {
        WorldModel wm = (WorldModel)event.getSource();
        int win = wm.getWin();
        switch (win) {
            case -1:
                this.imgButton.setImg(GraphicalGameView.loseImg);
                break;
            case 0:
                this.imgButton.setImg(GraphicalGameView.stoicImg);
                break;
            case 1:
                this.imgButton.setImg(GraphicalGameView.winImg);
                break;
            default:
                throw new AssertionError();
        }
    }
}
