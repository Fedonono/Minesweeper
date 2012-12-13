/*
 * Minesweeper Project
 * by Group3 : Arnaud BABOL, Guillaume SIMMONEAU
 */
package View.TextViews;

import Controler.Exceptions.InvalidCommandException;
import Controler.Listeners.ViewListener;
import Model.Events.OptionRefreshEvent;
import Model.Events.RefreshEvent;
import Model.Options.OptionModel;
import View.Events.ConsoleEvent;
import View.View;
import java.util.LinkedList;

/**
 *
 * @author simonneau
 */
public class OptionTextView extends View {

    /**
     *
     */
    public OptionTextView() {
        this.listeners = new LinkedList<>();
    }

    /**
     *
     * @param event
     */
    @Override
    public void refresh(RefreshEvent event) {
        OptionRefreshEvent ev = (OptionRefreshEvent) event;
        OptionModel m = (OptionModel) ev.getSource();

        if (m.isUnderWay()) {
            System.out.println();
            System.out.println("Width : " + m.getWidth());
            System.out.println("Height : " + m.getHeight());
            System.out.println("Bomb percentage : " + m.getBombPercentage() + "%");
            System.out.println("Thorique property : " + m.isThorique());
            System.out.println("");
            this.listenToUser();
        }
    }

    private void listenToUser() {
        this.notifyListeners(new ConsoleEvent(this));

    }

    private void notifyListeners(ConsoleEvent ev) {
        try {
            for (ViewListener l : this.listeners) {
                l.catchViewEvent(ev);
            }
        } catch (InvalidCommandException e) {
            System.err.println(e.getMessage());
            this.listenToUser();
        }
    }
}
