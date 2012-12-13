/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Game;

import java.util.Iterator;

/**
 *
 * @author simonneau
 */
public abstract class AbstractState {
    
    /**
     *
     */
    public static final Temperament MINE_VALUE = Temperament.explosive;
    /**
     *
     */
    public static final Temperament EMPTY_CELL_VALUE = Temperament.pacific;
    /**
     *
     */
    public static final Flag HOLLOW_FLAG = Flag.hollow;
    /**
     *
     */
    public static final Flag MINE_FLAG = Flag.mine;
    /**
     *
     */
    public static final Flag TEMP_FLAG = Flag.temp;
    /**
     *
     */
    public static final Flag VISIBLE_FLAG = Flag.none;

    /**
     *
     * @param value
     */
    public abstract void setValue(Temperament value);

    /**
     *
     * @param flag
     */
    public abstract void setFlag(Flag flag);

    /**
     *
     * @return
     */
    public abstract Temperament getValue();

    /**
     *
     * @return
     */
    public abstract Flag getFlag();

    // To implement soon /

    /**
     *
     * @param neighbor
     */
    public abstract void addNeighbor(AbstractState neighbor);

    /**
     *
     * @param i
     */
    public abstract void removeNeighbor(int i);
    
    /**
     *
     * @param i
     * @return
     */
    public abstract AbstractState getNeighbor(int i);

    /**
     *
     * @return
     */
    public abstract Iterator<AbstractState> getNeighborhoodIterator();

    /**
     *
     * @return
     */
    public abstract int getNeighborhoodSize();

    /**
     *
     * @return
     */
    public abstract int getNeighborMineCount();
    
    /**
     *
     */
    protected abstract void incrNeighborMineCount();
    
    /**
     *
     */
    protected abstract void decrNeighborMineCount();
    
    /**
     *
     * @return
     */
    public abstract int getX();
    /**
     *
     * @return
     */
    public abstract int getY();
    /**
     *
     * @param x
     */
    public abstract void setX(int x);
    /**
     *
     * @param y
     */
    public abstract void setY(int y);
    
    /**
     *
     * @return
     */
    @Override
    public abstract AbstractState clone();
}
