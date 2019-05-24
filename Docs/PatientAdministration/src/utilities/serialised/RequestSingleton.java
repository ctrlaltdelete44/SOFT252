/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities.serialised;

import java.io.Serializable;
import java.util.ArrayList;
import requests.Request;

/**
 * a singleton storing all floating requests
 * @author Anthony
 */
public class RequestSingleton implements Serializable {
    private ArrayList<Request> requests;
    private static RequestSingleton instance = null;
    
    private static final Compilation c = new Compilation();
    
    private RequestSingleton()
    {
        requests = new ArrayList<>();
    }
    
    /**
     * 
     * @return - returns the active instance of singleton
     */
    public static RequestSingleton getOrCreate()
    {
        if (instance == null)
            instance = new RequestSingleton();
        return instance;
    }
    
    /**
     * tracks a new request
     * @param r - request to add to singleton
     */
    public void add(Request r)
    {
        requests.add(r);
        //System.out.println(r.getRequestType() + " request of " + r.getAccount().getFirstName() + " added to tracker");
        
        c.construct();
        
    }
    
    /**
     * untracks a request
     * @param r - the request to remove
     */
    public void remove(Request r)
    {
        requests.remove(r);
        //System.out.println(r.getRequestType() + " request of " + r.getAccount().getFirstName() + " removed from tracker");
        
        c.construct();
    }

    /**
     * standard accessor
     * @return - returns the requests
     */
    public ArrayList<Request> getRequests() {
        //System.out.println("Getting requests...:REQUESTSINGLETON");
        return requests;
    }
    
    /**
     * mutator used in serialisation
     * @param ar - the new requests to set
     */
    public void setRequests(ArrayList<Request> ar)
    {
        requests = ar;
    }
    
    /**
     * prints a report on the requests, used for debugging
     */
    public void printRequests()
    {
        //c.deconstruct();
        //System.out.println("Requests:");
        //for (Request r : requests)
        //    System.out.println(r.getAccount().getFirstName() + " " + r.getAccount().getSurname() + ": " + r.getRequestType());
    }
    
}
