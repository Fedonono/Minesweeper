/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package View.GraphicalViews;

/**
 *
 * @author simonneau
 */
public interface Observable {
    
    /**
     *
     * @param o
     */
    public  void addObserver(Observer o);
    /**
     *
     */
    public void notifyObserver();
}
