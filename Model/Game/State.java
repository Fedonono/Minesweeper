/*
 * Minesweeper Project
 * by Group3 : Arnaud BABOL, Guillaume SIMMONEAU
 */
package Model.Game;

import java.util.Iterator;
import java.util.LinkedList;

/**
 *
 * @author simonneau
 */
public class State extends AbstractState {

    private Temperament value;
    private Flag flag;
    private LinkedList<AbstractState> neighborhood = new LinkedList();
    private int neighborhoodSize = 0;
    private int explosiveNeighborCount = 0;
    private int x;
    private int y;

    /**
     *
     * @param s
     * @return
     */
    public static boolean isAMine(State s) {
        return (s.value == State.MINE_VALUE);
    }

    /**
     *
     * @param x
     * @param y
     */
    protected State(int x, int y) {
        this(State.EMPTY_CELL_VALUE, x, y);
    }

    /**
     *
     * @param temperament
     * @param x
     * @param y
     */
    protected State(Temperament temperament, int x, int y) {
        this(temperament, State.HOLLOW_FLAG, x, y);
    }

    /**
     *
     * @param temperament
     * @param flag
     * @param x
     * @param y
     */
    protected State(Temperament temperament, Flag flag, int x, int y) {
        this.value = temperament;
        this.flag = flag;
        this.x = x;
        this.y = y;
    }
    
    /**
     *
     * @return
     */
    @Override
    public int getX(){
        return this.x;
    }
    
    /**
     *
     * @return
     */
    @Override
    public int getY(){
        return this.y;
    }
    
    /**
     *
     * @param x
     */
    @Override
    public void setX(int x){
        this.x = x;
    }
    
    /**
     *
     * @param y
     */
    @Override
    public void setY(int y){
        this.y = y;
    }

    private void setNeighborsMineCount() {
        Iterator<AbstractState> i = this.getNeighborhoodIterator();
        AbstractState s;
        while (i.hasNext()) {
            s = i.next();
            if (this.getValue() == State.MINE_VALUE) {
                s.incrNeighborMineCount();
            } else {
                s.decrNeighborMineCount();
            }
        }
    }

    /**
     *
     * @param value
     */
    @Override
    public void setValue(Temperament value) {
        if (this.value != value) {
            this.value = value;
            this.setNeighborsMineCount();
        }

    }

    /**
     *
     * @param flag
     */
    @Override
    public void setFlag(Flag flag) {
        this.flag = flag;
    }

    /**
     *
     * @return
     */
    @Override
    public Temperament getValue() {
        return this.value;
    }

    /**
     *
     * @return
     */
    @Override
    public Flag getFlag() {
        
        return this.flag;
    }

    /**
     *
     * @return
     */
    @Override
    public AbstractState clone() {
        return new State(this.value, this.flag, this.x, this.y);
    }

    /**
     *
     * @param s
     */
    @Override
    public void addNeighbor(AbstractState s) {
        this.neighborhood.add(s);
        if (s.getValue() == State.MINE_VALUE) {
            this.explosiveNeighborCount++;
        }
        this.neighborhoodSize++;
    }

    /**
     *
     * @param i
     */
    @Override
    public void removeNeighbor(int i) {
        AbstractState s = this.neighborhood.remove(i);
        if (s.getValue() == State.MINE_VALUE) {
            this.explosiveNeighborCount--;
        }
        this.neighborhoodSize--;
    }

    /**
     *
     * @param i
     * @return
     */
    @Override
    public AbstractState getNeighbor(int i) {
        return this.neighborhood.get(i);
    }

    /**
     *
     * @return
     */
    @Override
    public Iterator<AbstractState> getNeighborhoodIterator() {
        return this.neighborhood.iterator();
    }

    /**
     *
     * @return
     */
    @Override
    public int getNeighborhoodSize() {
        return this.neighborhoodSize;
    }

    /**
     *
     * @return
     */
    @Override
    public int getNeighborMineCount() {
        return this.explosiveNeighborCount;
    }

    /**
     *
     */
    @Override
    protected void incrNeighborMineCount() {
        this.explosiveNeighborCount++;
    }

    /**
     *
     */
    @Override
    protected void decrNeighborMineCount() {
        this.explosiveNeighborCount--;
    }
}
