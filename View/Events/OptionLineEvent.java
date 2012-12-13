/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package View.Events;

import View.GraphicalViews.Options.CustomOptionLine;

/**
 *
 * @author simonneau
 */
public class OptionLineEvent extends ObservationEvent{
    
    int value;
    
    /**
     *
     * @param source
     * @param value
     */
    public OptionLineEvent(CustomOptionLine source, int value){
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
