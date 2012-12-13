/*
 * Minesweeper Project
 * by Group3 : Arnaud BABOL, Guillaume SIMMONEAU
 */
package View.GraphicalViews;

import Controler.Listeners.MenuCustomListener;
import Controler.Listeners.MenuDifficultyListener;
import Controler.Listeners.MenuScoreListener;
import Controler.Listeners.QuitListener;
import Controler.Minesweeper;
import Model.Options.GameDifficulty;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseListener;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

/**
 *
 * @author nono
 */
public class MenuBar extends JMenuBar {

    /**
     *
     */
    public MenuBar() {
        this.createMenuBar();
    }

    private void createMenuBar() {
        JMenu menuGame = new JMenu("Game");
        menuGame.setMnemonic(KeyEvent.VK_G);
        JMenu menuNew = new JMenu("New");
        menuNew.setMnemonic(KeyEvent.VK_N);
        // Exigence peu clair sur ce Listener, à modif plus tard maybe
        menuNew.addMouseListener((MouseListener) new MenuCustomListener());
        JMenu menuScore = new JMenu("Scores");
        menuScore.setMnemonic(KeyEvent.VK_S);

        JMenuItem quit = new JMenuItem("Quit");
        quit.addActionListener(new QuitListener());
        KeyStroke ctrlQuit = KeyStroke.getKeyStroke(KeyEvent.VK_Q, ActionEvent.CTRL_MASK);
        quit.setMnemonic(KeyEvent.VK_Q);
        quit.setAccelerator(ctrlQuit);

        for (GameDifficulty nG : GameDifficulty.values()) {
            JMenuItem newItemOption = new JMenuItem(nG.getName());
            if (nG == GameDifficulty.CUSTOM) {
                newItemOption.addActionListener(new MenuCustomListener());
            } else {
                newItemOption.addActionListener(new MenuDifficultyListener(nG));

                JMenuItem newItemScore = new JMenuItem(nG.getName());
                newItemScore.addActionListener(new MenuScoreListener(nG.getName()));
                newItemScore.setAccelerator(KeyStroke.getKeyStroke(nG.getKey(), ActionEvent.SHIFT_MASK));
                newItemScore.setMnemonic(nG.getKey());
                menuScore.add(newItemScore);
            }
            newItemOption.setAccelerator(KeyStroke.getKeyStroke(nG.getKey(), ActionEvent.CTRL_MASK));
            newItemOption.setMnemonic(nG.getKey());
            menuNew.add(newItemOption);
        }


        menuGame.add(menuNew);
        menuGame.add(quit);

        this.add(menuGame);
        if (Minesweeper.getInstance().standAlone()) {
            this.add(menuScore);
        }
    }
}
