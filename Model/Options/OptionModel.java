/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Options;

import Model.Model;

/**
 *
 * @author simonneau
 */
public abstract class OptionModel extends Model {

    /**
     *
     */
    public static final int DEFAULT_WIDTH = 19;
    /**
     *
     */
    public static final int DEFAULT_HEIGHT = 9;
    /**
     *
     */
    public static final double DEFAULT_BOMB_PERCENTAGE = 44.5;
    /**
     *
     */
    public static final int MAX_WIDTH = 30;
    /**
     *
     */
    public static final int MAX_HEIGHT = 24;
    /**
     *
     */
    public static final double MAX_BOMB_PERCENTAGE = 85;
    /**
     *
     */
    public static final int MIN_WIDTH = 9;
    /**
     *
     */
    public static final int MIN_HEIGHT = 9;
    /**
     *
     */
    public static final double MIN_BOMB_PERCENTAGE = 5;
    /**
     *
     */
    public static final boolean DEFAULT_THORIQUE = false;
    /**
     *
     */
    public static final boolean DEFAULT_UNDERWAY = false;
    /**
     *
     */
    public static final String DEFAULT_MOD = GameDifficulty.CUSTOM.getName();
    

    /**
     *
     * @return
     */
    public abstract int getWidth();

    /**
     *
     * @return
     */
    public abstract int getHeight();

    /**
     *
     * @return
     */
    public abstract double getBombPercentage();

    /**
     *
     * @param width
     */
    public abstract void setWidth(int width);

    /**
     *
     * @param height
     */
    public abstract void setHeight(int height);

    /**
     *
     * @param bombPercentage
     */
    public abstract void setBombPercentage(double bombPercentage);
    
    /**
     *
     * @return
     */
    public abstract boolean isThorique();
    
    /**
     *
     * @return
     */
    public abstract boolean isUnderWay();
    
    /**
     *
     * @param thorique
     */
    public abstract void setThorique(boolean thorique);

    /**
     *
     * @param underway
     */
    public abstract void setUnderWay(boolean underway);
    
    /**
     *
     * @param gD
     */
    public abstract void setDifficulty(GameDifficulty gD);
    
    /**
     *
     * @return
     */
    public abstract GameDifficulty getDifficulty();

    /**
     *
     * @param width
     * @param height
     * @param bombPercentage
     * @param thorique
     * @param gD
     */
    public abstract void reset(int width, int height, double bombPercentage, boolean thorique, GameDifficulty gD);
    
}
