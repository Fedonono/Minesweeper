/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package View.Events;

import View.GraphicalViews.Options.SelectOption;

/**
 *
 * @author simonneau
 */
public class SelectOptionEvent extends ObservationEvent{
    /**
     *
     * @param source
     */
    public SelectOptionEvent(SelectOption source){
        super(source);
    }
}
