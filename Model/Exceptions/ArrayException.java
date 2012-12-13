/*
 * Minesweeper Project
 * by Group3 : Arnaud BABOL, Guillaume Simmoneau
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
