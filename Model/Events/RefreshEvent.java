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
public class RefreshEvent {
    
    /**
     *
     */
    protected Object source;

    /**
     *
     * @param source
     */
    public RefreshEvent(Model source) {
        this.source = source;
    }
    
    /**
     *
     * @return
     */
    public Object getSource(){
        return this.source;
    }
    
}
