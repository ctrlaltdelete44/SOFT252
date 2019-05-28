/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package requests;

import accounts.Account;
import utilities.serialised.RequestSingleton;
import java.io.Serializable;
import utilities.Observing.IObserver;

/**
 * abstract request containing shared properties and behaviours
 *
 * @author Anthony
 */
public abstract class Request implements Serializable, IObserver {

    /**
     * the account making the request
     */
    protected Account account;

    /**
     * the type of request being made
     */
    protected RequestType requestType;

    /**
     * a singleton of all requests (serialised)
     */
    protected RequestSingleton requests = RequestSingleton.getOrCreate();

    /**
     * removes request from singleton
     */
    @Override
    public void untrackRequest() {
        requests.removeObject(this);
    }

    /**
     * default constructor, as all requests have this basic info associated with
     * them
     *
     * @param a - account making request
     * @param rt - request type being made
     */
    public Request(Account a, RequestType rt) {
        account = a;
        requestType = rt;
    }

    /**
     * abstract method to identify request type
     *
     * @return - returns an enum
     */
    public abstract RequestType getRequestType();

    /**
     * abstract method for processing a request, as each request type handles
     * this differently
     *
     * @return - returns a validation string for secretary
     */
    public abstract String process();

    /**
     * standard accessor for retrieving the account linked to request
     *
     * @return - returns account that created account
     */
    public Account getAccount() {
        return account;
    }

    /**
     * tracks the request
     */
    public void track() {
        requests.addObject(this);
    }

}
