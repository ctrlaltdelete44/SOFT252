/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accounts;

import utilities.accounts.AccountType;
import accounts.accountfactory.*;
import java.io.Serializable;
import java.util.ArrayList;
import utilities.serialised.AccountSingleton;
import utilities.*;
import utilities.accounts.IViewAccounts;

/**
 * admin specific functionalities and information
 *
 * @author Anthony
 */
public class Admin extends Account implements Serializable, IViewAccounts {

    private final AbstractAccountFactory accountFactory = new ConcreteAccountFactory();

    /**
     * on creation, basic information associated with account
     *
     * @param first - first name
     * @param last - surname
     * @param address - address
     */
    public Admin(String first, String last, String address) {
        super(first, last, address);
    }

    /**
     * specifies account as admin
     *
     * @return - returns ADMIN
     */
    @Override
    public AccountType getAccountType() {
        return AccountType.ADMIN;
    }

    /**
     * implemented method to view accounts of a specified type
     *
     * @param accountType - admin has access to view secretaries and doctors
     * @return - returns the account information of the accounts the admin can
     * view
     */
    @Override
    public String[] viewAccounts(AccountType accountType) {
        ArrayList<Account> list = AccountSingleton.getOrCreate().getData();
        ArrayList<String> accountList = new ArrayList<>();

        for (Account a : list) {
            if (a.getAccountType() == accountType) {
                accountList.add(a.viewAccount());
            }
        }

        String[] listData = new String[accountList.size()];
        for (int i = 0; i < accountList.size(); i++) {
            listData[i] = accountList.get(i);
        }
        return listData;
    }

    /**
     * method for admin to create new accounts
     *
     * @param first - first name
     * @param last - surname
     * @param address - address
     * @param arrPassword - password as an array of char as this is how the
     * password box creates it
     * @param strAccountType - the account type to be created
     * @return - returns the id of the new account to inform the owner of it
     */
    public String createAccount(String first, String last, String address, char[] arrPassword, String strAccountType) {
        String strPassword = String.valueOf(arrPassword);

        AccountType accountType = AccountType.valueOf(strAccountType.toUpperCase());

        String newId = accountFactory.createAccount(first, last, address, strPassword, accountType);
        return newId;
    }

    /**
     * admin has rights to delete doctor or secretary accounts
     *
     * @param accountInformation - information of account to delete
     */
    public void deleteAccount(String accountInformation) {
        AccountAdapter aa = new AccountAdapter(accountInformation);
        AccountSingleton.getOrCreate().removeObject(aa.convert());
    }

    /**
     * admin can give doctors feedback based on patient comments
     *
     * @param accountInformation - the account to send feedback to
     * @param message - the message to send
     */
    public void provideFeedback(String accountInformation, String message) {
        AccountAdapter aa = new AccountAdapter(accountInformation);
        Account account = aa.convert();

        account.addNotification(message);
    }

    /**
     * the template for admin information
     *
     * @return - returns summary of account
     */
    @Override
    public String viewAccount() {
        return firstName + " " + surname + ": " + uniqueId;
    }
}
