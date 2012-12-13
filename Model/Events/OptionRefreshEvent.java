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
public class OptionRefreshEvent extends RefreshEvent{
    
    /**
     *
     * @param source
     */
    public OptionRefreshEvent(Model source){
        super(source);
    }
}
