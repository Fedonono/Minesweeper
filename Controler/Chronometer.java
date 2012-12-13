/*
 * Minesweeper Project
 * by Group3 : Arnaud BABOL, Guillaume Simmoneau
 */
package Controler;

import java.awt.event.ActionListener;
import javax.swing.Timer;

/**
 *
 * @author nono
 */
public class Chronometer {

    private Timer chronometer;
    private int timeCount = 0;
    private static final int DEFAULT_TIMER_PERIOD = 1000;

    /**
     *
     * @param listener
     */
    public Chronometer(ActionListener listener) {
        this.chronometer = new Timer(DEFAULT_TIMER_PERIOD, listener);
    }

    /**
     *
     */
    public void restart() {
        this.setTime(0);
        this.chronometer.start();
    }    

    /**
     *
     */
    public void start() {
        this.chronometer.start();
    }

    /**
     *
     */
    public void stop() {
        this.chronometer.stop();
    }
    
    /**
     *
     * @param time
     */
    public void setTime(int time) {
        this.timeCount = time;
    }
    
    /**
     *
     * @return
     */
    public int getTime() {
        return this.timeCount;
    }
    
    /**
     *
     */
    public void incrTime() {
        this.timeCount++;
    }
}
