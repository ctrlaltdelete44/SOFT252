/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities.Observing;

import requests.Request;

/**
 * observable interface to denote a class that can be observed. currently
 * patients, eventually also doctors to remove their active requests
 *
 * @author davie
 */
public interface IObservable {

    /**
     * adds a request to the stored list
     *
     * @param r - the request to register
     */
    public void registerObserver(Request r);

    /**
     * removes a request from the stored list
     *
     * @param r - the request to remove
     */
    public void unregisterObserver(Request r);

    /**
     * loops through the list and triggers their "untrack" method
     */
    public void cleanDeleteObservers();
}
