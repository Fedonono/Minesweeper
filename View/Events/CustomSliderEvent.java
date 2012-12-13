/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package View.Events;

import View.GraphicalViews.Options.CustomSlider;

/**
 *
 * @author simonneau
 */
public class CustomSliderEvent extends ObservationEvent {
    
    private int value;
    
    /**
     *
     * @param source
     * @param value
     */
    public CustomSliderEvent(CustomSlider source, int value){
        super(source);
        this.value = value;
    }
    
    /**
     *
     * @return
     */
    public int getValue(){
        return this.value;
    }
    
}
