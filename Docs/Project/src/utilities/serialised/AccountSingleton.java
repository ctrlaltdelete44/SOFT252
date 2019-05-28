/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities.serialised;

import accounts.Account;
import accounts.accountfactory.ConcreteAccountFactory;
import java.io.Serializable;
import java.util.ArrayList;
import utilities.Serialiser;
import utilities.accounts.AccountType;

/**
 * a list of all accounts stored in the program
 *
 * @author Anthony
 */
public class AccountSingleton implements Serializable, ISerialise {

    private ArrayList<Account> accounts;
    private static AccountSingleton instance = null;

    private AccountSingleton() {
        loadData();
        //accounts = new ArrayList<Account>();
        //saveChanges();
    }

    /**
     * this is a singleton, and this method returns the active instance
     *
     * @return - returns active instance
     */
    public static AccountSingleton getOrCreate() {
        if (instance == null) {
            instance = new AccountSingleton();
        }

        return instance;
    }

    @Override
    public void addObject(Object o) {
        Account a = (Account) o;
        accounts.add(a);
        System.out.println("Account of " + a.getFirstName() + " " + a.getSurname() + " tracked");

        saveChanges();
    }

    @Override
    public void removeObject(Object o) {
        Account a = (Account) o;
        if (accounts.contains(a)) {
            accounts.remove(a);
        }
        saveChanges();
    }

    @Override
    public ArrayList getData() {
        return accounts;
    }
    
    public ArrayList getData(AccountType accountType) {
        ArrayList<Object> retAccounts = new ArrayList<>();

        for (Account a : accounts) {
            if (a.getAccountType() == accountType) {
                retAccounts.add(a);
            }
        }
        return retAccounts;
    }

    @Override
    public void saveChanges() {
        new Serialiser("data/accounts.paa").serialise(accounts);
    }

    @Override
    public void loadData() {
        accounts = (ArrayList<Account>) new Serialiser("data/accounts.paa").deserialise();
    }
}
