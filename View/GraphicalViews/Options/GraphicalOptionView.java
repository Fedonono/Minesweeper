/*
 * Minesweeper Project
 * by Group3 : Arnaud BABOL, Guillaume SIMMONEAU
 */
package View.GraphicalViews.Options;

import Model.Events.OptionRefreshEvent;
import Model.Events.RefreshEvent;
import View.View;

/**
 *
 * @author simonneau
 */
public class GraphicalOptionView extends View {
    private OptionPanel op;

    public GraphicalOptionView(int width, int height, int bombNumber, boolean isThorique) {
        op = new OptionPanel(width, height, bombNumber, isThorique);
    }

    
    
    @Override
    public void refresh(RefreshEvent event) {
        if(event instanceof OptionRefreshEvent){
            op.refresh(event);
        }
    }
}
