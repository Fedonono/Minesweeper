/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler.Listeners;

import Controler.Minesweeper;
import Model.Options.GameDifficulty;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author nono
 */
public class MenuDifficultyListener implements ActionListener {
    private GameDifficulty gD;

    /**
     *
     * @param gD
     */
    public MenuDifficultyListener(GameDifficulty gD) {
        this.gD = gD;
    }

    /**
     *
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        Minesweeper.getInstance().getOptionPanel().setDifficulty(getGameDifficulty());
        Minesweeper.getInstance().restart();
    }
    
    /**
     *
     * @return
     */
    public GameDifficulty getGameDifficulty() {
        return this.gD;
    }
    
}