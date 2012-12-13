/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package View.GraphicalViews;

import View.Events.ObservationEvent;

/**
 *
 * @author simonneau
 */
public interface Observer {
    
    /**
     *
     * @param ev
     */
    public void reactToChanges(ObservationEvent ev);
}
