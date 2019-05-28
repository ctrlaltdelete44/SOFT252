/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities.Observing;

/**
 * an interface to identify observers
 *
 * @author davie
 */
public interface IObserver {

    /**
     * will remove this observer from the request singleton
     */
    public void untrackRequest();
}
