/*
 * Minesweeper Project
 * by Group3 : Arnaud BABOL, Guillaume SIMMONEAU
 */
package View.Events;

import View.GraphicalViews.ValidateButton;

/**
 *
 * @author simonneau
 */
public class ValidateButtonEvent extends ObservationEvent{

    /**
     *
     * @param source
     */
    public ValidateButtonEvent(ValidateButton source) {
        super(source);
    }
    
    
}
