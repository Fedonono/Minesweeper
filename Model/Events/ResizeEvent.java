/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
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
