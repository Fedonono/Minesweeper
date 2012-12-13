/*
 * Minesweeper Project
 * by Group3 : Arnaud BABOL, Guillaume Simmoneau
 */
package View.Events;

import View.GraphicalViews.Options.CustomGamePanel;

/**
 *
 * @author simonneau
 */
public class CustomGamePanelEvent extends ObservationEvent{

    /**
     *
     * @param source
     */
    public CustomGamePanelEvent(CustomGamePanel source) {
        super(source);
    }
    
}
