/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
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
