/*
 * Minesweeper Project
 * by Group3 : Arnaud BABOL, Guillaume Simmoneau
 */
package View.GraphicalViews.Scores;

import Model.Events.RefreshEvent;
import Model.Scores.Score;
import Model.Scores.ScoresModel;
import View.Events.ObservationEvent;
import View.Events.ValidateButtonEvent;
import View.GraphicalViews.Observer;
import View.GraphicalViews.ValidateButton;
import View.View;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Iterator;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author nono
 */
public class ScorePanel extends View  implements Observer{

    private JDialog scoreDialog = new JDialog();
    private JLabel[] labels = new JLabel[ScoresModel.NB_SCORES];
    private ValidateButton cancelButton = new ValidateButton("Hide");

    /**
     *
     */
    public ScorePanel() {
        /* Init JDialog */
        scoreDialog.setTitle("Best Scores");
        scoreDialog.setMinimumSize(new Dimension(400, 300));
        Container cp = scoreDialog.getContentPane();
        cp.setLayout(new BorderLayout());
        
        /* Scores */
        JPanel ScoresPanel = new JPanel(new GridLayout(ScoresModel.NB_SCORES, 1));
        for (int i = 0; i < ScoresModel.NB_SCORES; i++) {
            labels[i] = new JLabel(i+1+". No Score", JLabel.CENTER);
            ScoresPanel.add(labels[i]);
        }
        cp.add(ScoresPanel, BorderLayout.CENTER);
        
        /* Cancel Button */
        JPanel cancelPanel = new JPanel(new FlowLayout());
        cancelPanel.add(cancelButton);
        cp.add(cancelPanel, BorderLayout.SOUTH);
        cancelButton.addObserver(this);
    }

    /**
     *
     * @param event
     */
    @Override
    public void refresh(RefreshEvent event) {
        ScoresModel sm = (ScoresModel) event.getSource();
        scoreDialog.setTitle(sm.getAskedScores()+" best scores");
        scoreDialog.setVisible(true);
        Iterator<Score> itr = sm.getBestScores().iterator();
        int number = 0;
        while (itr.hasNext()) {
            Score score = itr.next();
            Calendar date = score.getDate();
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
            String strDate = "";
            if (date != null) {
                strDate = sdf.format(date.getTime());
            }
            int place = number+1;
            labels[number].setText("<html><b>"+place+" : </b> <font color=green>"+score.getTime()+"</font> by <i color=green>"+score.getPseudo()+"</i> le <i>"+strDate+"</i></html>");
            number++;
        }
        for (int i = number; i < ScoresModel.NB_SCORES; i++) {
            labels[i].setText(i+1+" : No Score");
        }
    }

    /**
     *
     * @param ev
     */
    @Override
    public void reactToChanges(ObservationEvent ev) {
        if(ev instanceof ValidateButtonEvent){
            scoreDialog.setVisible(false);
        }
    }
    
}
