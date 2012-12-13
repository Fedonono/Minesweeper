/*
 * Minesweeper Project
 * by Group3 : Arnaud BABOL, Guillaume Simmoneau
 */
package Model.Options;

import Model.Events.OptionRefreshEvent;
import Model.Events.RefreshEvent;
import Model.Exceptions.BombPercentageException;
import Model.Exceptions.HeightException;
import Model.Exceptions.WidthException;
import View.View;
import java.util.LinkedList;

/**
 *
 * @author simonneau
 */
public class OptionModelImpl extends OptionModel {
    private int width;
    private int height;
    private double bombPercentage;
    private boolean thorique;
    private boolean underWay;
    private GameDifficulty gameDifficulty;

    /**
     *
     */
    public OptionModelImpl() {
        this(OptionModel.DEFAULT_WIDTH, OptionModel.DEFAULT_HEIGHT, OptionModel.DEFAULT_BOMB_PERCENTAGE, OptionModel.DEFAULT_THORIQUE, OptionModel.DEFAULT_UNDERWAY, GameDifficulty.CUSTOM);
        this.views = new LinkedList<>();
    }

    private OptionModelImpl(int width, int height, double bombPercentage, boolean thorique, boolean underway, GameDifficulty gd) {
        this.width = width;
        this.height = height;
        this.bombPercentage = bombPercentage;
        this.thorique = thorique;
        this.underWay = underway;
        this.gameDifficulty = gd;
    }

    /**
     *
     * @return
     */
    @Override
    public int getWidth() {
        return width;
    }

    /**
     *
     * @return
     */
    @Override
    public int getHeight() {
        return height;
    }

    /**
     *
     * @return
     */
    @Override
    public double getBombPercentage() {
        return bombPercentage;
    }

    /**
     *
     * @param width
     */
    @Override
    public void setWidth(int width) {
        if(width < OptionModel.MIN_WIDTH || width >OptionModel.MAX_WIDTH){
            throw new WidthException(width);
        }
        this.width = width;
        this.gameDifficulty = GameDifficulty.CUSTOM;
        this.notifyViews();
    }

    /**
     *
     * @param height
     */
    @Override
    public void setHeight(int height) {
        if(height < OptionModel.MIN_HEIGHT || height >OptionModel.MAX_HEIGHT){
            throw new HeightException(height);
        }
        
        this.height = height;
        this.gameDifficulty = GameDifficulty.CUSTOM;
        this.notifyViews();
    }

    /**
     *
     * @param bombPercentage
     */
    @Override
    public void setBombPercentage(double bombPercentage) {
        if(bombPercentage < OptionModel.MIN_BOMB_PERCENTAGE || bombPercentage >OptionModel.MAX_BOMB_PERCENTAGE){
            throw new BombPercentageException();
        }
        
        this.bombPercentage = bombPercentage;
        this.gameDifficulty = GameDifficulty.CUSTOM;
        this.notifyViews();
    }

    private void notifyViews(RefreshEvent ev) {
        for (View v : this.views) {
            v.refresh(ev);
        }
    }

    /**
     *
     */
    @Override
    public void notifyViews() {
        this.notifyViews(new OptionRefreshEvent(this));
    }

    /**
     *
     * @return
     */
    @Override
    public OptionModel clone() {
        return new OptionModelImpl(this.width, this.height, this.bombPercentage, this.thorique, this.underWay, this.gameDifficulty);
    }
    
    /**
     *
     * @return
     */
    @Override
    public boolean isThorique(){
        return this.thorique;
    }
    
    
    
    /**
     *
     * @param thorique
     */
    @Override
    public void setThorique(boolean thorique){
        this.thorique = thorique;
        this.gameDifficulty = GameDifficulty.CUSTOM;
        this.notifyViews();
    }
    
    /**
     *
     * @param gD
     */
    @Override
    public void setDifficulty(GameDifficulty gD) {
        this.bombPercentage = gD.getBombPercentage();
        this.height = gD.getHeight();
        this.width = gD.getWidth();
        this.thorique = gD.isThorique();
        this.gameDifficulty = gD;
    }

    /**
     *
     * @return
     */
    @Override
    public boolean isUnderWay() {
        return this.underWay;
    }

    /**
     *
     * @param underway
     */
    @Override
    public void setUnderWay(boolean underway) {
        this.underWay = underway;
        this.notifyViews();
    }
    
    /**
     *
     * @return
     */
    @Override
    public GameDifficulty getDifficulty() {
        return this.gameDifficulty;
    }

    /**
     *
     * @param width
     * @param height
     * @param bombPercentage
     * @param thorique
     * @param gD
     */
    @Override
    public void reset(int width, int height, double bombPercentage, boolean thorique, GameDifficulty gD) {
        this.width = width;
        this.height = height;
        this.bombPercentage = bombPercentage;
        this.thorique= thorique;
        this.gameDifficulty = gD;
    }
}
