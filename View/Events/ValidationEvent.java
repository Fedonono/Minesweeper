/*
 * Minesweeper Project
 * by Group3 : Arnaud BABOL, Guillaume Simmoneau
 */
package View.Events;

import View.GraphicalViews.Options.ValidationPanel;

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
