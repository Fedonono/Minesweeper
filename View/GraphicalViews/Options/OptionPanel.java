/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package View.GraphicalViews.Options;

import Controler.Minesweeper;
import Model.Events.OptionRefreshEvent;
import Model.Events.RefreshEvent;
import Model.Options.GameDifficulty;
import Model.Options.OptionModel;
import View.Events.ObservationEvent;
import View.Events.ValidationEvent;
import View.GraphicalViews.Observer;
import java.awt.Container;
import java.awt.Dimension;
import javax.swing.BoxLayout;
import javax.swing.JDialog;

/**
 *
 * @author nono
 */
public class OptionPanel extends JDialog implements Observer {

    private NewGamePanel ngp;
    CustomGamePanel cgp;

    public OptionPanel(int width, int height, int bombNumber, boolean isThorique) {
        this.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);

        ngp = new NewGamePanel();
        cgp = new CustomGamePanel(width, height, bombNumber, isThorique);
        ValidationPanel vp = new ValidationPanel();
        vp.addObserver(this);

        cgp.addObserver(ngp);
        ngp.addObserver(cgp);

        Container cp = this.getContentPane();

        int heightPx = 500;
        int widthPx = 400;
        cp.setLayout(new BoxLayout(cp, BoxLayout.Y_AXIS));
        this.setMinimumSize(new Dimension(widthPx, heightPx));
        this.add(ngp);
        this.add(cgp);
        this.add(vp);
    }

    public void refresh(RefreshEvent event) {
        OptionRefreshEvent ev = (OptionRefreshEvent) event;
        OptionModel m = (OptionModel) ev.getSource();

        if (m.isUnderWay()) {
            ngp.refresh(event);
            cgp.refresh(event);
            this.setVisible(true);
        } else {
            this.setVisible(false);
        }
    }

    @Override
    public void reactToChanges(ObservationEvent ev) {
        if (ev instanceof ValidationEvent) {
            ValidationEvent event = (ValidationEvent) ev;
            OptionModel om = Minesweeper.getInstance().getOptionPanel();
            if(event.getValidate()){
                GameDifficulty gD = ngp.getDifficulty();
                int height = cgp.getOptionHeight();
                int width = cgp.getOptionWidth();
                double bombPercentage = cgp.getBombPercentage();
                boolean thorique = cgp.isThorique();
                
                if (gD == GameDifficulty.CUSTOM) {
                    om.reset(width, height, bombPercentage, thorique, gD);
                } else {
                    om.setDifficulty(gD);
                }
                Minesweeper.getInstance().restart();
                
            }else {
                Minesweeper.getInstance().restart();
            }
        }
    }
}
