/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Events;

import Model.Model;

/**
 *
 * @author simonneau
 */
public class TotalGameRefreshEvent extends RefreshEvent{
    
    /**
     *
     * @param source
     */
    public TotalGameRefreshEvent(Model source) {
        super(source);
    }
}
