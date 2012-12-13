/*
 * Minesweeper Project
 * by Group3 : Arnaud BABOL, Guillaume Simmoneau
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
