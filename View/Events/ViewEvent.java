/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
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
