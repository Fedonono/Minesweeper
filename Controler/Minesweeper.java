package Controler;

import Controler.Exceptions.AlreadyInstanciedApplet;
import Controler.Listeners.ConsoleListener;
import Model.Events.RefreshEvent;
import Model.Events.ResizeEvent;
import Model.Game.WorldModel;
import Model.Game.WorldModelImpl;
import Model.Options.GameDifficulty;
import Model.Options.OptionModel;
import Model.Options.OptionModelImpl;
import Model.Scores.ScoresModel;
import View.GraphicalViews.Game.GameFrame;
import View.GraphicalViews.Game.GraphicalGameView;
import View.GraphicalViews.Options.GraphicalOptionView;
import View.GraphicalViews.Scores.GraphicalLogscoreView;
import View.GraphicalViews.Scores.ScorePanel;
import View.TextViews.OptionTextView;
import View.TextViews.WorldTextView;
import View.View;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JApplet;

/**
 *
 * @author simonneau
 */
public class Minesweeper extends JApplet {

    /**
     *
     * @param args
     */
    public static void main(String args[]) {
        Minesweeper.standAlone = true;

        Minesweeper ms = Minesweeper.getInstance();
        ms.init();
    }
    private Rules rules = null;
    private boolean resumeGame = true;
    private boolean resumeSetOption = false;
    private OptionModel optionPanel = null;
    private ScoresModel scores = null;
    private static boolean standAlone = false;
    private static Minesweeper instance;
    private GameFrame standAloneFrame;

    public static Minesweeper getInstance() {
        if (instance == null) {
            instance = new Minesweeper();
        }
        return instance;
    }

    @Override
    public void init() {
        super.init();
        this.initGame();
        this.setVisible(true);
        while (true) {
            this.play();
            this.setOptions();
        }
    }

    public boolean standAlone() {
        return Minesweeper.standAlone;
    }

    public GameFrame getStandAloneFrame() {
        return this.standAloneFrame;
    }

    /**
     *
     * @return
     */
    public OptionModel getOptionPanel() {
        return this.optionPanel;
    }

    private void initGame() {

        this.optionPanel = new OptionModelImpl();
        this.scores = new ScoresModel();
        WorldModel wm = this.createWorldModel();

        int width = this.optionPanel.getWidth();
        int height = this.optionPanel.getHeight();
        this.setSize(new Dimension(width * 55, height * 55));

        OptionTextView optionTextv = new OptionTextView();
        optionTextv.addListener(ConsoleListener.getInstance());

        View wTextv = new WorldTextView(width * height);
        wTextv.addListener(ConsoleListener.getInstance());

        GraphicalGameView ggV = new GraphicalGameView(width, height, wm.getBombNumber(), optionPanel.isThorique(), wm.getMessage());
        GraphicalOptionView goV = new GraphicalOptionView(width, height, wm.getBombNumber(), optionPanel.isThorique());
        GraphicalLogscoreView glV = new GraphicalLogscoreView();


        this.add(ggV.getPanel());
        if (Minesweeper.standAlone) {
            this.standAloneFrame = new GameFrame(width, height);
            this.standAloneFrame.add(this, BorderLayout.CENTER);
        }

        wm.addView(ggV);
        wm.addView(wTextv);
        this.optionPanel.addView(goV);
        this.optionPanel.addView(optionTextv);

        if (this.standAlone()) {
            wm.addView(glV);
            this.scores.addView(new ScorePanel());
        }

        this.rules = new Rules(wm);
    }

    public Minesweeper() {
        if (Minesweeper.instance != null) {
            throw new AlreadyInstanciedApplet();
        } else {
            instance = this;
        }
    }

    /**
     *
     * @return
     */
    public ScoresModel getScores() {
        return this.scores;
    }

    /**
     *
     * @return
     */
    public boolean getResumeGame() {
        return this.resumeGame;
    }

    /**
     *
     * @return
     */
    public boolean getResumeSetOption() {
        return this.resumeSetOption;
    }

    /**
     *
     */
    public void startGame() {
        this.optionPanel.setUnderWay(false);
        this.resumeSetOption = false;
        this.resumeGame = true;
    }

    /**
     *
     */
    public void jumToOptions() {
        this.resumeSetOption = true;
        this.resumeGame = false;
        this.optionPanel.setUnderWay(true);
    }

    /**
     *
     */
    public void restart() {
        this.startGame();
        this.rules.reset(this.createWorldModel());
    }

    /**
     *
     */
    public void exit() {
        System.exit(0);
    }

    /**
     *
     * @return
     */
    public Rules getRules() {
        return this.rules;
    }

    private void setOptions() {
        while (this.resumeSetOption) {
        }
    }

    private void play() {
        this.rules.getGameboard().notifyViews();
        while (this.resumeGame) {
        }
    }

    private WorldModel createWorldModel() {
        int width = this.optionPanel.getWidth();
        int height = this.optionPanel.getHeight();
        double bombPercentage = this.optionPanel.getBombPercentage();
        boolean isThorique = this.optionPanel.isThorique();
        GameDifficulty gd = optionPanel.getDifficulty();

        WorldModel m = new WorldModelImpl(width, height, bombPercentage, isThorique, gd);

        return m;
    }

    public void resize(RefreshEvent event) {
        if (this.standAlone()) {
            this.standAloneFrame.resize(event);
        }else{
            int width = ((ResizeEvent) event).getWidth() * 50;
            int height = ((ResizeEvent) event).getHeight() * 50;
            this.setSize(new Dimension(width,height));
            this.setMinimumSize(new Dimension(width, height));
        }
    }
}
