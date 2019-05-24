/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accounts;

import utilities.accounts.AccountType;
import utilities.accounts.Notification;
import java.io.Serializable;
import java.util.ArrayList;
import utilities.serialised.AccountSingleton;
import utilities.serialised.Compilation;
import utilities.serialised.IdGenerator;

/**
 * abstract superclass containing properties and methods relevant to all accounts
 * @author Anthony
 */
public abstract class Account implements Serializable {
    //these assigned of authorisation of account

    /**
     * the unique id automatically generated and associated with every acct
     */
    protected String uniqueId;

    /**
     * user-chosen password for authentication purposes
     */
    protected String password;
        
    //these variables assigned on creation - account still needs to be authorised after

    /**
     * patients forename
     */
    protected String firstName;

    /**
     * patients surname
     */
    protected String surname;

    /**
     * patients address
     */
    protected String address;

    /**
     * various subclasses need to be serialised, providing an access
     * point to the compilation from all of them enables this
     */
    protected static final Compilation c = new Compilation();
    
    /**
     * all accounts need to be saved to this list on creation,
     * but various accounts need access to it as well
     */
    protected AccountSingleton accounts = AccountSingleton.getOrCreate();
    
    private ArrayList<Notification> notifications = new ArrayList<>();
    
    /**
     * on creation, only basic information is assigned to the account
     * @param first - first name
     * @param last - surname
     * @param address - address
     */
    public Account(String first, String last, String address)
    {
        this.firstName = first;
        this.surname = last;
        this.address = address;
        
        //System.out.println("Account of " + firstName + " created");
    }
    
    /**
     * on authorisation, security information is assigned
     * @param accountType - account type being created, for use in generating id
     * @param pword - password
     */
    public void authorise(AccountType accountType, String pword)
    {
        //assign login credentials
        uniqueId = IdGenerator.generateNextId(accountType);
        password = pword;
        
        //System.out.println("Account of " + firstName + " authorised with password: " + password);
        
        //track account
        accounts.add(this);
        this.addNotification("Account authorised. Welcome, " + firstName);
    }
    
    /**
     * overridden by subclasses to identify their account type
     * @return - returns an enum
     */
    public abstract AccountType getAccountType();

    /**
     * each subclass has different information to display (patients have an age
     * and sex, for example) so by giving the subclasses a method to display their
     * own information you can choose a format based on the type of account
     * @return - returns summary of account
     */
    public abstract String viewAccount();
    
    /**
     * standard getters and setters
     * @return - returns id of account
     */
    public String getUniqueId() {
        return uniqueId;
    }

    /**
     * standard getters and setters
     * @param uniqueId - the id to assign
     */
    public void setUniqueId(String uniqueId) {
        this.uniqueId = uniqueId;
    }

    /**
     * standard getters and setters
     * @return - account password
     */
    public String getPassword() {
        return password;
    }

    /**
     * standard getters and setters
     * @param password - password to assign
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * standard getters and setters
     * @return - account forename
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * standard getters and setters
     * @param firstName - name to assign
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * standard getters and setters
     * @return - account surname
     */
    public String getSurname() {
        return surname;
    }

    /**
     * standard getters and setters
     * @param surname - surname to set
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     * standard getters and setters
     * @return - address
     */
    public String getAddress() {
        return address;
    }

    /**
     * standard getters and setters
     * @param address - address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }
    
    /**
     * all classes have a list of notifications associated with them, and this
     * is an access point for notifications to be added to this
     * @param message - the notification contents
     */
    public void addNotification(String message)
    {
        notifications.add(new Notification(message));
        c.construct();
        //System.out.println("Notification \"" + message + "\" added to " + this.firstName + " " + this.surname + ". There are now " + notifications.size() + " notifications:ACCOUNT");
    }
    
    /**
     * returns notifications in an array so that the ui can display them
     * @return - the array of notifications
     */
    public String[] getNotifications()
    {
        String[] strNotifications = new String[notifications.size()];
               
        for (int i = 0; i < notifications.size(); i++)
        {
            strNotifications[i] = notifications.get(i).getContents();
        }
                
        clearNotifications();
        
        printNotifications();
        
        //c.construct();
        return strNotifications;
    }
    
    
    private void printNotifications()
    {
        //System.out.println("Notifications for " + firstName + " " + surname + ":");
        //for (Notification n : notifications)
            //System.out.println(n.getContents());
    }
    
    private void clearNotifications()
    {
        notifications = new ArrayList<>();
        //System.out.println("Notifications cleared from " + this.firstName + " " + this.surname + ". " + notifications.size() + " stored:ACCOUNT");
        c.construct();
    }

}
