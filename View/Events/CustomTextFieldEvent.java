/*
 * Minesweeper Project
 * by Group3 : Arnaud BABOL, Guillaume Simmoneau
 */
package View.Events;

import View.GraphicalViews.Options.CustomTextField;

/**
 *
 * @author simonneau
 */
public class CustomTextFieldEvent extends ObservationEvent{

    private String value;
    
    /**
     *
     * @param source
     * @param value
     */
    public CustomTextFieldEvent(CustomTextField source, String value) {
        super(source);
        this.value = value;
    }
    
    /**
     *
     * @return
     */
    public String getValue(){
        return this.value;
    }
    
}
