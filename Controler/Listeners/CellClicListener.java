/*
 * Minesweeper Project
 * by Group3 : Arnaud BABOL, Guillaume Simmoneau
 */
package Controler.Listeners;

import Controler.Minesweeper;
import Controler.Rules;
import Model.Game.AbstractState;
import Model.Game.Flag;
import View.Events.CellEvent;
import View.Events.ViewEvent;
import java.awt.event.MouseEvent;

/**
 *
 * @author simonneau
 */
public class CellClicListener extends ViewListener {

    private int i;
    private int j;

    /**
     *
     * @param i
     * @param j
     */
    public CellClicListener(int i, int j) {
        this.i = i;
        this.j = j;
    }

    /**
     *
     * @param ev
     */
    @Override
    public void catchViewEvent(ViewEvent ev) {
        MouseEvent click = (MouseEvent) (((CellEvent) ev).getAction());
        int button = click.getButton();

        if (button == 1) {
            Minesweeper.getInstance().getRules().demine(i, j);

        } else if (button == 3) {
            this.flag();
        }
    }

    private void flag() {
        Rules r = Minesweeper.getInstance().getRules();
        Flag currentFlag = r.getGameboard().getState(i, j).getFlag();

        if (currentFlag == AbstractState.HOLLOW_FLAG) {
            r.flag(i, j, AbstractState.MINE_FLAG);

        } else if (currentFlag == AbstractState.MINE_FLAG) {
            r.flag(i, j, AbstractState.TEMP_FLAG);

        } else if (currentFlag == AbstractState.TEMP_FLAG) {
            r.flag(i, j, AbstractState.HOLLOW_FLAG);
        }

    }
}
