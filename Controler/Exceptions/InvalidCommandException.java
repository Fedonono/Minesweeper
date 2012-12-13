/*
 * Minesweeper Project
 * by Group3 : Arnaud BABOL, Guillaume Simmoneau
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
