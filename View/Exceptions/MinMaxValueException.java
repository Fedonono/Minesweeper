/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package View.Exceptions;

/**
 *
 * @author simonneau
 */
public class MinMaxValueException extends RuntimeException{

    /**
     *
     * @param max
     * @param min
     */
    public MinMaxValueException(int max, int min) {
        super("Max value : "+max+" must be lower than min value : "+min);
    }
    
}
