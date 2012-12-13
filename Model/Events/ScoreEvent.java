/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Events;

import Model.Model;

/**
 *
 * @author nono
 */
public class ScoreEvent extends RefreshEvent {

    /**
     *
     * @param source
     */
    public ScoreEvent(Model source) {
        super(source);
    }
    
}
