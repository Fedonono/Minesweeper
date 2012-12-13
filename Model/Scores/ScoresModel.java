/*
 * Minesweeper Project
 * by Group3 : Arnaud BABOL, Guillaume SIMMONEAU
 */
package Model.Scores;

import Model.Events.RefreshEvent;
import Model.Events.ScoreEvent;
import Model.Model;
import View.View;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nono
 */
public class ScoresModel extends Model implements Serializable {
    private List<Score> bestScores;
    private String askedScores;
    /**
     * Number of scores/difficulty to keep in best Scores.
     */
    public static final int NB_SCORES = 5;
    
    /**
     *
     */
    public ScoresModel() {
        views = new LinkedList();
    }

    /**
     *
     * @param gD
     * 
     * Initialize bestScores with stocked data
     */
    public void LoadScores(String gD) {
        bestScores = new LinkedList();
        File file = new File(gD+".ser");
        if (file.exists()) {
            ObjectInputStream os = null;
            try {
                os = new ObjectInputStream(new FileInputStream(file));
                bestScores = (List<Score>) os.readObject();
            } catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(ScoresModel.class.getName()).log(Level.SEVERE, null, ex);
            }
            finally {
                if (os != null) {
                    try {
                        os.close();
                    } catch (IOException ex) {
                        Logger.getLogger(ScoresModel.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
    }

    /**
     *
     * @param pseudo
     * @param time
     * @param date
     * @param gD
     */
    public void saveScore(String pseudo, int time, Calendar date, String gD) {
        Score newScore = new Score(pseudo, time, date);
        ObjectOutputStream os = null;
        try {
            this.removeLastElement();
            os = new ObjectOutputStream(new FileOutputStream(gD+".ser", false));
            bestScores.add(newScore);
            Collections.sort(bestScores);
            os.writeObject(bestScores);
        } catch (IOException ioEx) {
            Logger.getLogger(ScoresModel.class.getName()).log(Level.SEVERE, null, ioEx);
        } finally {
            if (os != null) {
                try {
                    os.close();
                } catch (IOException ex) {
                    Logger.getLogger(ScoresModel.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    /**
     *
     * @return
     */
    public List<Score> getBestScores() {
        return bestScores;
    }

    private void removeLastElement() {
        if (bestScores.size() == NB_SCORES) {
            bestScores.remove(NB_SCORES-1);
        }
    }
    
    /**
     *
     * @param time
     * @return
     */
    public boolean isBetterThanLastPerformanceSaved(int time) {
        if (bestScores.size() < NB_SCORES) {
            return true;
        }
        else if (time < bestScores.get(NB_SCORES-1).getTime()) {
            return true;
        }
        return false;
    }

    /**
     *
     * @return
     */
    public String getAskedScores() {
        return askedScores;
    }

    /**
     *
     * @param askedScores
     */
    public void setAskedScores(String askedScores) {
        this.askedScores = askedScores;
    }

    /**
     *
     */
    @Override
    public void notifyViews() {
        this.LoadScores(this.getAskedScores());
        RefreshEvent e = new ScoreEvent(this);
        for (View v : this.views) {
            v.refresh(e);
        }
    }

    /**
     *
     * @return
     */
    @Override
    public Model clone() {
        return null;
    }
}
