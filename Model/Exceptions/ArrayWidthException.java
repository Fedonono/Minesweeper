/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
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
