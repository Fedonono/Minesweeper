/*
 * Minesweeper Project
 * by Group3 : Arnaud BABOL, Guillaume SIMMONEAU
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
