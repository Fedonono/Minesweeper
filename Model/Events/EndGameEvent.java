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
public class EndGameEvent extends RefreshEvent {
    
    private boolean win;
    /**
     *
     * @param source
     * @param win
     */
    public EndGameEvent(Model source, boolean win) {
        super(source);
        this.win = win;
    }
    
    /**
     *
     * @return
     */
    public boolean win(){
        return this.win;
    }
}
