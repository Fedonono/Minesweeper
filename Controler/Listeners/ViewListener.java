/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
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
