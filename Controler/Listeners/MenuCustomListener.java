/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler.Listeners;

import Controler.Minesweeper;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 * @author nono
 */
public class MenuCustomListener implements ActionListener, MouseListener {

    
    /**
     *
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        this.displayOptions();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        this.displayOptions();
    }

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}
	
	private void displayOptions() {
        Minesweeper.getInstance().jumToOptions();
	}
    
}
