/*
 * Minesweeper Project
 * by Group3 : Arnaud BABOL, Guillaume SIMMONEAU
 */
package Controler.Listeners;

import Controler.Exceptions.InvalidCommandException;
import View.Events.ViewEvent;
import View.TextViews.OptionTextView;
import View.TextViews.WorldTextView;
import java.util.Scanner;

/**
 *
 * @author simonneau
 */
/**
 * as the console is unique, ConsoleListener follow singleton pattern.
 */
public class ConsoleListener extends ViewListener {

    private Scanner scan = new Scanner(System.in);
    private boolean listening = false;
    private int observed = 1; //1==>game, 2==>options
    private static ConsoleListener instance;
    private GameConsoleListener gConsole;
    private OptionConsoleListener oConsole;

    private ConsoleListener() {
        this.gConsole = new GameConsoleListener();
        this.oConsole = new OptionConsoleListener();
    }

    /**
     *
     * @return
     */
    public static ConsoleListener getInstance() {
        if (ConsoleListener.instance == null) {
            ConsoleListener.instance = new ConsoleListener();
        }
        return ConsoleListener.instance;
    }

    /**
     *
     * @param cmd
     * @param ev
     */
    public void cmdAnalyser(String cmd, ViewEvent ev) {
        if (observed == 1) {
            this.gConsole.cmdAnalyser(instance, cmd, ev);
        } else if (observed == 2) {
            this.oConsole.cmdAnalyser(instance, cmd, ev);
        }

    }

    /**
     *
     * @param ev
     */
    @Override
    public void catchViewEvent(ViewEvent ev) {
        
        Class vClass = ev.getSource().getClass();
        
        if (vClass == WorldTextView.class) {
            System.out.println("Choose the action that you want to perform. Help => (h) :");
            this.observed = 1;
            
        }else if(vClass == OptionTextView.class){
            System.out.println("Choose the settings you want. Help => (h) :");
            this.observed = 2;
        }

        if (!this.listening) {
            String cmd = this.getCmd();
            try {
                this.cmdAnalyser(cmd, ev);

            } catch (InvalidCommandException e) {
                System.err.println(e.getMessage());
                this.catchViewEvent(ev);
            }
        }
    }

    private String getCmd() {
        this.listening = true;
        String cm = this.scan.nextLine();
        this.listening = false;
        return cm;
    }
}
