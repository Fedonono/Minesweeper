/*
 * Minesweeper Project
 * by Group3 : Arnaud BABOL, Guillaume SIMMONEAU
 */
package Model.Exceptions;

/**
 *
 * @author simonneau
 */
public class ArrayHeightException extends ArrayException {
    /**
     *
     */
    public ArrayHeightException() {
        super();
    }
    /**
     *
     * @param heightIndex
     */
    public ArrayHeightException(int heightIndex) {
        super(heightIndex + " is out of height dimension.");
    }
}
