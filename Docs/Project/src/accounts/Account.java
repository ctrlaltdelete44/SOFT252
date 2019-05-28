/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accounts;

import utilities.accounts.AccountType;
import java.io.Serializable;
import java.util.ArrayList;
import utilities.ListToArrayAdapter;
import utilities.serialised.AccountSingleton;
//import utilities.serialised.Compilation;
import utilities.serialised.IdGenerator;

/**
 * abstract superclass containing properties and methods relevant to all
 * accounts
 *
 * @author Anthony
 */
public abstract class Account implements Serializable {
    //these assigned of authorisation of account

    /**
     * the unique id automatically generated and associated with every acct
     */
    protected String uniqueId;
    protected String password;
    protected String firstName;
    protected String surname;
    protected String address;

    /**
     * all accounts need to be saved to this list on creation, but various
     * accounts need access to it as well
     */
    protected AccountSingleton accounts = AccountSingleton.getOrCreate();

    private ArrayList<String> notifications = new ArrayList<>();

    /**
     * on creation, only basic information is assigned to the account
     *
     * @param first - first name
     * @param last - surname
     * @param address - address
     */
    public Account(String first, String last, String address) {
        this.firstName = first;
        this.surname = last;
        this.address = address;
    }

    /**
     * on authorisation, security information is assigned
     *
     * @param accountType - account type being created, for use in generating id
     * @param pword - password
     */
    public void authorise(AccountType accountType, String pword) {
        //assign login credentials
        uniqueId = IdGenerator.generateNextId(accountType);
        password = pword;

        //track account
        accounts.addObject(this);
        accounts.saveChanges();
        this.addNotification("Account authorised. Welcome, " + firstName);
    }

    /**
     * overridden by subclasses to identify their account type
     *
     * @return - returns an enum
     */
    public abstract AccountType getAccountType();
    
    /**
     * standard getters and setters
     *
     * @return - returns id of account
     */
    public String getUniqueId() {
        return uniqueId;
    }

    /**
     * standard getters and setters
     *
     * @return - account password
     */
    public String getPassword() {
        return password;
    }

    /**
     * standard getters and setters
     *
     * @return - account forename
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * standard getters and setters
     *
     * @return - account surname
     */
    public String getSurname() {
        return surname;
    }

    /**
     * standard getters and setters
     *
     * @return - address
     */
    public String getAddress() {
        return address;
    }

    /**
     * all classes have a list of notifications associated with them, and this
     * is an access point for notifications to be added to this
     *
     * @param message - the notification contents
     */
    public void addNotification(String message) {
        notifications.add(message);
        accounts.saveChanges();
    }

    /**
     * returns notifications in an array so that the ui can display them
     *
     * @return - the array of notifications
     */
    public String[] getNotifications() {
        String[] strNotifications = new String[notifications.size()];

        for (int i = 0; i < notifications.size(); i++) {
            strNotifications[i] = notifications.get(i);
        }

        clearNotifications();

        return strNotifications;
    }

    private void clearNotifications() {
        notifications = new ArrayList<>();
        accounts.saveChanges();
    }
    
    /**
     * implemented method to view accounts of a specified type
     *
     * @param accountType - admin has access to view secretaries and doctors
     * @return - returns the account information of the accounts the admin can
     * view
     */
    public String[] viewAccounts(AccountType accountType) {
        ArrayList<Object> list = AccountSingleton.getOrCreate().getData(accountType);

        String[] listData = ListToArrayAdapter.convert(list);

        return listData;
    }

}
