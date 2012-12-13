/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler.Exceptions;

/**
 *
 * @author simonneau
 */
public class InvalidCommandException extends RuntimeException{

    /**
     *
     */
    public InvalidCommandException() {
        super("Invalid command.");
    }
}
