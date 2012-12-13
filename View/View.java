/*
 * Minesweeper Project
 * by Group3 : Arnaud BABOL, Guillaume SIMMONEAU
 */
package View;

import Controler.Listeners.ViewListener;
import Model.Events.RefreshEvent;
import java.util.LinkedList;

/**
 *
 * @author simonneau
 */
public abstract class View {
    /**
     *
     */
    protected LinkedList<ViewListener> listeners;
    
    
    
    /**
     *
     * @param event
     */
    public abstract void refresh(RefreshEvent event);    
    
    /**
     *
     * @param listener
     */
    public void addListener(ViewListener listener){
        this.listeners.add(listener);
    }
}  