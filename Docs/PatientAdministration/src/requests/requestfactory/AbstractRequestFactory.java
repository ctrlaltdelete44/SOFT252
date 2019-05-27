/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package requests.requestfactory;

import accounts.Account;
import java.io.Serializable;
import requests.Request;
import requests.RequestType;

/**
 * the abstract factory denoting the methods used to create a new request
 *
 * @author Anthony
 */
public abstract class AbstractRequestFactory implements Serializable {

    /**
     * the request created
     */
    protected Request request;

    /**
     * the method for creating a request
     *
     * @param a - account making the request
     * @param rt - request type required
     * @return - returns the request made because some requests need to assign
     * additional information to it
     */
    public abstract Request createRequest(Account a, RequestType rt);
}
