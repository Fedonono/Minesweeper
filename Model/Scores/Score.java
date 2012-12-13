/*
 * Minesweeper Project
 * by Group3 : Arnaud BABOL, Guillaume Simmoneau
 */
package Model.Scores;

import java.io.Serializable;
import java.util.Calendar;

/**
 *
 * @author nono
 */
public class Score implements Comparable, Serializable {
    private String pseudo;
    private int time;
    private Calendar date;

    /**
     *
     * @param pseudo
     * @param time
     * @param date
     */
    public Score(String pseudo, int time, Calendar date) {
        this.pseudo = pseudo;
        this.time = time;
        this.date = date;
    }

    /**
     *
     * @return
     */
    public String getPseudo() {
        return pseudo;
    }
    
    /**
     *
     * @return
     */
    public int getTime() {
        return time;
    }

    /**
     *
     * @return
     */
    public Calendar getDate() {
        return date;
    }    

    /**
     *
     * @param o
     * @return
     */
    @Override
    public int compareTo(Object o) {
        int time1 = ((Score) o).getTime(); 
        int time2 = this.getTime(); 
        if (time1 > time2) {
            return -1;
        } 
        else if(time1 == time2) {
            return 0;
        } 
        else {
            return 1;
        } 
    }
}
