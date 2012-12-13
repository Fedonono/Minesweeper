/*
 * Minesweeper Project
 * by Group3 : Arnaud BABOL, Guillaume SIMMONEAU
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
