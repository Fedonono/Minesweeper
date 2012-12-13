/*
 * Minesweeper Project
 * by Group3 : Arnaud BABOL, Guillaume Simmoneau
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
