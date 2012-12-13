/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Game;

import Model.Events.ChronometerEvent;
import Model.Events.EndGameEvent;
import Model.Events.LocalGameRefreshEvent;
import Model.Events.RefreshEvent;
import Model.Events.ResizeEvent;
import Model.Events.TotalGameRefreshEvent;
import Model.Exceptions.ArrayHeightException;
import Model.Exceptions.ArrayWidthException;
import Model.Exceptions.BombPercentageException;
import Model.Exceptions.HeightException;
import Model.Exceptions.WidthException;
import Model.Options.GameDifficulty;
import View.View;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

/**
 *
 * @author simonneau
 */
public class WorldModelImpl extends WorldModel {

    private double bombPercentage;
    private int bombNumber;
    private int mineFlagCount = 0;
    private int width;
    private int height;
    private String message;
    private int time;
    private boolean thorique = true;
    private GameDifficulty gd;
    private int win = 0;

    /**
     *
     * @param width
     * @param height
     * @param bombPercentage
     * @param isThorique
     * @param gd
     * @throws WidthException
     * @throws HeightException
     * @throws BombPercentageException
     */
    public WorldModelImpl(int width, int height, double bombPercentage, boolean isThorique, GameDifficulty gd) throws WidthException, HeightException, BombPercentageException {
        if (bombPercentage < 100) {
            this.bombPercentage = bombPercentage;
        } else {
            throw new BombPercentageException();
        }
        if (width < 1) {
            throw new WidthException(width);
        } else {
            this.width = width;
        }
        if (height < 1) {
            throw new HeightException(height);
        } else {
            this.height = height;
        }
        this.views = new LinkedList<>();
        this.gameboard = new ArrayList(width * height);
        this.bombNumber = (int) Math.floor(height * width * bombPercentage / 100);
        if (this.bombNumber == 0) {
            this.bombNumber++;
        }
        this.thorique = isThorique;
        this.message = "Remaining mines : " + this.bombNumber;
        this.gd = gd;
        this.initGameboard();
    }

    /**
     *
     * @return
     */
    @Override
    public int width() {
        return this.width;
    }

    /**
     *
     * @return
     */
    @Override
    public int height() {
        return this.height;
    }

    /**
     *
     * @return
     */
    @Override
    public int size() {
        return this.width * this.height;
    }

    private void notifyViews(RefreshEvent e) {
        for (View v : this.views) {
            v.refresh(e);
        }
    }

    /**
     *
     */
    @Override
    public void notifyViews() {
        this.notifyViews(new TotalGameRefreshEvent(this));
    }

    /**
     *
     * @param i
     * @param j
     * @return
     * @throws ArrayWidthException
     * @throws ArrayHeightException
     */
    @Override
    public AbstractState getState(int i, int j) throws ArrayWidthException, ArrayHeightException {
        if (i < 0 || i > this.width - 1) {
            throw new ArrayWidthException(i);
        }
        if (j < 0 || j > this.height - 1) {
            throw new ArrayHeightException(j);
        }
        return this.gameboard.get(j * width + i);
    }

    /**
     *
     * @param i
     * @param j
     * @param t
     */
    @Override
    public void setValue(int i, int j, Temperament t) {
        AbstractState s = this.getState(i, j);
        s.setValue(t);
    }

    /**
     *
     * @param i
     * @param j
     * @param f
     */
    @Override
    public void setFlag(int i, int j, Flag f) {

        AbstractState s = this.getState(i, j);
        this.setFlag(s, f);
    }

    /**
     *
     * @param s
     * @param f
     */
    @Override
    public void setFlag(AbstractState s, Flag f) {

        Flag sFlag = s.getFlag();
        if (f == AbstractState.MINE_FLAG && this.bombNumber - this.mineFlagCount == 0) {
            f = Flag.temp;
        }

        if (sFlag != AbstractState.VISIBLE_FLAG) {

            if (sFlag != AbstractState.MINE_FLAG && f == AbstractState.MINE_FLAG) {
                this.mineFlagCount++;
            } else if (sFlag == AbstractState.MINE_FLAG && f != AbstractState.MINE_FLAG) {
                this.mineFlagCount--;
            }
            int remainingMines = this.bombNumber - this.mineFlagCount;
            this.setMessage("Remaining mines : " + remainingMines);

            s.setFlag(f);
            this.notifyViews(new LocalGameRefreshEvent(this, s.getX(), s.getY()));
        }
    }

    /**
     *
     * @return
     */
    @Override
    public int getBombNumber() {
        return this.bombNumber;
    }

    /**
     *
     * @return
     */
    @Override
    public WorldModelImpl clone() {

        WorldModelImpl model = new WorldModelImpl(this.width(), this.height(), this.bombPercentage, this.thorique, this.gd);
        model.gameboard = (ArrayList) this.gameboard.clone();
        model.views = (LinkedList) this.views.clone();
        return model;
    }

    /**
     *
     * @param wIndex
     * @param hIndex
     */
    @Override
    public void minePlacer(int wIndex, int hIndex) {
        int i;
        int j;
        for (int iter = 0; iter < this.bombNumber; iter++) {
            i = (int) (Math.random() * (width));
            j = (int) (Math.random() * (height));
            if (i != wIndex || j != hIndex) {
                State s = (State) this.getState(i, j);
                if (!State.isAMine(s)) {
                    s.setValue(Temperament.explosive);
                } else {
                    iter--;
                }
            } else {
                iter--;
            }
        }
    }

