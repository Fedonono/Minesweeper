/*
 * Minesweeper Project
 * by Group3 : Arnaud BABOL, Guillaume Simmoneau
 */
package Controler;

import Controler.Exceptions.UnexistingFlagException;
import Model.Game.AbstractState;
import Model.Game.Flag;
import Model.Game.Temperament;
import Model.Game.WorldModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;

/**
 * @author simonneau
 */
public class Rules implements ActionListener {

    /**
     *
     */
    protected boolean begining;
    private WorldModel gameboard;
    private Chronometer chronometer;
    private int emptyCellRevealedCount = 0;
    private int emptyCellsNumber;
    private static int MAX_LIFES = 1;
    private int currentLife = Rules.MAX_LIFES;
    /**
     *
     */
    public static final int stepCooldown = 1000;

    /**
     *
     * @param g
     */
    public Rules(WorldModel g) {
        this.gameboard = g.clone();
        this.emptyCellsNumber = this.gameboard.width() * this.gameboard.height() - this.gameboard.getBombNumber();
        this.begining = true;
        this.initChronometer();
    }

    /**
     *
     * @return
     */
    public boolean isStarted() {
        return !this.begining;
    }

    /**
     *
     * @return
     */
    public WorldModel getGameboard() {
        return this.gameboard;
    }

    /**
     *
     * @param i
     * @param j
     * @param f
     */
    public void flag(int i, int j, Flag f) {
        this.gameboard.setFlag(i, j, f);
        this.applyRules();
    }

    /**
     *
     * @param i
     * @param j
     * @param sFlag
     */
    public void flag(int i, int j, String sFlag) {
        Flag flag;
        switch (sFlag) {
            case "x":
                flag = AbstractState.MINE_FLAG;
                break;
            case "#":
                flag = AbstractState.HOLLOW_FLAG;
                break;
            case "?":
                flag = AbstractState.TEMP_FLAG;
                break;
            default:
                throw new UnexistingFlagException(sFlag);
        }
        this.flag(i, j, flag);
    }

    /**
     *
     * @param i
     * @param j
     */
    public void demine(int i, int j) {
        if (this.begining) {
            this.gameboard.minePlacer(i, j);
            this.begining = false;
        }
        AbstractState s = this.gameboard.getState(i, j);
        if (s.getValue() == AbstractState.MINE_VALUE) {
            this.currentLife--;
            this.revealCells(s);
        } else {
            this.revealCells(s);
        }
        this.applyRules();
    }

    /**
     *
     * @param state
     */
    public void revealCells(AbstractState state) {
        if (state.getValue() == AbstractState.EMPTY_CELL_VALUE) {
            this.emptyCellRevealedCount++;
        }
        this.gameboard.setFlag(state, AbstractState.VISIBLE_FLAG);

        AbstractState neighbor;
        Flag neighborFlag;
        Temperament neighborTemperament;
        Iterator<AbstractState> i = state.getNeighborhoodIterator();

        boolean revealNeighborhood = true;

        while (i.hasNext() && revealNeighborhood) {
            neighbor = i.next();
            neighborTemperament = neighbor.getValue();
            if (neighborTemperament == AbstractState.MINE_VALUE) {
                revealNeighborhood = false;
            }
        }

        if (revealNeighborhood) {
            i = state.getNeighborhoodIterator();
            while (i.hasNext()) {
                neighbor = i.next();
                neighborFlag = neighbor.getFlag();

                if (neighborFlag != AbstractState.VISIBLE_FLAG) {
                    this.revealCells(neighbor);
                }
            }
        }

    }

    /**
     *
     */
    public void revealAllCells() {
        Iterator<AbstractState> i = this.gameboard.iterator();
        AbstractState s;
        while (i.hasNext()) {
            s = i.next();
            this.gameboard.setFlag(s, AbstractState.VISIBLE_FLAG);
        }
    }

    /**
     *
     */
    public void applyRules() {
        if (this.emptyCellRevealedCount == this.emptyCellsNumber) {
            this.revealAllCells();
            this.chronometer.stop();
            this.gameboard.win();
        } else if (this.currentLife == 0) {
            this.revealAllCells();
            this.chronometer.stop();
            this.gameboard.lose();
        } else {
            this.gameboard.notifyViews();
        }
    }

    /**
     *
     */
    public void initChronometer() {
        this.chronometer = new Chronometer(this);
        this.chronometer.start();
    }

    /**
     *
     */
    public void stopChronometer() {
        this.chronometer.stop();
    }

    /**
     *
     */
    public void restartChronometer() {
        this.chronometer.restart();
        this.gameboard.setTime(0);
        this.gameboard.notifyViews();
    }

    /**
     *
     * @param wm
     */
    public void reset(WorldModel wm) {
        this.begining = true;
        this.currentLife = Rules.MAX_LIFES;
        this.emptyCellRevealedCount = 0;
        this.emptyCellsNumber = wm.width() * wm.height() - wm.getBombNumber();
        this.gameboard.reset(wm);
        this.restartChronometer();
    }

    /**
     *
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        this.chronometer.incrTime();
        this.gameboard.setTime(this.chronometer.getTime());
    }
}
