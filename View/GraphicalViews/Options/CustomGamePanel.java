/*
 * Minesweeper Project
 * by Group3 : Arnaud BABOL, Guillaume SIMMONEAU
 */
package View.GraphicalViews.Options;

import Model.Events.OptionRefreshEvent;
import Model.Events.RefreshEvent;
import Model.Options.GameDifficulty;
import Model.Options.OptionModel;
import View.Events.CustomGamePanelEvent;
import View.Events.NewGamePanelEvent;
import genericGraphicalComponents.CheckBoxEvent;
import genericGraphicalComponents.CustomCheckBox;
import genericGraphicalComponents.CustomOptionLine;
import genericGraphicalComponents.Observable;
import genericGraphicalComponents.ObservationEvent;
import genericGraphicalComponents.Observer;
import genericGraphicalComponents.OptionLineEvent;
import java.awt.GridLayout;
import java.util.LinkedList;
import javax.swing.JPanel;

/**
 *
 * @author nono
 */
public class CustomGamePanel extends JPanel implements Observer, Observable {

    private LinkedList<Observer> observers = new LinkedList<>();
    private static final String rowsLabel = "Rows";
    private static final String columnsLabel = "Columns";
    private static final String minesLabel = "Mines";
    private static final String thoriqueLabel = "Thorique";
    private int width;
    private int height;
    private int minesNumber;
    private boolean isThorique;
    private CustomOptionLine rows;
    private CustomOptionLine columns;
    private CustomOptionLine mines;
    private CustomCheckBox thorique;

    public CustomGamePanel(int width, int height, int bombNumber, boolean isThorique) {
        this.width = width;
        this.height = height;
        this.minesNumber = bombNumber;
        this.isThorique = isThorique;

        this.rows = new CustomOptionLine(rowsLabel, OptionModel.MIN_HEIGHT, OptionModel.MAX_HEIGHT, height);
        this.columns = new CustomOptionLine(columnsLabel, OptionModel.MIN_WIDTH, OptionModel.MAX_WIDTH, width);
        this.mines = new CustomOptionLine(minesLabel, (int) (OptionModel.MIN_BOMB_PERCENTAGE * OptionModel.DEFAULT_WIDTH * OptionModel.DEFAULT_HEIGHT) / 100, (int) (OptionModel.MAX_BOMB_PERCENTAGE * OptionModel.DEFAULT_WIDTH * OptionModel.DEFAULT_HEIGHT) / 100, (int) (OptionModel.DEFAULT_BOMB_PERCENTAGE * OptionModel.DEFAULT_WIDTH * OptionModel.DEFAULT_HEIGHT) / 100);
        this.thorique = new CustomCheckBox(thoriqueLabel, isThorique);

        setLayout(new GridLayout(4, 1));
        this.add(thorique);
        this.add(rows);
        this.add(columns);
        this.add(mines);

        thorique.addObserver(this);
        rows.addObserver(this);
        columns.addObserver(this);
        mines.addObserver(this);
    }

    public void refresh(RefreshEvent event) {
        OptionRefreshEvent ev = (OptionRefreshEvent) event;
        OptionModel om = (OptionModel) ev.getSource();
        this.setWidth(om.getWidth());

        this.setHeight(om.getHeight());

        this.setMinesNumber((int) Math.floor(om.getBombPercentage() * this.width * this.height / 100));

        this.setThoricity(om.isThorique());

    }

    private void setWidth(int width) {
        this.width = width;
        columns.setValue(this.width);
        this.resizeMineSlider();
    }

    private void setHeight(int height) {
        this.height = height;
        rows.setValue(this.height);
        this.resizeMineSlider();
    }

    public int getOptionHeight() {
        return this.height;
    }

    public int getOptionWidth() {
        return this.width;
    }

    public double getBombPercentage() {
        return this.minesNumber * 100 / (this.width * this.height);
    }

    public boolean isThorique() {
        return this.isThorique;
    }

    private void setMinesNumber(int minesNumber) {
        this.minesNumber = minesNumber;
        mines.setValue(this.minesNumber);
    }

    private void setThoricity(boolean isThorique) {
        this.isThorique = isThorique;
        thorique.setSelected(isThorique);
    }

    private void resizeMineSlider() {
        int size = this.height * this.width;
        int min = (int) Math.floor(size * OptionModel.MIN_BOMB_PERCENTAGE / 100);
        int max = (int) Math.floor(size * OptionModel.MAX_BOMB_PERCENTAGE / 100);

        if (this.minesNumber < min) {
            this.minesNumber = min;
        } else if (this.minesNumber > max) {
            this.minesNumber = max;
        }
        //a revoir
        this.mines.setValue(this.minesNumber);
        this.mines.setMaxValue(max);
        this.mines.setMinValue(min);
    }

    @Override
    public void reactToChanges(ObservationEvent ev) {

        if (ev instanceof CheckBoxEvent) {
            CheckBoxEvent event = (CheckBoxEvent) ev;
            this.setThoricity(event.isChecked());
            this.notifyObserver();

        } else if (ev instanceof OptionLineEvent) {
            OptionLineEvent event = (OptionLineEvent) ev;
            String label = ((CustomOptionLine) (event.getSource())).getLabel();

            switch (label) {
                case rowsLabel:
                    this.setHeight(event.getValue());
                    break;
                case columnsLabel:
                    this.setWidth(event.getValue());
                    break;
                case minesLabel:
                    this.setMinesNumber(event.getValue());
                    break;
            }
            this.notifyObserver();

        } else if (ev instanceof NewGamePanelEvent) {

            GameDifficulty gD = ((NewGamePanel) ev.getSource()).getDifficulty();
            if (gD != GameDifficulty.CUSTOM) {
                this.setWidth(gD.getWidth());
                this.setHeight(gD.getHeight());
                this.setMinesNumber((int) Math.floor(gD.getBombPercentage() * this.width * this.height / 100));
                this.setThoricity(gD.isThorique());
            }
        }
    }

    @Override
    public void addObserver(Observer o) {
        this.observers.add(o);
    }

    @Override
    public void notifyObserver() {
        for (Observer o : observers) {
            o.reactToChanges(new CustomGamePanelEvent(this));
        }
    }
}
