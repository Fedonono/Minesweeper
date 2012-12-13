/*
 * Minesweeper Project
 * by Group3 : Arnaud BABOL, Guillaume Simmoneau
 */
package View.Events;

import View.View;

/**
 *
 * @author simonneau
 */
public class ViewEvent {
    private View source;
    
    /**
     *
     * @param v
     */
    public ViewEvent(View v){
        this.source = v;
    }
    
    /**
     *
     * @return
     */
    public View getSource(){
        return this.source;
    }
}
