/*
 * Minesweeper Project
 * by Group3 : Arnaud BABOL, Guillaume SIMMONEAU
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
