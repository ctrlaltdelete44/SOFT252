/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appointments.results;

import java.io.Serializable;

/**
 * the abstract class for a "further action" concept for following up an
 * appointment
 *
 * @author davie
 */
public abstract class Action implements Serializable {

    /**
     * @return - returns an enum to identify the action type
     */
    public abstract ActionType getActionType();

    /**
     * creates a request for the given action
     */
    public abstract void processRequest();
}
