/*
 * Minesweeper Project
 * by Group3 : Arnaud BABOL, Guillaume Simmoneau
 */
package View.Events;

import View.GraphicalViews.Options.SelectOption;

/**
 *
 * @author simonneau
 */
public class SelectOptionEvent extends ObservationEvent{
    /**
     *
     * @param source
     */
    public SelectOptionEvent(SelectOption source){
        super(source);
    }
}
