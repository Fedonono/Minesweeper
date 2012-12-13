/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package View.Events;

import View.View;
import java.util.EventObject;

/**
 *
 * @author simonneau
 */
public class CellEvent extends ViewEvent {
    
    private EventObject action;
    
    /**
     *
     * @param v
     * @param aEv
     */
    public CellEvent(View v, EventObject aEv){
        super(v);
        this.action = aEv;
    }    
    
    /**
     *
     * @return
     */
    public EventObject getAction(){
        return this.action;
    }
}
