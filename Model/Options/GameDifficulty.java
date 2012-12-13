/*
 * Minesweeper Project
 * by Group3 : Arnaud BABOL, Guillaume Simmoneau
 */
package Model.Options;

import java.awt.event.KeyEvent;

/**
 *
 * @author nono
 */
public enum GameDifficulty {
    BEGINNER ("Beginner","10 mines in a 9x9 field",9,9,12.345,false,KeyEvent.VK_B),
    INTERMEDIATE ("Intermediate","40 mines in a 16x16 field",16,16,15.62,false,KeyEvent.VK_I),
    EXPERT ("Expert","99 mines in a 16x30 field",16,30,20.625,false,KeyEvent.VK_E),
    CHUCK_NORRIS ("ChuckNorris","612 mines in a 24x30 field",24,30,85,false,KeyEvent.VK_H),
    /**
     *  Custom have to be the last difficulty.
     */
    CUSTOM ("Custom","",9,19,44.45,false,KeyEvent.VK_C);
    
    /**
     * incr/decr if we add/remove a difficulty
     */
    public static final int NB_DIFFICULTY = 5;
    
    private String name;
    private String description;
    private int height;
    private int width;
    private double bombPercentage;
    boolean thorique;
    int key;
            
    
    GameDifficulty(String name, String description, int height, int width, double bombPercentage, boolean thorique, int key) {
        this.name = name;
        this.description = description;
        this.height = height;
        this.width = width;
        this.bombPercentage = bombPercentage;
        this.thorique = thorique;
        this.key = key;
        
    }

    /**
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @return
     */
    public String getDescription() {
        return description;
    }

    /**
     *
     * @return
     */
    public int getHeight() {
        return height;
    }

    /**
     *
     * @return
     */
    public int getWidth() {
        return width;
    }

    /**
     *
     * @return
     */
    public int getKey() {
        return key;
    }

    /**
     *
     * @return
     */
    public double getBombPercentage() {
        return bombPercentage;
    }
    
    /**
     *
     * @return
     */
    public boolean isThorique() {
        return thorique;
    }
}
