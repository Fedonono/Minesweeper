/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Exceptions;

/**
 *
 * @author simonneau
 */
public class WidthException extends RuntimeException {
    
    /**
     *
     */
    public WidthException(){
        super("the Width must be higher than zero.");
    }
    
    /**
     *
     * @param width
     */
    public WidthException(int width){
        super("The width : "+width+" is not allowed.");
    }
}
