/*
 * Minesweeper Project
 * by Group3 : Arnaud BABOL, Guillaume Simmoneau
 */
package Model.Exceptions;

/**
 *
 * @author simonneau
 */
public class ArrayWidthException extends ArrayException {

    /**
     *
     */
    public ArrayWidthException() {
        super();
    }

    /**
     *
     * @param widthIndex
     */
    public ArrayWidthException(int widthIndex) {
        super(widthIndex + " is out of width dimension.");
    }
}
