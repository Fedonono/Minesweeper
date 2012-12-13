/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package View.Events;

import View.GraphicalViews.Options.NewGamePanel;

/**
 *
 * @author simonneau
 */
public class NewGamePanelEvent extends ObservationEvent{
    
    /**
     *
     * @param source
     */
    public NewGamePanelEvent(NewGamePanel source) {
        super(source);
    }
    
    
}
