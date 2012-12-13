/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
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
