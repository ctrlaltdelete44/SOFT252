/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import accounts.Account;
import utilities.serialised.AccountSingleton;

/**
 * an adapter that retrieves an account reference from a given unique id
 * @author aedavies1
 */
public class AccountAdapter implements IConvert {
    private final String inputString;
    
    /**
     * on creating, is assigned a string containing the unique id to search for
     * @param input - the string containing a unique id
     */
    public AccountAdapter(String input)
    {
        inputString = input;
    }
    
    /**
     * on converting, loops through the list of all accounts until it finds a match
     * @return - returns a reference to the target account or null if not found
     */
    @Override
    public Account convert()
    {
        //String[] splitString = inputString.split(":");
        for (Account a : AccountSingleton.getOrCreate().getAccounts())
        {
           if (inputString.contains(a.getUniqueId()))
               return a;
        }
        return null;
    }
}
