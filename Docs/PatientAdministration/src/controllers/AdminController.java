/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import utilities.accounts.AccountType;
import accounts.Admin;
import accounts.Doctor;
import utilities.AccountAdapter;

/**
 * the controller that handles admin-specific functionality
 * @author Anthony
 */
public class AdminController {
    private Admin authorisingAdmin;
    private static AdminController instance = null;
    
    private AdminController()
    {        
    }
    
    /**
     * admin controller kept as a singleton to preserve the authorising admin field
     * this returns the active instance
     * @return - returns the active instance
     */
    public static AdminController getOrCreate()
    {
        if (instance == null)
            instance = new AdminController();
        return instance;
    }
    
    /**
     * @return - returns a list of doctors as a string array for use by jlist
     */
    public String[] viewDoctors()
    {
        return authorisingAdmin.viewAccounts(AccountType.DOCTOR);
    }

    /**
     * returns a list of secretaries as a string array for use by jlist
     * @return - returns the string array
     */
    public String[] viewSecretaries()
    {
        return authorisingAdmin.viewAccounts(AccountType.SECRETARY);
    }
    
    /**
     * @return - returns the authorising admin to access their fields
     */
    public Admin getAuthorisingAdmin() {
        return authorisingAdmin;
    }

    /**
     * standard mutator
     * @param authorisingAdmin - the admin to set
     */
    public void setAuthorisingAdmin(Admin authorisingAdmin) {
        this.authorisingAdmin = authorisingAdmin;
    }
    
    /**
     * uses the authorising admin to create an account based on given fields
     * @param first - first name
     * @param last - surname
     * @param address - address
     * @param password - password
     * @param accountType - account type to create
     * @return - returns the new id generated for the admin to inform the user
     */
    public String addAccount(String first, String last, String address, char[] password, String accountType)
    {        
        return authorisingAdmin.createAccount(first, last, address, password, accountType);
    }
    
    /**
     * deletes an account given their information (cotaining their id, which the choice
     * is based on)
     * @param accountInformation - information of that to delete
     */
    public void deleteSelected(String accountInformation)
    {
        authorisingAdmin.deleteAccount(accountInformation);
    }
    
    /**
     * admin can provide feedback to a doctor based on patient comments
     * @param accountInformation - account to send feedback to
     * @param message - message admin has written
     */
    public void giveFeedback(String accountInformation, String message)
    {
        authorisingAdmin.provideFeedback(accountInformation, message);
    }
    
    /**
     * method to return the patients comments on a doctor in a string array
     * for use by a jlist
     * @param strDoctor - the doctor to view feedback of
     * @return - the string array
     */
    public String[] viewFeedback(String strDoctor)
    {
        AccountAdapter adapter = new AccountAdapter(strDoctor);
        Doctor d = (Doctor)adapter.convert();
        return d.viewFeedback();
    }
}
