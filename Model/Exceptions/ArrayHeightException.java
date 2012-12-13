/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
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
