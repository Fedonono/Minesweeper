/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Events;

import Model.Model;

/**
 *
 * @author nono
 */
public class ChronometerEvent extends RefreshEvent {
    private String time;

    /**
     *
     * @param source
     * @param time
     */
    public ChronometerEvent(Model source, int time) {
        super(source);
        this.time = "Time : "+getMin(time)+":"+getSecs(time);
    }
    
    /**
     *
     * @return
     */
    public String getTime() {
        return this.time;
    }
    
    private int getMin(int time) {
        return time/60;
    }
    
    private int getSecs(int time) {
        return time%60;
    }
    
}
