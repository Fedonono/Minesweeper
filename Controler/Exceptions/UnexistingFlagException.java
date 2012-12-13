/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler.Exceptions;

/**
 *
 * @author simonneau
 */
public class UnexistingFlagException extends RuntimeException{
    
    /**
     *
     * @param flag
     */
    public UnexistingFlagException(String flag){
        super("The Flag "+flag+" does not exist");
    }
    
    
    
}
