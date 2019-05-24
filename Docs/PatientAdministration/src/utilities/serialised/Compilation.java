/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities.serialised;

import accounts.Account;
import java.io.Serializable;
import java.util.ArrayList;
import medicinecabinet.StockItem;
import requests.Request;
import utilities.Serialiser;
import appointments.Appointment;

/**
 * a compilation of the classes that need to be serialised
 * @author Anthony
 */
public class Compilation implements Serializable {
    private ArrayList<Account> accounts;
    private int id;
    private ArrayList<Request> requests;
    private ArrayList<StockItem> stock;
    private ArrayList<Appointment> appointments;
    
    private final Serialiser s = new Serialiser("data.paa");
    
    /**
     * takes a copy of all relevant singletons in their current state, and then
     * serialises itself
     */
    public void construct()
    {
        accounts = AccountSingleton.getOrCreate().getAccounts();
        id = IdGenerator.getIdNumber();
        requests = RequestSingleton.getOrCreate().getRequests();
        stock = StockSingleton.getOrCreate().getStock();
        appointments = AppointmentSingleton.getOrCreate().getAppointments();
        
        s.serialise(this);
    }
    
    /**
     * deserialises a new version of itself, and then assigns the currently
     * active singletons new values from the new object
     */
    public void deconstruct()
    {
        Compilation newObject = (Compilation)s.deserialise();
        
        AccountSingleton.getOrCreate().setAccounts(newObject.accounts);
        IdGenerator.setIdNumber(newObject.id);
        RequestSingleton.getOrCreate().setRequests(newObject.requests);
        StockSingleton.getOrCreate().setStock(newObject.stock);
        AppointmentSingleton.getOrCreate().setAppointments(newObject.appointments);
    }
    
}
