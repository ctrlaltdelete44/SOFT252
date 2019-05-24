/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import utilities.serialised.AccountSingleton;
import utilities.serialised.RequestSingleton;
import utilities.serialised.StockSingleton;
import utilities.accounts.AccountType;
import accounts.*;
import utilities.serialised.Compilation;

/**
 * the controller for shared and non-account-specific functionalities (ie logging in)
 * @author Anthony
 */
public class Controller {
    private Account loggedIn = null;
    private static Controller instance = null;
    
    private final AdminController adminController = AdminController.getOrCreate();
    private final SecretaryController secretaryController = SecretaryController.getOrCreate();
    private final PatientController patientController = PatientController.getOrCreate();
    private final DoctorController doctorController = DoctorController.getOrCreate();
    
    private final AccountSingleton accounts = AccountSingleton.getOrCreate();
    private final RequestSingleton requests = RequestSingleton.getOrCreate();
    private final StockSingleton stock = StockSingleton.getOrCreate();
    
    private final Compilation c = new Compilation();
    
    private Controller()
    {        
    }
    
    /**
     * kept as a singleton to preserve the logged in account. this returns the active
     * instance
     * @return - returns active instance
     */
    public static Controller getOrCreate()
    {
        if (instance == null)
            instance = new Controller();
        return instance;
    }
    
    /**
     * DEBUG METHOD used to print a report on the stored information
     */
    public void viewAccounts()
    {             
        //accounts.printAccounts();
        //requests.printRequests();
        
        //stock.addStock(new StockItem("Aspirin", 20));
        //stock.addStock(new StockItem("Aspirin", 20));
        //stock.requestStock("Aspirin", 5);
        
        //stock.printStock();
    }
    
    /**
     * method for logging in
     * : deserialises information
     * : loops through stored accounts and compares id and password to that entered
     * : when a match is found, returns the account type so that the ui can
     *      update accordingly
     * : if no match found, returns null so that ui can display an error message
     * @param username - username entered by user
     * @param arrPassword - password entered by user. char array as determined
     *      by password box
     * @return - returns account type of successfully logged in user
     */
    public AccountType login(String username, char[] arrPassword)
    {
        
        c.deconstruct();
        
        //convert char[] to string
        String strPassword = String.valueOf(arrPassword);
        
        //loop through accts
        for (Account a : accounts.getAccounts())
        {
        //if password and login match, login - assign currently logged in, etc, return account type
            if ((a.getUniqueId().contentEquals(username)) && (a.getPassword().contentEquals(strPassword)))
            {
                loggedIn = a;
                
                if (null == a.getAccountType())
                {
                    adminController.setAuthorisingAdmin(null);
                    secretaryController.setAuthorisingSecretary(null);
                    patientController.setAuthorisingPatient(null);
                    doctorController.setAuthorisingDoctor(null);
                }
                else switch (a.getAccountType()) {
                    case ADMIN:
                        //System.out.println("Assigning auth admin");
                        adminController.setAuthorisingAdmin((Admin)a);
                        break;
                    case SECRETARY:
                        //System.out.println("Assigning auth secretary");
                        secretaryController.setAuthorisingSecretary((Secretary)a);
                        break;
                    case PATIENT:
                        //System.out.println("Assigning auth patient");
                        patientController.setAuthorisingPatient((Patient)a);
                        break;
                    case DOCTOR:
                        //System.out.println("Assigning auth doctor");
                        doctorController.setAuthorisingDoctor((Doctor)a);
                        break;
                    default:
                        adminController.setAuthorisingAdmin(null);
                        secretaryController.setAuthorisingSecretary(null);
                        patientController.setAuthorisingPatient(null);
                        doctorController.setAuthorisingDoctor(null);
                        break;
                }
                
               // System.out.println("Returning " + a.getAccountType());
                return a.getAccountType();
            }
        }
        return null;
    }

    /**
     * on logout, will clear references to logged in user and returns the account
     * type for the ui to update accordingly
     * @return  - returns the account type for ui updating
     */
    public AccountType logout()
    {
        AccountType typeToReturn = loggedIn.getAccountType();
        loggedIn = null;
        adminController.setAuthorisingAdmin(null);
        secretaryController.setAuthorisingSecretary(null);
        patientController.setAuthorisingPatient(null);
        doctorController.setAuthorisingDoctor(null);
        
        return typeToReturn;
    }
    
    /**
     * standard accessor
     * @return - returns the logged in account
     */
    public Account getLoggedIn() {
        return loggedIn;
    }
   
    /**
     * returns notifications for logged in user to display on login
     * @return - the array of notifications
     */
    public String[] getNotifications ()
    {
        //System.out.println("Retrieving notifications for " + this.loggedIn.getFirstName() + " " + this.loggedIn.getSurname() + ":CONTROLLER");
        
        String[] notifications = this.loggedIn.getNotifications();        
        
        return notifications;
    }
    
}