    private void initGameboard() {
        for (int j = 0; j < this.height; j++) {
            for (int i = 0; i < this.width; i++) {
                this.gameboard.add(new State(AbstractState.EMPTY_CELL_VALUE, AbstractState.HOLLOW_FLAG, i, j));
            }
        }
        this.initNeigborhoodCells();
    }

    private int thor(int target, int ref) {
        if (target == - 1) {
            return ref - 1;
        } else if (target == ref) {
            return 0;
        } else {
            return target;
        }
    }

    private void initNeigborhoodCells() {
        if (this.thorique) {
            this.initThoriqueNeigborhoodCells();
        } else {
            this.initUnthoriqueNeigborhoodCells();
        }
    }

    private void initUnthoriqueNeigborhoodCells() {
        AbstractState s;
        Iterator<AbstractState> iterator = this.iterator();
        int x = 0;
        int y = 0;
        int i, j;
        while (iterator.hasNext()) {
            s = iterator.next();

            j = y - 1;
            if (j >= 0) {
                s.addNeighbor(this.getState(x, j));

                i = x - 1;
                if (i >= 0) {
                    s.addNeighbor(this.getState(i, j));
                }

                i = x + 1;
                if (i < this.width) {
                    s.addNeighbor(this.getState(i, j));
                }
            }

            j = y + 1;
            if (j < this.height) {
                s.addNeighbor(this.getState(x, j));

                i = x - 1;
                if (i >= 0) {
                    s.addNeighbor(this.getState(i, j));
                }

                i = x + 1;
                if (i < this.width) {
                    s.addNeighbor(this.getState(i, j));
                }
            }

            i = x - 1;
            if (i >= 0) {
                s.addNeighbor(this.getState(i, y));
            }

            i = x + 1;
            if (i < this.width) {
                s.addNeighbor(this.getState(i, y));
            }

            if (x == this.width - 1) {
                y++;
            }
            x = (x + 1) % (this.width);
        }

    }

    private void initThoriqueNeigborhoodCells() {
        AbstractState s;
        Iterator<AbstractState> iterator = this.iterator();
        int x = 0;
        int y = 0;
        int i, j;
        while (iterator.hasNext()) {
            s = iterator.next();

            i = this.thor(x - 1, this.width);
            s.addNeighbor(this.getState(i, y));

            i = this.thor(x + 1, this.width);
            s.addNeighbor(this.getState(i, y));

            j = this.thor(y - 1, this.height);
            s.addNeighbor(this.getState(x, j));

            j = this.thor(y + 1, this.height);
            s.addNeighbor(this.getState(x, j));

            i = this.thor(x + 1, this.width);
            j = this.thor(y + 1, this.height);
            s.addNeighbor(this.getState(i, j));

            i = this.thor(x + 1, this.width);
            j = this.thor(y - 1, this.height);
            s.addNeighbor(this.getState(i, j));

            i = this.thor(x - 1, this.width);
            j = this.thor(y + 1, this.height);
            s.addNeighbor(this.getState(i, j));

            i = this.thor(x - 1, this.width);
            j = this.thor(y - 1, this.height);
            s.addNeighbor(this.getState(i, j));

            if (x == this.width - 1) {
                y++;
            }
            x = (x + 1) % (this.width);
        }
    }

    /**
     *
     * @return
     */
    @Override
    public Iterator<AbstractState> iterator() {
        return this.gameboard.iterator();
    }

    /**
     *
     * @return
     */
    @Override
    public String getMessage() {
        return this.message;
    }

    /**
     *
     * @return
     */
    @Override
    public int getTime() {
        return this.time;
    }

    /**
     *
     * @param message
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     *
     * @param t
     */
    @Override
    public void setTime(int t) {
        this.time = t;
        this.notifyViews((RefreshEvent) new ChronometerEvent(this, this.getTime()));
    }

    /**
     *
     * @return
     */
    @Override
    public int getWin() {
        return this.win;
    }

    /**
     *
     * @param wm
     */
    @Override
    public void reset(WorldModel wm) {
        WorldModelImpl m = (WorldModelImpl) wm;
        this.bombNumber = m.bombNumber;
        this.bombPercentage = m.bombPercentage;
        this.height = m.height;
        this.width = m.width;
        this.message = m.message;
        this.mineFlagCount = m.mineFlagCount;
        this.thorique = m.thorique;
        this.gd = m.gd;
        this.win = 0;
        this.gameboard = new ArrayList<>(this.width * this.height);
        this.initGameboard();
        this.notifyViews(new ResizeEvent(this, this.width, this.height));
    }

    /**
     *
     */
    @Override
    public void win() {
        this.setMessage("Congratulations, you win!");
        this.win = 1;
        this.notifyViews(new EndGameEvent(this, true));
    }

    /**
     *
     */
    @Override
    public void lose() {
        this.setMessage("Congratulations, you died in the explosion!");
        this.win = -1;
        this.notifyViews(new EndGameEvent(this, false));
    }

    /**
     *
     * @return
     */
    @Override
    public GameDifficulty getGameDifficulty() {
        return this.gd;
    }
}
