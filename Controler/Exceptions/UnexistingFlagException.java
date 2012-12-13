/*
 * Minesweeper Project
 * by Group3 : Arnaud BABOL, Guillaume SIMMONEAU
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
