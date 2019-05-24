/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities.serialised;

import accounts.Account;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * a list of all accounts stored in the program
 * @author Anthony
 */
public class AccountSingleton implements Serializable{
    private ArrayList<Account> accounts;
    private static AccountSingleton instance = null;
    
    private static final Compilation c = new Compilation();
    
    private AccountSingleton()
    {
        accounts = new ArrayList<>();
    }
    
    /**
     * this is a singleton, and this method returns the active instance
     * @return - returns active instance
     */
    public static AccountSingleton getOrCreate()
    {
        if (instance == null)
            instance = new AccountSingleton();

        return instance;
    }
    
    /**
     * tracks a new account
     * @param a - the account to add to the singleton
     */
    public void add(Account a)
    {
        accounts.add(a);
        //System.out.println("Account of " + a.getFirstName() + " " + a.getSurname() + " tracked");
       
        
        c.construct();
        //System.out.println("Writing - Add acct");
    }
    
    /**
     * untracks an account
     * @param a - the account to remove
     */
    public void remove(Account a)
    {
        if (accounts.contains(a))
        {
            accounts.remove(a);
            //System.out.println("Account of " + a.getFirstName() + " " + a.getSurname() + " removed");
        }
        c.construct();
        //System.out.println("Writing - Remove acct");
    }

    /**
     * standard accessor
     * @return - the list of stored accounts
     */
    public ArrayList<Account> getAccounts() {
        return accounts;
    }

    /**
     * mutator - while this does break the singleton principle, it is only ever used
     * on deserialisation and overwrites the currently active instance
     * @param accounts - the new list to assign
     */
    public void setAccounts(ArrayList<Account> accounts) {
        this.accounts = accounts;
    }  
    
    /**
     * used for debugging
     */
    public void printAccounts()
    {
        //c.deconstruct();
        //System.out.println("Reading - print accts");
        
        //System.out.println("Accounts:");
        //for (Account a : accounts)
         //   System.out.println(a.getFirstName() + " " + a.getSurname() + ": " + a.getUniqueId() + ", " + a.getPassword() + ", " + a.getAccountType());
    }
}
