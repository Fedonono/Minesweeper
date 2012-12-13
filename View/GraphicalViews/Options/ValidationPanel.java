/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package View.GraphicalViews.Options;

import View.Events.ObservationEvent;
import View.Events.ValidateButtonEvent;
import View.Events.ValidationEvent;
import View.GraphicalViews.Observable;
import View.GraphicalViews.Observer;
import View.GraphicalViews.ValidateButton;
import java.awt.FlowLayout;
import java.util.LinkedList;
import javax.swing.JPanel;

/**
 *
 * @author simonneau
 */
public class ValidationPanel extends JPanel implements Observer, Observable{
    
    LinkedList<Observer> observers = new LinkedList<>();

    private static final String OK_label = "OK";
    private static final String CANCEL_label = "Cancel";
    private boolean validate = false;
    
    public ValidationPanel() {
        super(new FlowLayout());
        ValidateButton cancel = new ValidateButton(OK_label);
        ValidateButton ok = new ValidateButton(CANCEL_label);
        this.add(cancel);
        this.add(ok);
        
        cancel.addObserver(this);
        ok.addObserver(this);
    }

    @Override
    public void reactToChanges(ObservationEvent ev) {
        if(ev instanceof ValidateButtonEvent){
            ValidateButtonEvent event = (ValidateButtonEvent)ev;
            String label = ((ValidateButton)event.getSource()).getText();
            switch(label){
                case OK_label:
                    validate = true;
                    break;
                case CANCEL_label:
                    validate = false;
            }
            this.notifyObserver();
        }
    }

    @Override
    public void addObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void notifyObserver() {
        for(Observer o : observers){
            o.reactToChanges(new ValidationEvent(this,validate));
        }
    }
    
}
