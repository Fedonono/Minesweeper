/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package View.GraphicalViews.Scores;

import Model.Events.EndGameEvent;
import Model.Events.RefreshEvent;
import View.View;

/**
 *
 * @author simonneau
 */
public class GraphicalLogscoreView extends View {

    private LogScorePanel logScorePanel;

    public GraphicalLogscoreView() {
        logScorePanel = new LogScorePanel();
    }

    @Override
    public void refresh(RefreshEvent event) {
        
        if (event instanceof EndGameEvent) {
            boolean win = ((EndGameEvent) event).win();
            if (win) {
                this.logScorePanel.refresh(event);
            }
        }
    }
}
