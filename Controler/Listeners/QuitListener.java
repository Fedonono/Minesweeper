/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler.Listeners;

import Controler.Minesweeper;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author nono
 */
public class QuitListener implements ActionListener {

    /**
     *
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        Minesweeper.getInstance().exit();
    }
    
}
