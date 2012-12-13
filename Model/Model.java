/*
 * Minesweeper Project
 * by Group3 : Arnaud BABOL, Guillaume Simmoneau
 */
package Model;

import View.View;
import java.util.LinkedList;

/**
 *
 * @author simonneau
 */
public abstract class Model {
    
    /**
     *
     */
    protected LinkedList<View> views;
    
    /**
     *
     */
    public abstract void notifyViews();
    
    /**
     *
     * @return
     */
    @Override
    public abstract Model clone();
    
    /**
     *
     * @param view
     */
    public void addView(View view){
        this.views.add(view);
    }
    
}
