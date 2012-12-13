/*
 * Minesweeper Project
 * by Group3 : Arnaud BABOL, Guillaume Simmoneau
 */
package Controler.Listeners;

import Controler.Exceptions.InvalidCommandException;
import Controler.Minesweeper;
import View.Events.ViewEvent;

/**
 *
 * @author simonneau
 */
public class GameConsoleListener  {
    

    
    /**
     *
     * @param source
     * @param cmd
     * @param ev
     */
    public void cmdAnalyser(ConsoleListener source,String cmd, ViewEvent ev) {

        boolean badArgument = true;
        int i;
        int j;
        int iIndexEnd;
        int jIndexEnd;
        String sFlag;
        try {
            while (badArgument) {

                if (cmd.length() == 0) {
                    throw new InvalidCommandException();
                    
                } else if(cmd.equals("h")){
                    this.help();
                    badArgument = false;
                    source.catchViewEvent(ev);
                }
                else if ("d".equals(cmd.substring(0, 1))) {
                    iIndexEnd = cmd.indexOf(" ", 2);
                    i = Integer.valueOf(cmd.substring(2, iIndexEnd));
                    j = Integer.valueOf(cmd.substring(iIndexEnd + 1));
                    i--;
                    j--;
                    badArgument = false;
                    Minesweeper.getInstance().getRules().demine(i, j);

                } else if ("m".equals(cmd.substring(0, 1))) {
                    iIndexEnd = cmd.indexOf(" ", 2);
                    jIndexEnd = cmd.indexOf(" ", iIndexEnd + 1);
                    i = Integer.valueOf(cmd.substring(2, iIndexEnd));
                    j = Integer.valueOf(cmd.substring(iIndexEnd + 1, jIndexEnd));
                    sFlag = cmd.substring(jIndexEnd + 1);
                    i--;
                    j--;
                    badArgument = false;
                    Minesweeper.getInstance().getRules().flag(i, j, sFlag);

                } else if ("q".equals(cmd.substring(0, 1)) && cmd.length() == 1) {
                    Minesweeper.getInstance().exit();
                    badArgument = false;

                } else if (cmd.equals("o")) {
                    Minesweeper.getInstance().jumToOptions();
                    badArgument = false;

                } else if (cmd.equals("r")) {
                    Minesweeper.getInstance().restart();
                    badArgument = false;
                    
                } else {
                    throw new InvalidCommandException();
                }

            }
        } catch (RuntimeException e) {
            throw new InvalidCommandException();
        }
    }

   
    
    private void help() {
        
        System.out.println("- (d i j)show the cell i, j");
        System.out.println("- (m i j x)put a mine flag on the cell i, j");
        System.out.println("- (m i j ?)put an interrogation flag on the cell i, j");
        System.out.println("- (m i j #) remove any flag on the cell i, j");
        System.out.println("- (o) jump to the option pannel");
        System.out.println("- (r) restart the current game");
        System.out.println("- (h) print the help");
        System.out.println("- (q) exit the game");
        System.out.println();
        
    }
}
