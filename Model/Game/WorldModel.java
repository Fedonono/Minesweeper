/*
 * Minesweeper Project
 * by Group3 : Arnaud BABOL, Guillaume Simmoneau
 */
package Model.Game;

import Model.Model;
import Model.Options.GameDifficulty;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author simonneau
 */
public abstract class WorldModel extends Model {

    /**
     *
     */
    protected ArrayList<AbstractState> gameboard;

    /**
     *
     * @param i
     * @param j
     * @return
     */
    public abstract AbstractState getState(int i, int j);
    
    /**
     *
     * @param i
     * @param j
     * @param t
     */
    public abstract void setValue(int i, int j, Temperament t);
    
    /**
     *
     * @param i
     * @param j
     * @param f
     */
    public abstract void setFlag(int i, int j, Flag f);
    
    /**
     *
     * @param s
     * @param f
     */
    public abstract void setFlag(AbstractState s, Flag f); 
    
    /**
     *
     * @return
     */
    public abstract int getBombNumber();

    /**
     *
     * @return
     */
    public abstract int width();

    /**
     *
     * @return
     */
    public abstract int height();
    
    /**
     *
     * @return
     */
    public abstract int size();

    /**
     *
     * @return
     */
    public abstract Iterator<AbstractState> iterator();
    
    /**
     *
     * @return
     */
    public abstract String getMessage();

    /**
     *
     * @return
     */
    public abstract int getTime();
    
    /**
     *
     * @param t
     */
    public abstract void setTime(int t);
    
    /**
     *
     * @param i
     * @param j
     */
    public abstract void minePlacer(int i, int j);
    
    /**
     *
     * @param wm
     */
    public abstract void reset(WorldModel wm);

    /**
     *
     * @return
     */
    @Override
    public abstract WorldModel clone();
    
    /**
     *
     */
    public abstract void win();
    
    /**
     *
     */
    public abstract void  lose();
    
    /**
     *
     * @return
     */
    public abstract int getWin();
    
    /**
     *
     * @return
     */
    public abstract GameDifficulty getGameDifficulty();
}
