/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Exceptions;

/**
 *
 * @author simonneau
 */
public class ArrayException extends RuntimeException {
    /**
     *
     */
    public ArrayException(){
        this("Out of dimensions");
    }
    
    /**
     *
     * @param message
     */
    public ArrayException(String message){
        super(message);
    }
}
