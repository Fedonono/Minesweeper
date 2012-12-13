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
public class ResizeEvent extends RefreshEvent{

    private int width;
    private int height;
    
    
    /**
     *
     * @param source
     * @param width
     * @param height
     */
    public ResizeEvent(Model source, int width, int height) {
        super(source);
        this.width = width;
        this.height = height;
    }
    
    /**
     *
     * @return
     */
    public int getWidth(){
        return this.width;
    }
    
    /**
     *
     * @return
     */
    public int getHeight(){
        return this.height;
    }
}
