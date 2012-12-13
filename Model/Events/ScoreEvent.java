/*
 * Minesweeper Project
 * by Group3 : Arnaud BABOL, Guillaume SIMMONEAU
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
