/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities.serialised;

import accounts.Account;
import java.io.Serializable;
import java.util.ArrayList;
import requests.Request;
import utilities.Serialiser;

/**
 * a singleton storing all floating requests
 *
 * @author Anthony
 */
public class RequestSingleton implements Serializable, ISerialise {

    private ArrayList<Request> requests;
    private static RequestSingleton instance = null;

    private RequestSingleton() {
        //requests = new ArrayList<>();
        //saveChanges();
        loadData();
    }

    /**
     *
     * @return - returns the active instance of singleton
     */
    public static RequestSingleton getOrCreate() {
        if (instance == null) {
            instance = new RequestSingleton();
        }
        return instance;
    }

    @Override
    public void addObject(Object o) {
        Request r = (Request) o;

        requests.add(r);
        saveChanges();
    }

    @Override
    public void removeObject(Object o) {
        Request r = (Request) o;

        requests.remove(r);
        saveChanges();
    }

    @Override
    public ArrayList getData() {
        return requests;
    }

    @Override
    public void saveChanges() {
        new Serialiser("data/requests.paa").serialise(requests);;
    }

    @Override
    public void loadData() {
        requests = (ArrayList<Request>) new Serialiser("data/requests.paa").deserialise();
    }

}
