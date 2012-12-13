/*
 * Minesweeper Project
 * by Group3 : Arnaud BABOL, Guillaume Simmoneau
 */
package Controler.Listeners;

import View.Events.ViewEvent;

/**
 *
 * @author simonneau
 */
public abstract class ViewListener {
    /**
     *
     * @param ev
     */
    public abstract void catchViewEvent(ViewEvent ev);
}
