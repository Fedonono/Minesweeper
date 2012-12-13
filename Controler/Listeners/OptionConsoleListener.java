/*
 * Minesweeper Project
 * by Group3 : Arnaud BABOL, Guillaume SIMMONEAU
 */
package Controler.Listeners;

import Controler.Exceptions.InvalidCommandException;
import Controler.Minesweeper;
import Model.Options.GameDifficulty;
import Model.Options.OptionModel;
import View.Events.ViewEvent;

/**
 *
 * @author simonneau
 */
public class OptionConsoleListener {

    /**
     *
     * @param source
     * @param cmd
     * @param ev
     */
    public void cmdAnalyser(ConsoleListener source, String cmd, ViewEvent ev) {
        boolean badArgument = true;

        int value;
        try {
            while (badArgument) {
                if (cmd.length() == 0) {
                    Minesweeper.getInstance().restart();
                    badArgument = false;

                } else if (cmd.equals("h")) {
                    this.help();
                    badArgument = false;
                    source.catchViewEvent(ev);

                } else if (cmd.equals("q")) {
                    Minesweeper.getInstance().exit();
                    badArgument = false;

                } else if (cmd.substring(0, 1).equals("w")) {
                    value = Integer.valueOf(cmd.substring(2));
                    Minesweeper.getInstance().getOptionPanel().setWidth(value);
                    badArgument = false;

                } else if (cmd.substring(0, 1).equals("h")) {
                    value = Integer.valueOf(cmd.substring(2));
                    Minesweeper.getInstance().getOptionPanel().setHeight(value);
                    badArgument = false;

                } else if (cmd.equals("t")) {
                    OptionModel om = Minesweeper.getInstance().getOptionPanel();
                    om.setThorique(!om.isThorique());
                    badArgument = false;

                } else if (cmd.substring(0, 2).equals("bp")) {
                    value = Integer.valueOf(cmd.substring(3));
                    Minesweeper.getInstance().getOptionPanel().setBombPercentage(value);
                    badArgument = false;
                } else {
                    if (isDifficulty(cmd)) {
                        badArgument = false;
                    } else {
                        throw new InvalidCommandException();
                    }
                }
            }
        } catch (RuntimeException e) {
            throw new InvalidCommandException();
        }
    }

    private boolean isDifficulty(String cmd) {
        for (GameDifficulty gD : GameDifficulty.values()) {
            if (cmd.equalsIgnoreCase(gD.getName())) {
                if (gD != GameDifficulty.CUSTOM) {
                    Minesweeper.getInstance().getOptionPanel().setDifficulty(gD);
                    Minesweeper.getInstance().restart();
                    return true;
                }
            }
        }
        return false;
    }

    private void help() {
        System.out.println("- (w integer) set the width (MIN WIDTH = " + OptionModel.MIN_WIDTH + ", MAX WIDTH = " + OptionModel.MAX_WIDTH + ")");
        System.out.println("- (h integer)set the height(MIN HEIGHT = " + OptionModel.MIN_HEIGHT + ", MAX HEIGHT = " + OptionModel.MAX_HEIGHT + ")");
        System.out.println("- (bp integer) set the bomb percentage(MIN BOMB PERCENTAGE = " + OptionModel.MIN_BOMB_PERCENTAGE + "%, MAX BOMB PERCENTAGE = " + OptionModel.MAX_BOMB_PERCENTAGE + "%)");
        System.out.println("- (t) activate/disactivate the thorique property");
        System.out.println("- (beginner) set settings to the default beginner grid");
        System.out.println("- (intermediate) set settings to the default intermediate grid");
        System.out.println("- (expert) set settings to the default expert grid");
        System.out.println("- newline ==> validate settings");
        System.out.println("- (h) print the help");
        System.out.println("- (q) exit the game");
        System.out.println();
    }
}
