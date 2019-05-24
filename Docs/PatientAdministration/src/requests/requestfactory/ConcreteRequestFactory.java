/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package requests.requestfactory;

import accounts.Account;
import java.io.Serializable;
import requests.*;

/**
 * the concrete implementation of the factory
 * @author Anthony
 */
public class ConcreteRequestFactory extends AbstractRequestFactory implements Serializable {
    
    /**
     * the method for creating a request
     * @param a - account making the request
     * @param rt - request type to make
     * @return - returns the request for further use
     */
    @Override
    public Request createRequest(Account a, RequestType rt)
    {
        switch (rt)
        {
            case CREATE:
                request = new CreateRequest(a, rt);
                request.track();
                break;
            case DELETE:
                request = new DeleteRequest(a, rt);
                request.track();
                break;
            case APPOINTMENT:
                request = new AppointmentRequest(a, rt);
                break;
            case PRESCRIPTION:
                request = new PrescriptionRequest(a, rt);
                break;
            case STOCK:
                request = new StockRequest(a, rt);
                break;
        }
        return request;
    }
}
