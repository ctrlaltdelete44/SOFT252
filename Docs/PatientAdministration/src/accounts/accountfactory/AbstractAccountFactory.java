/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accounts.accountfactory;

import accounts.Account;
import utilities.accounts.AccountType;
import java.io.Serializable;

/**
 * abstract factory for admin to create accounts
 *
 * @author Anthony
 */
public abstract class AbstractAccountFactory implements Serializable {

    /**
     * the storage place for the created account
     */
    protected Account account;

    /**
     * the abstract method implemented by the concrete factory including all
     * relevant information for account creation
     *
     * @param first - first name
     * @param last - surname
     * @param address - address
     * @param password - password as a string
     * @param accType - account type to create
     * @return - returns the unique id to inform the admin
     */
    public abstract String createAccount(String first, String last, String address, String password, AccountType accType);
}
