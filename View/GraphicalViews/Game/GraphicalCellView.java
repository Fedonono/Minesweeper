/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package View.GraphicalViews.Game;

import Controler.Listeners.ViewListener;
import Model.Events.LocalGameRefreshEvent;
import Model.Events.RefreshEvent;
import Model.Game.AbstractState;
import Model.Game.WorldModel;
import View.CellView;
import java.awt.Color;
import java.awt.event.MouseEvent;

/**
 *
 * @author nono
 */
public class GraphicalCellView extends AbstractButtonView {
    private CellView view;

    /**
     *
     * @param text
     */
    public GraphicalCellView(String text) {
        super(text);
        cellLabel.setFont(CellView.StyleComic);
        cellLabel.setAlignmentX(0.5f);
        view = new CellView();
    }

    
    /**
     *
     * @param event
     */
    public void refresh(RefreshEvent event) {
        LocalGameRefreshEvent ev = (LocalGameRefreshEvent) event;
        WorldModel wm = (WorldModel) ev.getSource();
        int i = ev.getX();
        int j = ev.getY();
        AbstractState s = wm.getState(i, j);
        
        if (s.getFlag() == AbstractState.HOLLOW_FLAG) {
            cellLabel.setIcon(null);
            cellLabel.setText("");
        } else if (s.getFlag() == AbstractState.MINE_FLAG) {
            cellLabel.setIcon(CellView.flagImg);
        } else if (s.getFlag() == AbstractState.TEMP_FLAG) {
            cellLabel.setIcon(CellView.tempFlagImg);
        } else if (s.getValue() == AbstractState.MINE_VALUE) {
            this.setEnabled(false);
            this.setBackground(Color.red);
            cellLabel.setIcon(CellView.mineImg);
        } else if (s.getValue() == AbstractState.EMPTY_CELL_VALUE) {
            cellLabel.setIcon(null);
            this.setEnabled(false);
            int neighborMineCount = s.getNeighborMineCount();
            if (neighborMineCount > 0) {
                cellLabel.setText(Integer.toString(neighborMineCount));
                cellLabel.setForeground(CellView.neighborColor[neighborMineCount-1]);
            }
        }
    }

    
    /**
     *
     * @param e
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        view.notifyListeners(e);
    }
    
    /**
     *
     * @param listener
     */
    public void addListener(ViewListener listener){
        view.addListener(listener);
    }
}
