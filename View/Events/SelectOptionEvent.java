/*
 * Minesweeper Project
 * by Group3 : Arnaud BABOL, Guillaume SIMMONEAU
 */
package View.Events;

import View.GraphicalViews.Options.SelectOption;
import genericGraphicalComponents.ObservationEvent;

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
