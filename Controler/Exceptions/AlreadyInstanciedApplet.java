/*
 * Minesweeper Project
 * by Group3 : Arnaud BABOL, Guillaume Simmoneau
 */
package Controler.Exceptions;

/**
 *
 * @author simonneau
 */
public class AlreadyInstanciedApplet extends RuntimeException{

    public AlreadyInstanciedApplet() {
        super("Applet already instancied");
    }
}
