/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package View.GraphicalViews.Options;

import Model.Events.OptionRefreshEvent;
import Model.Events.RefreshEvent;
import Model.Options.GameDifficulty;
import Model.Options.OptionModel;
import View.Events.CustomGamePanelEvent;
import View.Events.NewGamePanelEvent;
import View.Events.ObservationEvent;
import View.Events.SelectOptionEvent;
import View.GraphicalViews.Observable;
import View.GraphicalViews.Observer;
import java.awt.GridLayout;
import java.util.LinkedList;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author nono
 */
public class NewGamePanel extends JPanel implements Observer, Observable {

    private LinkedList<Observer> observers = new LinkedList<>();
    private GameDifficulty gD;
    SelectOption optionsTab[] = new SelectOption[GameDifficulty.NB_DIFFICULTY];

    public NewGamePanel() {
        setLayout(new GridLayout(GameDifficulty.NB_DIFFICULTY + 1, 1));

        this.add(new JLabel("Select level :"));

        ButtonGroup bGroup = new ButtonGroup();

        int i = 0;

        for (GameDifficulty nG : GameDifficulty.values()) {
            if (i == 0) {
                optionsTab[i] = new SelectOption(nG, true);
            } else {
                optionsTab[i] = new SelectOption(nG, false);
            }
            bGroup.add(optionsTab[i]);
            this.add(optionsTab[i]);
            optionsTab[i].addObserver(this);
            i++;
        }
    }

    public void refresh(RefreshEvent event) {
        OptionRefreshEvent ev = (OptionRefreshEvent) event;
        OptionModel om = (OptionModel) ev.getSource();
        this.gD = om.getDifficulty();
        int i = 0;
        for (GameDifficulty gD : GameDifficulty.values()) {
            if (this.gD == gD) {
                optionsTab[i].doClick();
            }
            i++;
        }
    }

    @Override
    public void reactToChanges(ObservationEvent ev) {

        if (ev instanceof SelectOptionEvent) {
            SelectOptionEvent event = (SelectOptionEvent) ev;
            SelectOption so = (SelectOption) (event.getSource());
            this.gD = so.getDifficulty();

            this.notifyObserver();

        } else if (ev instanceof CustomGamePanelEvent) {
            optionsTab[GameDifficulty.NB_DIFFICULTY - 1].doClick(); // convention : Custom en last
        }
    }

    @Override
    public void addObserver(Observer o) {
        this.observers.add(o);
    }

    @Override
    public void notifyObserver() {
        for (Observer o : observers) {
            o.reactToChanges(new NewGamePanelEvent(this));
        }
    }

    public GameDifficulty getDifficulty() {
        return this.gD;
    }
}
