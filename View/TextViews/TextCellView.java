/*
 * Minesweeper Project
 * by Group3 : Arnaud BABOL, Guillaume SIMMONEAU
 */
package View.TextViews;

import Model.Events.LocalGameRefreshEvent;
import Model.Events.RefreshEvent;
import Model.Game.AbstractState;
import Model.Game.WorldModel;
import View.CellView;

/**
 *
 * @author simonneau
 */
public class TextCellView extends CellView {

    /**
     *
     * @param event
     */
    @Override
    public void refresh(RefreshEvent event) {
        LocalGameRefreshEvent ev = (LocalGameRefreshEvent) event;
        WorldModel wm = (WorldModel) ev.getSource();
        int i = ev.getX();
        int j = ev.getY();
        AbstractState s = wm.getState(i, j);
        
        if (s.getFlag() == AbstractState.HOLLOW_FLAG) {
            System.out.printf(CellView.HOLLOW_FLAG + " ");
        } else if (s.getFlag() == AbstractState.MINE_FLAG) {
            System.out.printf(CellView.MINE_FLAG + " ");
        } else if (s.getFlag() == AbstractState.TEMP_FLAG) {
            System.out.printf(CellView.TEMP_FLAG + " ");
        } else if (s.getValue() == AbstractState.MINE_VALUE) {
            System.out.printf(CellView.MINE_SYMBOL + " ");
        } else if (s.getValue() == AbstractState.EMPTY_CELL_VALUE) {
            int neighborMineCount = s.getNeighborMineCount();
            if (neighborMineCount > 0) {
                System.out.printf(Integer.toString(neighborMineCount) + " ");
            } else {
                System.out.printf(CellView.EMPTY_CELL_SYMBOL + " ");
            }
        }
    }
}
