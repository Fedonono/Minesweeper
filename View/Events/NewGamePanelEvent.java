/*
 * Minesweeper Project
 * by Group3 : Arnaud BABOL, Guillaume SIMMONEAU
 */
package View.Events;

import genericGraphicalComponents.ObservationEvent;
import View.GraphicalViews.Options.NewGamePanel;

/**
 *
 * @author simonneau
 */
public class NewGamePanelEvent extends ObservationEvent{
    
    /**
     *
     * @param source
     */
    public NewGamePanelEvent(NewGamePanel source) {
        super(source);
    }
    
    
}
