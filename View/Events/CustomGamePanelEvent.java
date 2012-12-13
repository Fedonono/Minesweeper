/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package View.Events;

import View.GraphicalViews.Options.CustomGamePanel;

/**
 *
 * @author simonneau
 */
public class CustomGamePanelEvent extends ObservationEvent{

    /**
     *
     * @param source
     */
    public CustomGamePanelEvent(CustomGamePanel source) {
        super(source);
    }
    
}
