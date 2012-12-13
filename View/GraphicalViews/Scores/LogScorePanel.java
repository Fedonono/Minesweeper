/*
 * Minesweeper Project
 * by Group3 : Arnaud BABOL, Guillaume Simmoneau
 */
package View.GraphicalViews.Scores;

import Controler.Minesweeper;
import Model.Events.RefreshEvent;
import Model.Game.WorldModel;
import Model.Options.GameDifficulty;
import View.Events.ObservationEvent;
import View.GraphicalViews.Observer;
import View.GraphicalViews.ValidateButton;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.GregorianCalendar;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author simonneau
 */
public class LogScorePanel extends JDialog implements Observer{
    
    private static final String DEFAULT_PSEUDO ="anonymous";
    private int score;
    private GameDifficulty gd;
    
    private JTextField pseudo = new JTextField(LogScorePanel.DEFAULT_PSEUDO);
    private ValidateButton save = new ValidateButton("save");

    /**
     *
     */
    public LogScorePanel() {
        this.setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
        this.setVisible(false);
        Container cp = this.getContentPane();
        cp.setLayout(new FlowLayout());
        this.setMinimumSize(new Dimension(200,115));
        this.add(new JLabel("Save your score !"));
        this.add(pseudo);
        this.add(save);
        save.addObserver(this);
    }

    /**
     *
     * @param ev
     */
    @Override
    public void reactToChanges(ObservationEvent ev) {
        Minesweeper.getInstance().getScores().saveScore(pseudo.getText(), this.score, new GregorianCalendar(), this.gd.getName());
        this.setVisible(false);
    }
    
    /**
     *
     * @param event
     */
    public void refresh(RefreshEvent event){
        WorldModel wm = (WorldModel)event.getSource();
        this.score = wm.getTime();
        this.gd = wm.getGameDifficulty();
        Minesweeper.getInstance().getScores().LoadScores(gd.getName());
        
        if(Minesweeper.getInstance().getScores().isBetterThanLastPerformanceSaved(this.score)){
            this.setVisible(true);
        }
    }    
}
