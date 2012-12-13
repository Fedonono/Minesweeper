/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package View.GraphicalViews.Game;

import Controler.Listeners.CellClicListener;
import Model.Events.LocalGameRefreshEvent;
import Model.Events.RefreshEvent;
import Model.Events.ResizeEvent;
import Model.Game.WorldModel;
import java.awt.GridLayout;
import javax.swing.JPanel;

/**
 *
 * @author nono
 */
public class GraphicalGridView extends JPanel {

    /**
     *
     * @param width
     * @param height
     */
    public GraphicalGridView(int width, int height) {
        super(new GridLayout(height, width));
        this.init(width, height);
    }

    private void addCell(String text, int x, int y) {
        GraphicalCellView cell = new GraphicalCellView(text);
        cell.addListener(new CellClicListener(x, y));
        cell.addMouseListener(cell);
        this.add(cell);        
    }

    private void init(int width, int height) {
        for (int j = 0; j < height; j++) {
            for (int i = 0; i < width; i++) {
                this.addCell("", i, j);
            }
        }
    }

    /**
     *
     * @param ev
     */
    public void refreshCell(RefreshEvent ev) {

        LocalGameRefreshEvent event = (LocalGameRefreshEvent) ev;
        WorldModel wm = (WorldModel) ev.getSource();
        int width = wm.width();
        int i = event.getX();
        int j = event.getY();
        ((GraphicalCellView) this.getComponent(j * width + i)).refresh(ev);
    }
    
    /**
     *
     * @param ev
     */
    public void resize(RefreshEvent ev) {
        ResizeEvent event = (ResizeEvent) ev;
        this.removeAll();
        int width = event.getWidth();
        int height = event.getHeight();
        this.setLayout(new GridLayout(height, width));
        this.init(width, height);
    }
}
