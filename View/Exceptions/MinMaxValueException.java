/*
 * Minesweeper Project
 * by Group3 : Arnaud BABOL, Guillaume Simmoneau
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
