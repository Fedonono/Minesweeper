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
public class TotalGameRefreshEvent extends RefreshEvent{
    
    /**
     *
     * @param source
     */
    public TotalGameRefreshEvent(Model source) {
        super(source);
    }
}
