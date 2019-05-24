/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.old;

import accounts.Doctor;
import accounts.Secretary;
import utilities.accounts.AccountType;
import medicinecabinet.StockItem;
import utilities.AccountAdapter;

/**
 * controller for secretary specific functionality
 * @author davie
 */
public class SecretaryController {
    private Secretary authorisingSecretary;
    private static SecretaryController instance = null;
    
    private SecretaryController()
    {
        
    }
    
    /**
     * kept as a singleton to preserve the authorising secretary
     * @return - returns the current instance of the controller
     */
    public static SecretaryController getOrCreate()
    {
        if (instance == null)
            instance = new SecretaryController();
        return instance;
    }
    
    /**
     * standard mutator
     * @param s - the logged in secretary
     */
    public void setAuthorisingSecretary(Secretary s)
    {
        authorisingSecretary = s;
    }
    
    /**
     * standard accessor 
     * @return - returns the logged in secretary
     */
    public Secretary getAuthorisingSecretary()
    {
        return authorisingSecretary;
    }
    
    /**
     * method for viewing all floating requests
     * @return - returns information about each request in an array of strings
     */
    public String[] viewRequests()
    {
        return authorisingSecretary.viewRequests();
    }
    
    /**
     * secretary can delete requests
     * @param requestToDelete - the information about the request to delete
     */
    public void deleteRequest(String requestToDelete)
    {
        authorisingSecretary.deleteRequest(requestToDelete);
    }
    
    /**
     * secretary can authorise requests
     * @param strRequest - the request to authorise
     * @return - returns a message for the secretary
     */
    public String authoriseRequest(String strRequest)
    {
        String output = authorisingSecretary.authoriseRequest(strRequest);       
        return output;
    }
    
    /**
     * secretary can view the stock of medicines
     * @return - returns a list of the stock
     */
    public String[] viewStock()
    {
        return authorisingSecretary.viewStock();
    }
    
    /**
     * method for adding an item to stock
     * @param name - item to add
     * @param quantity - quantity to add
     */
    public void addToStock(String name, int quantity)
    {
        if (!name.equals(""))
            authorisingSecretary.addToStock(name, quantity);
    }
    
    /**
     * method for removing an item from stock
     * @param name - item to request
     * @param quantity - amount requested
     * @return - returns the stock item to symbolise it being given to patient
     */
    public StockItem removeFromStock(String name, int quantity)
    {
        return authorisingSecretary.requestStock(name, quantity);
    }
    
    /**
     * returns just the stock name from an item of stock
     * @param strStock - the list item
     * @return - the name of the stock item
     */
    public String getStockName(String strStock)
    {
        String[] splitString = strStock.split(":");
        return splitString[0];
    }
    
    /**
     * secretary can view a list of patient accounts
     * @return - returns a list of patient account information
     */
    public String[] viewPatientAccounts()
    {
        return authorisingSecretary.viewAccounts(AccountType.PATIENT);
    }
    
    /**
     * secretary can view a list of doctor accounts when confirming an appointment
     * @return - returns the list of doctor accounts
     */
    public String[] viewDoctorAccounts()
    {
        return authorisingSecretary.viewAccounts(AccountType.DOCTOR);
    }
    
    /**
     * alongside processing delete requests, secretaries can manually delete a patient
     * account
     * @param strAccount - the account information of that to remove
     */
    public void deleteAccount(String strAccount)
    {
        authorisingSecretary.removeAccount(strAccount);
    }
    
    /**
     * when confirming an appointment, the secretary can view a doctors availability
     * to choose a free date
     * @param strDoctor - doctor who's schedule is being inspected
     * @return - returns the list of doctor free dates
     */
    public String[] viewDoctorFreeDays(String strDoctor)
    {
        AccountAdapter adapter = new AccountAdapter(strDoctor);
        Doctor doctor = (Doctor)adapter.convert();
        
        return doctor.viewFreeDates();
    }
    
    /**
     * used by secretary to confirm an appointment
     * @param request - the request made by the patient
     * @param assignedDoctor - the doctor that the secretary chose
     * @param assignedDate - the date that the doctor chose
     * @return - returns an authorising message
     */
    public String scheduleAppointment(String request, String assignedDoctor, String assignedDate)
    {
        return authorisingSecretary.authoriseRequest(request, assignedDoctor, assignedDate);
    }
}
