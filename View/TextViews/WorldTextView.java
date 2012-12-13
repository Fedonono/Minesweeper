/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package View.TextViews;

import Controler.Exceptions.InvalidCommandException;
import Controler.Listeners.ViewListener;
import Model.Events.EndGameEvent;
import Model.Events.LocalGameRefreshEvent;
import Model.Events.RefreshEvent;
import Model.Events.ResizeEvent;
import Model.Events.TotalGameRefreshEvent;
import Model.Game.WorldModel;
import View.Events.ConsoleEvent;
import View.View;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

/**
 *
 * @author simonneau
 */
public class WorldTextView extends View {

    private ArrayList<TextCellView> cells;

    /**
     *
     * @param size
     */
    public WorldTextView(int size) {
        this.listeners = new LinkedList<>();
        this.cells = new ArrayList<>(size);
        this.init(size);
    }

    private void init(int size) {
        for (int i = 0; i < size; i++) {
            this.cells.add(new TextCellView());
        }
    }

    /**
     *
     * @param event
     */
    @Override
    public void refresh(RefreshEvent event) {

        boolean haveToRefresh = false;
        Class evClass = event.getClass();

        if (evClass == ResizeEvent.class) {
            ResizeEvent ev = (ResizeEvent) event;
            this.resize(ev.getHeight() * ev.getWidth());
            haveToRefresh = false;

        } else if (evClass == TotalGameRefreshEvent.class) {
            haveToRefresh = true;
            
        } else if (evClass == EndGameEvent.class) {
            haveToRefresh = true;
        }

        if (haveToRefresh) {

            WorldModel wm = (WorldModel) event.getSource();
            int width = wm.width();
            int height = wm.height();
            RefreshEvent ev;
            Iterator<TextCellView> iterator = this.cells.iterator();
            TextCellView cell;

            for (int j = 0; j < height; j++) {
                for (int i = 0; i < width; i++) {
                    ev = new LocalGameRefreshEvent(wm, i, j);
                    cell = iterator.next();
                    cell.refresh(ev);
                }
                System.out.println();
            }

            String message = wm.getMessage();
            if (message.length() > 0) {
                System.out.println(message);
            }

            int time = wm.getTime();
            System.out.println("Time : " + time / 60 + ":" + time % 60);

            System.out.println();
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

    private void resize(int size) {
        this.cells.clear();
        this.cells.ensureCapacity(size);
        this.init(size);
    }
}