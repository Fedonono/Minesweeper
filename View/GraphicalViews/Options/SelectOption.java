/*
 * Minesweeper Project
 * by Group3 : Arnaud BABOL, Guillaume SIMMONEAU
 */
package View.GraphicalViews.Options;

import Model.Options.GameDifficulty;
import View.Events.SelectOptionEvent;
import genericGraphicalComponents.Observable;
import genericGraphicalComponents.Observer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import javax.swing.JRadioButton;

/**
 *
 * @author nono
 */
public class SelectOption extends JRadioButton implements Observable,ActionListener {

    private LinkedList<Observer> observers = new LinkedList<>();
    private GameDifficulty gD;

    public SelectOption(GameDifficulty gD, boolean selected) {
        super(gD.getName()+" : "+gD.getDescription(), selected);
        this.gD = gD;
        this.addActionListener(this);
    }
    
    public GameDifficulty getDifficulty() {
       return this.gD;
    }

    @Override
    public void addObserver(Observer o) {
        this.observers.add(o);
    }

    @Override
    public void notifyObserver() {
        for (Observer o : this.observers) {
            o.reactToChanges(new SelectOptionEvent(this));
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        this.notifyObserver();
    }
}
