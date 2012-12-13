/*
 * Minesweeper Project
 * by Group3 : Arnaud BABOL, Guillaume SIMMONEAU
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
