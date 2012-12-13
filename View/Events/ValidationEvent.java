/*
 * Minesweeper Project
 * by Group3 : Arnaud BABOL, Guillaume SIMMONEAU
 */
package View.Events;

import View.GraphicalViews.Options.ValidationPanel;
import genericGraphicalComponents.ObservationEvent;

/**
 *
 * @author simonneau
 */
public class ValidationEvent extends ObservationEvent {

    private boolean validate;
    
    /**
     *
     * @param source
     * @param validate
     */
    public ValidationEvent(ValidationPanel source, boolean validate) {
        super(source);
        this.validate = validate;
    }
    
    /**
     *
     * @return
     */
    public boolean getValidate(){
        return this.validate;
    }
    
}
