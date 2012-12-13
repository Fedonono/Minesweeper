/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Events;

import Model.Model;


/**
 * @author simonneau
 */
public class LocalGameRefreshEvent extends RefreshEvent{

    
    private int i;
    private int j;

    
    /**
     *
     * @param source
     * @param i
     * @param j
     */
    public LocalGameRefreshEvent(Model source, int i, int j) {
        super(source);
        this.i = i;
        this.j = j;
    }
    
    /**
     *
     * @return
     */
    public int getX(){
        return this.i;
    }
    
    /**
     *
     * @return
     */
    public int getY(){
        return this.j;
    }
}
