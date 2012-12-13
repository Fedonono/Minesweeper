/*
 * Minesweeper Project
 * by Group3 : Arnaud BABOL, Guillaume Simmoneau
 */
package View.Events;

import View.GraphicalViews.Observable;

/**
 *
 * @author simonneau
 */
public class ObservationEvent {
    private Observable source;

    /**
     *
     * @param source
     */
    public ObservationEvent(Observable source) {
        this.source = source;
    }    
    
    /**
     *
     * @return
     */
    public Observable getSource(){
        return this.source;
    }
    
    
}
