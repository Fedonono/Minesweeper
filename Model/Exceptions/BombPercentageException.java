/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Exceptions;

import Model.Options.OptionModel;

/**
 *
 * @author simonneau
 */
public class BombPercentageException extends RuntimeException {

    /**
     *
     */
    public BombPercentageException() {
        super("the Width must be greater than "+ OptionModel.MIN_BOMB_PERCENTAGE + " and lower than "+OptionModel.MAX_BOMB_PERCENTAGE+".");
    }
}
