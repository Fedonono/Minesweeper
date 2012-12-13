/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Exceptions;

/**
 *
 * @author simonneau
 */
public class HeightException extends RuntimeException {
    
    /**
     *
     */
    public HeightException(){
        super("the height must be higher than zero.");
    }
    
    /**
     *
     * @param height
     */
    public HeightException(int height){
        super("The height : "+height+" is not allowed.");
    }
}
