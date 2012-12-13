/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
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
