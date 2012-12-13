/*
 * Minesweeper Project
 * by Group3 : Arnaud BABOL, Guillaume Simmoneau
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
