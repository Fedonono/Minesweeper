/*
 * Minesweeper Project
 * by Group3 : Arnaud BABOL, Guillaume Simmoneau
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
