/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import accounts.Account;
import java.util.ArrayList;
import utilities.serialised.AccountSingleton;

/**
 * an adapter that retrieves an account reference from a given unique id
 * @author aedavies1
 */
public class AccountAdapter  {
    /**
     * on converting, loops through the list of all accounts until it finds a match
     * @return - returns a reference to the target account or null if not found
     */

    public static Account convert(String inputString)
    {
        for (Account a : (ArrayList<Account>)AccountSingleton.getOrCreate().getData())
        {
           if (inputString.contains(a.getUniqueId()))
               return a;
        }
        return null;
    }
}
